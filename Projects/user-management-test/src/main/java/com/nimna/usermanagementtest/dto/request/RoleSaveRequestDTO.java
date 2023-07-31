package com.nimna.usermanagementtest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RoleSaveRequestDTO {
    @NotEmpty(message = "Role name required!")
    private String roleName;

    private String roleDescription;
}
