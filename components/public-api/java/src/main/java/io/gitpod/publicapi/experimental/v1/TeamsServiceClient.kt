// Copyright (c) 2025 Gitpod GmbH. All rights reserved.
// Licensed under the GNU Affero General Public License (AGPL).
// See License.AGPL.txt in the project root for license information.

// Code generated by connect-kotlin. DO NOT EDIT.
//
// Source: gitpod/experimental/v1/teams.proto
//
package io.gitpod.publicapi.experimental.v1

import com.connectrpc.Headers
import com.connectrpc.MethodSpec
import com.connectrpc.ProtocolClientInterface
import com.connectrpc.ResponseMessage
import com.connectrpc.StreamType

public class TeamsServiceClient(
  private val client: ProtocolClientInterface,
) : TeamsServiceClientInterface {
  /**
   *  CreateTeam creates a new Team.
   */
  override suspend fun createTeam(request: Teams.CreateTeamRequest, headers: Headers):
      ResponseMessage<Teams.CreateTeamResponse> = client.unary(
    request,
    headers,
    MethodSpec(
    "gitpod.experimental.v1.TeamsService/CreateTeam",
      io.gitpod.publicapi.experimental.v1.Teams.CreateTeamRequest::class,
      io.gitpod.publicapi.experimental.v1.Teams.CreateTeamResponse::class,
      StreamType.UNARY,
    ),
  )


  /**
   *  GetTeam retrieves a single Team.
   */
  override suspend fun getTeam(request: Teams.GetTeamRequest, headers: Headers):
      ResponseMessage<Teams.GetTeamResponse> = client.unary(
    request,
    headers,
    MethodSpec(
    "gitpod.experimental.v1.TeamsService/GetTeam",
      io.gitpod.publicapi.experimental.v1.Teams.GetTeamRequest::class,
      io.gitpod.publicapi.experimental.v1.Teams.GetTeamResponse::class,
      StreamType.UNARY,
    ),
  )


  /**
   *  ListTeams lists the caller has access to.
   */
  override suspend fun listTeams(request: Teams.ListTeamsRequest, headers: Headers):
      ResponseMessage<Teams.ListTeamsResponse> = client.unary(
    request,
    headers,
    MethodSpec(
    "gitpod.experimental.v1.TeamsService/ListTeams",
      io.gitpod.publicapi.experimental.v1.Teams.ListTeamsRequest::class,
      io.gitpod.publicapi.experimental.v1.Teams.ListTeamsResponse::class,
      StreamType.UNARY,
    ),
  )


  /**
   *  DeleteTeam deletes the specified team.
   */
  override suspend fun deleteTeam(request: Teams.DeleteTeamRequest, headers: Headers):
      ResponseMessage<Teams.DeleteTeamResponse> = client.unary(
    request,
    headers,
    MethodSpec(
    "gitpod.experimental.v1.TeamsService/DeleteTeam",
      io.gitpod.publicapi.experimental.v1.Teams.DeleteTeamRequest::class,
      io.gitpod.publicapi.experimental.v1.Teams.DeleteTeamResponse::class,
      StreamType.UNARY,
    ),
  )


  /**
   *  GetTeamInvitation retrieves the invitation for a Team.
   */
  override suspend fun getTeamInvitation(request: Teams.GetTeamInvitationRequest, headers: Headers):
      ResponseMessage<Teams.GetTeamInvitationResponse> = client.unary(
    request,
    headers,
    MethodSpec(
    "gitpod.experimental.v1.TeamsService/GetTeamInvitation",
      io.gitpod.publicapi.experimental.v1.Teams.GetTeamInvitationRequest::class,
      io.gitpod.publicapi.experimental.v1.Teams.GetTeamInvitationResponse::class,
      StreamType.UNARY,
    ),
  )


  /**
   *  JoinTeam makes the caller a TeamMember of the Team.
   */
  override suspend fun joinTeam(request: Teams.JoinTeamRequest, headers: Headers):
      ResponseMessage<Teams.JoinTeamResponse> = client.unary(
    request,
    headers,
    MethodSpec(
    "gitpod.experimental.v1.TeamsService/JoinTeam",
      io.gitpod.publicapi.experimental.v1.Teams.JoinTeamRequest::class,
      io.gitpod.publicapi.experimental.v1.Teams.JoinTeamResponse::class,
      StreamType.UNARY,
    ),
  )


  /**
   *  ResetTeamInvitation resets the invitation_id for a Team.
   */
  override suspend fun resetTeamInvitation(request: Teams.ResetTeamInvitationRequest,
      headers: Headers): ResponseMessage<Teams.ResetTeamInvitationResponse> = client.unary(
    request,
    headers,
    MethodSpec(
    "gitpod.experimental.v1.TeamsService/ResetTeamInvitation",
      io.gitpod.publicapi.experimental.v1.Teams.ResetTeamInvitationRequest::class,
      io.gitpod.publicapi.experimental.v1.Teams.ResetTeamInvitationResponse::class,
      StreamType.UNARY,
    ),
  )


  /**
   *  ListTeamMembers lists the members of a Team.
   */
  override suspend fun listTeamMembers(request: Teams.ListTeamMembersRequest, headers: Headers):
      ResponseMessage<Teams.ListTeamMembersResponse> = client.unary(
    request,
    headers,
    MethodSpec(
    "gitpod.experimental.v1.TeamsService/ListTeamMembers",
      io.gitpod.publicapi.experimental.v1.Teams.ListTeamMembersRequest::class,
      io.gitpod.publicapi.experimental.v1.Teams.ListTeamMembersResponse::class,
      StreamType.UNARY,
    ),
  )


  /**
   *  UpdateTeamMember updates team membership properties.
   */
  override suspend fun updateTeamMember(request: Teams.UpdateTeamMemberRequest, headers: Headers):
      ResponseMessage<Teams.UpdateTeamMemberResponse> = client.unary(
    request,
    headers,
    MethodSpec(
    "gitpod.experimental.v1.TeamsService/UpdateTeamMember",
      io.gitpod.publicapi.experimental.v1.Teams.UpdateTeamMemberRequest::class,
      io.gitpod.publicapi.experimental.v1.Teams.UpdateTeamMemberResponse::class,
      StreamType.UNARY,
    ),
  )


  /**
   *  DeleteTeamMember removes a TeamMember from the Team.
   */
  override suspend fun deleteTeamMember(request: Teams.DeleteTeamMemberRequest, headers: Headers):
      ResponseMessage<Teams.DeleteTeamMemberResponse> = client.unary(
    request,
    headers,
    MethodSpec(
    "gitpod.experimental.v1.TeamsService/DeleteTeamMember",
      io.gitpod.publicapi.experimental.v1.Teams.DeleteTeamMemberRequest::class,
      io.gitpod.publicapi.experimental.v1.Teams.DeleteTeamMemberResponse::class,
      StreamType.UNARY,
    ),
  )

}
