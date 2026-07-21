package com.SpringProject.Lovable_Clone.controller;

import com.SpringProject.Lovable_Clone.dto.member.InviteMemberRequest;
import com.SpringProject.Lovable_Clone.dto.member.MemberResponse;
import com.SpringProject.Lovable_Clone.dto.member.UpdateMemberRoleRequest;
import com.SpringProject.Lovable_Clone.security.AuthUtil;
import com.SpringProject.Lovable_Clone.service.ProjectMemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.SpringProject.Lovable_Clone.security.JwtUserPrincipal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

@RestController
@RequestMapping("/api/projects/{projectId}/members")
@RequiredArgsConstructor
public class ProjectMemberController {

    private final ProjectMemberService projectMemberService;
    private final AuthUtil authUtil;

    @GetMapping
    public ResponseEntity<List<MemberResponse>> getProjectMembers(
            @PathVariable Long projectId,
            @AuthenticationPrincipal JwtUserPrincipal userPrincipal
    ) {
        Long userId = authUtil.getCurrentUserId();
        return ResponseEntity.ok(projectMemberService.getProjectMembers(projectId));
    }

    @PostMapping
    public ResponseEntity<MemberResponse> inviteMember(
            @PathVariable Long projectId,
            @RequestBody @Valid InviteMemberRequest request,
            @AuthenticationPrincipal JwtUserPrincipal userPrincipal
    ) {
        Long userId = authUtil.getCurrentUserId();
        return ResponseEntity.status(HttpStatus.CREATED).body(
                projectMemberService.inviteMember(projectId, request)
        );
    }

    @PatchMapping("/{memberId}")
    public ResponseEntity<MemberResponse> updateMemberRole(
            @PathVariable Long projectId,
            @PathVariable Long memberId,
            @RequestBody @Valid UpdateMemberRoleRequest request,
            @AuthenticationPrincipal JwtUserPrincipal userPrincipal
    ) {
        Long userId = authUtil.getCurrentUserId();
        return ResponseEntity.ok(projectMemberService.updateMemberRole(projectId, memberId, request));
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> removeMember(
            @PathVariable Long projectId,
            @PathVariable Long memberId,
            @AuthenticationPrincipal JwtUserPrincipal userPrincipal
    ) {
        Long userId = authUtil.getCurrentUserId();
        projectMemberService.removeProjectMember(projectId, memberId);
        return ResponseEntity.noContent().build();
    }
}    

