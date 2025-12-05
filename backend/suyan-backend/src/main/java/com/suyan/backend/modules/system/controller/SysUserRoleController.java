package com.suyan.backend.modules.system.controller;

import com.suyan.backend.modules.system.domain.dto.SysUserRoleDto;
import com.suyan.backend.modules.system.domain.dto.SysUserRoleQueryDto;
import com.suyan.backend.modules.system.domain.vo.SysUserRoleListVo;
import com.suyan.backend.modules.system.domain.vo.SysUserRoleDetailVo;
import com.suyan.base.domain.PageResultVo;
import com.suyan.base.web.CommonController;
import com.suyan.base.domain.Result;
import com.suyan.backend.modules.system.service.SysUserRoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 请求处理层-用户角色关联表管理类
 */
@Slf4j
@RequestMapping("/mg/sysUserRole")
@RestController
@Tag(name = "用户角色关联表-管理接口")
@RequiredArgsConstructor
public class SysUserRoleController extends CommonController {

    private final SysUserRoleService sysUserRoleService;

    @Operation(summary = "新增用户角色关联表")
    @PostMapping("add")
    public Result add(@Validated @RequestBody SysUserRoleDto dto) {
        sysUserRoleService.createSysUserRole(dto);
        return Result.success();
    }

    @Operation(summary = "编辑用户角色关联表")
    @PostMapping("update")
    public Result update(@Validated @RequestBody SysUserRoleDto dto) {
        sysUserRoleService.updateSysUserRole(dto);
        return Result.success();
    }

    @Operation(summary = "删除用户角色关联表")
    @PostMapping("delete")
    @Parameter(name = "id", description = "id", required = true)
    public Result delete(@RequestParam Long id) {
        sysUserRoleService.deleteSysUserRole(id);
        return Result.success();
    }

    @Operation(summary = "获取用户角色关联表信息", description = "根据用户角色关联表id获取用户角色关联表信息")
    @GetMapping("get")
    @Parameter(name = "id", description = "id", required = true)
    public Result<SysUserRoleDetailVo> get(@RequestParam Long id) {
        return Result.success(sysUserRoleService.getSysUserRole(id));
    }

    @Operation(summary = "分页获取用户角色关联表列表信息")
    @PostMapping("page")
    public Result<PageResultVo<SysUserRoleListVo>> pageSysUserRole(@Validated @RequestBody SysUserRoleQueryDto dto) {
        return Result.success(sysUserRoleService.pageSysUserRole(dto));
    }

}
