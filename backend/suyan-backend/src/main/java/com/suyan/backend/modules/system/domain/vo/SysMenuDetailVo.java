package com.suyan.backend.modules.system.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "菜单表详细出参")
public class SysMenuDetailVo implements Serializable {

    private static final long serialVersionUID = 1L;


    @Schema(description = "菜单id")
    private Long id;

    @Schema(description = "父菜单id")
    private Long parentId;

    @Schema(description = "菜单名称")
    private String menuName;

    @Schema(description = "菜单类型")
    private Byte menuType;

    @Schema(description = "路由路径")
    private String menuPath;

    @Schema(description = "组件路径")
    private String menuComponent;

    @Schema(description = "图标")
    private String menuIcon;

    @Schema(description = "排序")
    private Integer menuSort;

    @Schema(description = "权限标识")
    private String menuPermission;

    @Schema(description = "是否启用")
    private Byte isEnabled;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "创建人id")
    private Long createUserId;

    @Schema(description = "更新时间")
    private LocalDateTime updateTime;

    @Schema(description = "更新人id")
    private Long updateUserId;


}
