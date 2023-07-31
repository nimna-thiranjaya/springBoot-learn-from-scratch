package com.nimna.usermanagementtest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RoleResponseDTO {
    private String roleName;
    private String roleDescription;
    private int roleStatus;
}
