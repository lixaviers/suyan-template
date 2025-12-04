package com.suyan.backend.modules.system.req;

import com.suyan.base.domain.QueryDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "菜单表查询入参")
public class SysMenuQueryDto extends QueryDto {

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

    @Schema(description = "创建时间起")
    private LocalDateTime createTimeFrom;

    @Schema(description = "创建时间止")
    private LocalDateTime createTimeTo;

    @Schema(description = "创建人id")
    private Long createUserId;

    @Schema(description = "更新时间起")
    private LocalDateTime updateTimeFrom;

    @Schema(description = "更新时间止")
    private LocalDateTime updateTimeTo;

    @Schema(description = "更新人id")
    private Long updateUserId;



}
