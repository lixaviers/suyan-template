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
@Schema(description = "菜单表入参")
public class SysMenuDto implements Serializable {

    private static final long serialVersionUID = 1L;


    @Schema(description = "菜单id", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;

    @Schema(description = "父菜单id", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "父菜单id不能为空")
    private Long parentId;

    @Schema(description = "菜单名称, 不能超过50位", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "菜单名称不能为空")
    @NotEmpty(message = "菜单名称不能为空")
    @Size(max = 50, message = "菜单名称不能超过50位")
    private String menuName;

    @Schema(description = "菜单类型", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "菜单类型不能为空")
    private Byte menuType;

    @Schema(description = "路由路径, 不能超过200位")
    @Size(max = 200, message = "路由路径不能超过200位")
    private String menuPath;

    @Schema(description = "组件路径, 不能超过200位")
    @Size(max = 200, message = "组件路径不能超过200位")
    private String menuComponent;

    @Schema(description = "图标, 不能超过50位")
    @Size(max = 50, message = "图标不能超过50位")
    private String menuIcon;

    @Schema(description = "排序", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "排序不能为空")
    private Integer menuSort;

    @Schema(description = "权限标识, 不能超过255位")
    @Size(max = 255, message = "权限标识不能超过255位")
    private String menuPermission;

    @Schema(description = "是否启用", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "是否启用不能为空")
    private Byte isEnabled;








}
