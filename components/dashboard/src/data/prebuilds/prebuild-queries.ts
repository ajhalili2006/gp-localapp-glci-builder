/**
 * Copyright (c) 2024 Gitpod GmbH. All rights reserved.
 * Licensed under the GNU Affero General Public License (AGPL).
 * See License.AGPL.txt in the project root for license information.
 */

import { useMutation, useQuery } from "@tanstack/react-query";
import { configurationClient, prebuildClient, stream } from "../../service/public-api";
import { Prebuild, PrebuildPhase_Phase } from "@gitpod/public-api/lib/gitpod/v1/prebuild_pb";
import { ApplicationError, ErrorCodes } from "@gitpod/gitpod-protocol/lib/messaging/error";
import { PlainMessage, toPlainMessage } from "@bufbuild/protobuf";
import { GetConfigurationWebhookActivityStatusResponse } from "@gitpod/public-api/lib/gitpod/v1/configuration_pb";

export function usePrebuildQuery(prebuildId: string) {
    return useQuery<Prebuild, Error>(
        prebuildQueryKey(prebuildId),
        async () => {
            const prebuild = await prebuildClient.getPrebuild({ prebuildId }).then((response) => response.prebuild);
            if (!prebuild) {
                throw new Error("Prebuild not found");
            }

            return prebuild;
        },
        {
            retry: false,
        },
    );
}

function prebuildQueryKey(prebuildId: string) {
    return ["prebuild", prebuildId];
}

export function watchPrebuild(prebuildId: string, cb: (data: Prebuild) => boolean) {
    const disposable = stream(
        (options) => prebuildClient.watchPrebuild({ scope: { case: "prebuildId", value: prebuildId } }, options),
        (resp) => {
            if (resp.prebuild) {
                const done = cb(resp.prebuild);
                if (done) {
                    disposable.dispose();
                }
            }
        },
    );
    return disposable;
}

export function isPrebuildDone(prebuild: Prebuild) {
    switch (prebuild.status?.phase?.name) {
        case PrebuildPhase_Phase.UNSPECIFIED:
        case PrebuildPhase_Phase.QUEUED:
        case PrebuildPhase_Phase.BUILDING:
            return false;
        default:
            return true;
    }
}

export function useCancelPrebuildMutation() {
    return useMutation({
        mutationFn: async (prebuildId: string) => {
            await prebuildClient.cancelPrebuild({ prebuildId });
        },
    });
}

export function useTriggerPrebuildMutation(configurationId?: string, gitRef?: string) {
    return useMutation({
        mutationFn: async () => {
            if (!configurationId) {
                throw new ApplicationError(ErrorCodes.BAD_REQUEST, "prebuild configurationId is missing");
            }

            return prebuildClient.startPrebuild({ configurationId, gitRef }).then((resp) => resp.prebuildId);
        },
    });
}

export function useWebhookActivityStatusQuery(configurationId: string) {
    return useQuery<PlainMessage<GetConfigurationWebhookActivityStatusResponse>, Error>(
        ["webhookActivityStatus", configurationId],
        async () => {
            const resp = await configurationClient.getConfigurationWebhookActivityStatus({ configurationId });
            return toPlainMessage(resp);
        },
        {
            retry: false,
            staleTime: 1000 * 60, // 1 minute
            cacheTime: 1000 * 60 * 15, // 15 minutes
        },
    );
}
