package com.suyan.backend.modules.system.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Schema(description = "用户角色关联表入参")
public class SysUserRoleDto implements Serializable {

    private static final long serialVersionUID = 1L;


    @Schema(description = "主键id", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;

    @Schema(description = "用户id", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "用户id不能为空")
    private Long userId;

    @Schema(description = "角色id", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "角色id不能为空")
    private Long roleId;








}
