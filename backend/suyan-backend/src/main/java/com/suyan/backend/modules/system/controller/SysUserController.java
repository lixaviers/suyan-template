package com.suyan.backend.modules.system.controller;

import com.suyan.backend.modules.system.domain.dto.SysUserDto;
import com.suyan.backend.modules.system.domain.dto.SysUserQueryDto;
import com.suyan.backend.modules.system.domain.vo.SysUserListVo;
import com.suyan.backend.modules.system.domain.vo.SysUserDetailVo;
import com.suyan.base.domain.PageResultVo;
import com.suyan.base.web.CommonController;
import com.suyan.base.domain.Result;
import com.suyan.backend.modules.system.service.SysUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 请求处理层-用户表管理类
 */
@Slf4j
@RequestMapping("/mg/sysUser")
@RestController
@Tag(name = "用户表-管理接口")
@RequiredArgsConstructor
public class SysUserController extends CommonController {

    private final SysUserService sysUserService;

    @Operation(summary = "新增用户表")
    @PostMapping("add")
    public Result add(@Validated @RequestBody SysUserDto dto) {
        sysUserService.createSysUser(dto);
        return Result.success();
    }

    @Operation(summary = "编辑用户表")
    @PostMapping("update")
    public Result update(@Validated @RequestBody SysUserDto dto) {
        sysUserService.updateSysUser(dto);
        return Result.success();
    }

    @Operation(summary = "删除用户表")
    @PostMapping("delete")
    @Parameter(name = "id", description = "id", required = true)
    public Result delete(@RequestParam Long id) {
        sysUserService.deleteSysUser(id);
        return Result.success();
    }

    @Operation(summary = "获取用户表信息", description = "根据用户表id获取用户表信息")
    @GetMapping("get")
    @Parameter(name = "id", description = "id", required = true)
    public Result<SysUserDetailVo> get(@RequestParam Long id) {
        return Result.success(sysUserService.getSysUser(id));
    }

    @Operation(summary = "分页获取用户表列表信息")
    @PostMapping("page")
    public Result<PageResultVo<SysUserListVo>> pageSysUser(@Validated @RequestBody SysUserQueryDto dto) {
        return Result.success(sysUserService.pageSysUser(dto));
    }

}
