package com.suyan.backend.modules.system.controller;

import com.suyan.backend.modules.system.domain.dto.SysRoleMenuDto;
import com.suyan.backend.modules.system.domain.dto.SysRoleMenuQueryDto;
import com.suyan.backend.modules.system.domain.vo.SysRoleMenuListVo;
import com.suyan.backend.modules.system.domain.vo.SysRoleMenuDetailVo;
import com.suyan.base.domain.PageResultVo;
import com.suyan.base.web.CommonController;
import com.suyan.base.domain.Result;
import com.suyan.backend.modules.system.service.SysRoleMenuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 请求处理层-角色菜单关联表管理类
 */
@Slf4j
@RequestMapping("/mg/sysRoleMenu")
@RestController
@Tag(name = "角色菜单关联表-管理接口")
@RequiredArgsConstructor
public class SysRoleMenuController extends CommonController {

    private final SysRoleMenuService sysRoleMenuService;

    @Operation(summary = "新增角色菜单关联表")
    @PostMapping("add")
    public Result add(@Validated @RequestBody SysRoleMenuDto dto) {
        sysRoleMenuService.createSysRoleMenu(dto);
        return Result.success();
    }

    @Operation(summary = "编辑角色菜单关联表")
    @PostMapping("update")
    public Result update(@Validated @RequestBody SysRoleMenuDto dto) {
        sysRoleMenuService.updateSysRoleMenu(dto);
        return Result.success();
    }

    @Operation(summary = "删除角色菜单关联表")
    @PostMapping("delete")
    @Parameter(name = "id", description = "id", required = true)
    public Result delete(@RequestParam Long id) {
        sysRoleMenuService.deleteSysRoleMenu(id);
        return Result.success();
    }

    @Operation(summary = "获取角色菜单关联表信息", description = "根据角色菜单关联表id获取角色菜单关联表信息")
    @GetMapping("get")
    @Parameter(name = "id", description = "id", required = true)
    public Result<SysRoleMenuDetailVo> get(@RequestParam Long id) {
        return Result.success(sysRoleMenuService.getSysRoleMenu(id));
    }

    @Operation(summary = "分页获取角色菜单关联表列表信息")
    @PostMapping("page")
    public Result<PageResultVo<SysRoleMenuListVo>> pageSysRoleMenu(@Validated @RequestBody SysRoleMenuQueryDto dto) {
        return Result.success(sysRoleMenuService.pageSysRoleMenu(dto));
    }

}
