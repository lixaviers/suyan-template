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
@Schema(description = "角色表入参")
public class SysRoleDto implements Serializable {

    private static final long serialVersionUID = 1L;


    @Schema(description = "角色id", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;

    @Schema(description = "角色编码, 不能超过50位", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "角色编码不能为空")
    @NotEmpty(message = "角色编码不能为空")
    @Size(max = 50, message = "角色编码不能超过50位")
    private String roleCode;

    @Schema(description = "角色名称, 不能超过50位", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "角色名称不能为空")
    @NotEmpty(message = "角色名称不能为空")
    @Size(max = 50, message = "角色名称不能超过50位")
    private String roleName;

    @Schema(description = "角色描述, 不能超过255位")
    @Size(max = 255, message = "角色描述不能超过255位")
    private String remarks;

    @Schema(description = "是否启用", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "是否启用不能为空")
    private Byte isEnabled;








}
