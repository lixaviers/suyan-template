package com.suyan.backend.modules.system.controller;

import com.suyan.backend.modules.system.domain.dto.SysMenuDto;
import com.suyan.backend.modules.system.domain.dto.SysMenuQueryDto;
import com.suyan.backend.modules.system.domain.vo.SysMenuListVo;
import com.suyan.backend.modules.system.domain.vo.SysMenuDetailVo;
import com.suyan.base.domain.PageResultVo;
import com.suyan.base.web.CommonController;
import com.suyan.base.domain.Result;
import com.suyan.backend.modules.system.service.SysMenuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 请求处理层-菜单表管理类
 */
@Slf4j
@RequestMapping("/mg/sysMenu")
@RestController
@Tag(name = "菜单表-管理接口")
@RequiredArgsConstructor
public class SysMenuController extends CommonController {

    private final SysMenuService sysMenuService;

    @Operation(summary = "新增菜单表")
    @PostMapping("add")
    public Result add(@Validated @RequestBody SysMenuDto dto) {
        sysMenuService.createSysMenu(dto);
        return Result.success();
    }

    @Operation(summary = "编辑菜单表")
    @PostMapping("update")
    public Result update(@Validated @RequestBody SysMenuDto dto) {
        sysMenuService.updateSysMenu(dto);
        return Result.success();
    }

    @Operation(summary = "删除菜单表")
    @PostMapping("delete")
    @Parameter(name = "id", description = "id", required = true)
    public Result delete(@RequestParam Long id) {
        sysMenuService.deleteSysMenu(id);
        return Result.success();
    }

    @Operation(summary = "获取菜单表信息", description = "根据菜单表id获取菜单表信息")
    @GetMapping("get")
    @Parameter(name = "id", description = "id", required = true)
    public Result<SysMenuDetailVo> get(@RequestParam Long id) {
        return Result.success(sysMenuService.getSysMenu(id));
    }

    @Operation(summary = "分页获取菜单表列表信息")
    @PostMapping("page")
    public Result<PageResultVo<SysMenuListVo>> pageSysMenu(@Validated @RequestBody SysMenuQueryDto dto) {
        return Result.success(sysMenuService.pageSysMenu(dto));
    }

}
