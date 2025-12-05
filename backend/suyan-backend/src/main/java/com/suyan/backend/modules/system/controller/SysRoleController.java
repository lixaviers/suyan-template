package com.suyan.backend.modules.system.controller;

import com.suyan.backend.modules.system.domain.dto.SysRoleDto;
import com.suyan.backend.modules.system.domain.dto.SysRoleQueryDto;
import com.suyan.backend.modules.system.domain.vo.SysRoleListVo;
import com.suyan.backend.modules.system.domain.vo.SysRoleDetailVo;
import com.suyan.base.domain.PageResultVo;
import com.suyan.base.web.CommonController;
import com.suyan.base.domain.Result;
import com.suyan.backend.modules.system.service.SysRoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 请求处理层-角色表管理类
 */
@Slf4j
@RequestMapping("/mg/sysRole")
@RestController
@Tag(name = "角色表-管理接口")
@RequiredArgsConstructor
public class SysRoleController extends CommonController {

    private final SysRoleService sysRoleService;

    @Operation(summary = "新增角色表")
    @PostMapping("add")
    public Result add(@Validated @RequestBody SysRoleDto dto) {
        sysRoleService.createSysRole(dto);
        return Result.success();
    }

    @Operation(summary = "编辑角色表")
    @PostMapping("update")
    public Result update(@Validated @RequestBody SysRoleDto dto) {
        sysRoleService.updateSysRole(dto);
        return Result.success();
    }

    @Operation(summary = "删除角色表")
    @PostMapping("delete")
    @Parameter(name = "id", description = "id", required = true)
    public Result delete(@RequestParam Long id) {
        sysRoleService.deleteSysRole(id);
        return Result.success();
    }

    @Operation(summary = "获取角色表信息", description = "根据角色表id获取角色表信息")
    @GetMapping("get")
    @Parameter(name = "id", description = "id", required = true)
    public Result<SysRoleDetailVo> get(@RequestParam Long id) {
        return Result.success(sysRoleService.getSysRole(id));
    }

    @Operation(summary = "分页获取角色表列表信息")
    @PostMapping("page")
    public Result<PageResultVo<SysRoleListVo>> pageSysRole(@Validated @RequestBody SysRoleQueryDto dto) {
        return Result.success(sysRoleService.pageSysRole(dto));
    }

}
