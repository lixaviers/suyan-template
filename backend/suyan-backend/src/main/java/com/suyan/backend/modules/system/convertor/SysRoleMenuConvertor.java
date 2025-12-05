package com.suyan.backend.modules.system.convertor;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.suyan.backend.modules.system.domain.model.SysRoleMenu;
import com.suyan.backend.modules.system.domain.dto.SysRoleMenuDto;
import com.suyan.backend.modules.system.domain.vo.SysRoleMenuDetailVo;
import com.suyan.backend.modules.system.domain.vo.SysRoleMenuListVo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 角色菜单关联表对象相互转换
 */
public abstract class SysRoleMenuConvertor {

    public static SysRoleMenuListVo toSysRoleMenuListVo(SysRoleMenu sysRoleMenu) {
        if (Objects.isNull(sysRoleMenu)) {
            return null;
        }
        SysRoleMenuListVo vo = BeanUtil.copyProperties(sysRoleMenu, SysRoleMenuListVo.class);
        return vo;
    }

    public static SysRoleMenuDetailVo toSysRoleMenuDetailVo(SysRoleMenu sysRoleMenu) {
        if (Objects.isNull(sysRoleMenu)) {
            return null;
        }
        SysRoleMenuDetailVo vo = BeanUtil.copyProperties(sysRoleMenu, SysRoleMenuDetailVo.class);
        return vo;
    }

    public static List<SysRoleMenuListVo> toSysRoleMenuListVoList(List<SysRoleMenu> sysRoleMenuList) {
        if (ObjectUtil.isEmpty(sysRoleMenuList)) {
            return new ArrayList<>();
        }
        List<SysRoleMenuListVo> voList = new ArrayList<>(sysRoleMenuList.size());
        for (SysRoleMenu sysRoleMenu : sysRoleMenuList) {
            voList.add(toSysRoleMenuListVo(sysRoleMenu));
        }
        return voList;
    }

    public static SysRoleMenu toSysRoleMenu(SysRoleMenuDto dto) {
        if (Objects.isNull(dto)) {
            return null;
        }
        SysRoleMenu sysRoleMenu = BeanUtil.copyProperties(dto, SysRoleMenu.class);
        return sysRoleMenu;
    }

    public static List<SysRoleMenu> toSysRoleMenuList(List<SysRoleMenuDto> dtoList) {
        if (ObjectUtil.isEmpty(dtoList)) {
            return new ArrayList<>();
        }
        List<SysRoleMenu> sysRoleMenuList = new ArrayList<>(dtoList.size());
        for (SysRoleMenuDto dto : dtoList) {
            sysRoleMenuList.add(toSysRoleMenu(dto));
        }
        return sysRoleMenuList;
    }

}
