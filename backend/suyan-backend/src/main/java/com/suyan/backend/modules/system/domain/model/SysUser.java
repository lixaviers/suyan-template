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
@TableName("sys_user")
public class SysUser {

    public static final SuyanLambdaQueryWrapper<SysUser> gw() {
        return new SuyanLambdaQueryWrapper<>();
    }

    /**
     * 用户id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户账号
     */
    @TableField(value = "user_account")
    private String userAccount;

    /**
     * 密码
     */
    @TableField(value = "user_password")
    private String userPassword;

    /**
     * 用户昵称
     */
    @TableField(value = "user_nickname")
    private String userNickname;

    /**
     * 邮箱
     */
    @TableField(value = "user_email")
    private String userEmail;

    /**
     * 手机号
     */
    @TableField(value = "user_phone")
    private String userPhone;

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
