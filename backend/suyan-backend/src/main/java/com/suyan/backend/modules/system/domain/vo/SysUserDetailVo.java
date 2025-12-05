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
@Schema(description = "用户表详细出参")
public class SysUserDetailVo implements Serializable {

    private static final long serialVersionUID = 1L;


    @Schema(description = "用户id")
    private Long id;

    @Schema(description = "用户账号")
    private String userAccount;

    @Schema(description = "密码")
    private String userPassword;

    @Schema(description = "用户昵称")
    private String userNickname;

    @Schema(description = "邮箱")
    private String userEmail;

    @Schema(description = "手机号")
    private String userPhone;

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
