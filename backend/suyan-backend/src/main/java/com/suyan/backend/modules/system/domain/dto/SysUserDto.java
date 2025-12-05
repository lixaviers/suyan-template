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
@Schema(description = "用户表入参")
public class SysUserDto implements Serializable {

    private static final long serialVersionUID = 1L;


    @Schema(description = "用户id", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;

    @Schema(description = "用户账号, 不能超过50位", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "用户账号不能为空")
    @NotEmpty(message = "用户账号不能为空")
    @Size(max = 50, message = "用户账号不能超过50位")
    private String userAccount;

    @Schema(description = "密码, 不能超过100位", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "密码不能为空")
    @NotEmpty(message = "密码不能为空")
    @Size(max = 100, message = "密码不能超过100位")
    private String userPassword;

    @Schema(description = "用户昵称, 不能超过50位", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "用户昵称不能为空")
    @NotEmpty(message = "用户昵称不能为空")
    @Size(max = 50, message = "用户昵称不能超过50位")
    private String userNickname;

    @Schema(description = "邮箱, 不能超过100位")
    @Size(max = 100, message = "邮箱不能超过100位")
    private String userEmail;

    @Schema(description = "手机号, 不能超过20位")
    @Size(max = 20, message = "手机号不能超过20位")
    private String userPhone;

    @Schema(description = "是否启用", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "是否启用不能为空")
    private Byte isEnabled;








}
