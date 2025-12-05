package com.suyan.backend.modules.system.controller;

import com.suyan.backend.modules.system.domain.dto.LoginDto;
import com.suyan.backend.modules.system.domain.dto.SysUserDto;
import com.suyan.backend.modules.system.service.LoginService;
import com.suyan.backend.modules.system.service.SysUserService;
import com.suyan.base.domain.Result;
import com.suyan.base.web.CommonController;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping
@RestController
@RequiredArgsConstructor
public class LoginController extends CommonController {

    private final LoginService loginService;

    @Operation(summary = "用户登录")
    @PostMapping("login")
    public Result add(@Validated @RequestBody LoginDto dto) {
        loginService.login(dto);
        return Result.success();
    }

}
