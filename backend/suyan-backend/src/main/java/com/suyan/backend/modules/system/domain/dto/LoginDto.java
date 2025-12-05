package com.suyan.backend.modules.system.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Schema(description = "用户入参")
public class LoginDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "用户账号, 不能超过50位", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "用户账号不能为空")
    private String userAccount;

    @Schema(description = "密码, 不能超过100位", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "密码不能为空")
    private String userPassword;


}
