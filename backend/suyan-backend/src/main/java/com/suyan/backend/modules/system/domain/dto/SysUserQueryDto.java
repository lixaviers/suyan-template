package com.suyan.backend.modules.system.domain.dto;

import com.suyan.base.domain.QueryDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "用户表查询入参")
public class SysUserQueryDto extends QueryDto {

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
