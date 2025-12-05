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
@Schema(description = "角色菜单关联表入参")
public class SysRoleMenuDto implements Serializable {

    private static final long serialVersionUID = 1L;


    @Schema(description = "主键id", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;

    @Schema(description = "角色id", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "角色id不能为空")
    private Long roleId;

    @Schema(description = "菜单id", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "菜单id不能为空")
    private Long menuId;








}
