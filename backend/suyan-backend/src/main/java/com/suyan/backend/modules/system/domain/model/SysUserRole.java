package com.suyan.backend.modules.system.domain.model;

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
@TableName("sys_user_role")
public class SysUserRole {

    public static final SuyanLambdaQueryWrapper<SysUserRole> gw() {
        return new SuyanLambdaQueryWrapper<>();
    }

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 角色id
     */
    @TableField(value = "role_id")
    private Long roleId;

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
