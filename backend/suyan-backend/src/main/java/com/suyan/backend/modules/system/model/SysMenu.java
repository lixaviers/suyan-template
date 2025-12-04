package com.suyan.backend.modules.system.model;

import com.baomidou.mybatisplus.annotation.*;
import com.suyan.base.query.SuyanLambdaQueryWrapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@TableName("sys_menu")
public class SysMenu {

    public static final SuyanLambdaQueryWrapper<SysMenu> gw() {
        return new SuyanLambdaQueryWrapper<>();
    }

    /**
     * 菜单id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 父菜单id
     */
    @TableField(value = "parent_id")
    private Long parentId;

    /**
     * 菜单名称
     */
    @TableField(value = "menu_name")
    private String menuName;

    /**
     * 菜单类型
     */
    @TableField(value = "menu_type")
    private Byte menuType;

    /**
     * 路由路径
     */
    @TableField(value = "menu_path")
    private String menuPath;

    /**
     * 组件路径
     */
    @TableField(value = "menu_component")
    private String menuComponent;

    /**
     * 图标
     */
    @TableField(value = "menu_icon")
    private String menuIcon;

    /**
     * 排序
     */
    @TableField(value = "menu_sort")
    private Integer menuSort;

    /**
     * 权限标识
     */
    @TableField(value = "menu_permission")
    private String menuPermission;

    /**
     * 是否启用
     */
    @TableField(value = "is_enabled")
    private Byte isEnabled;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 创建人id
     */
    @TableField(value = "create_user_id", fill = FieldFill.INSERT)
    private Long createUserId;

    /**
     * 创建人昵称
     */
    @TableField(value = "create_nick_name", fill = FieldFill.INSERT)
    private String createNickName;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    /**
     * 更新人id
     */
    @TableField(value = "update_user_id", fill = FieldFill.UPDATE)
    private Long updateUserId;

    /**
     * 更新人昵称
     */
    @TableField(value = "update_nick_name", fill = FieldFill.UPDATE)
    private String updateNickName;

    /**
     * 是否删除
     */
    @TableLogic
    @TableField(value = "is_deleted")
    private Byte isDeleted;


}
