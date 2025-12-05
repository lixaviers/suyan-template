package com.suyan.backend.modules.system.convertor;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.suyan.backend.modules.system.domain.model.SysMenu;
import com.suyan.backend.modules.system.domain.dto.SysMenuDto;
import com.suyan.backend.modules.system.domain.vo.SysMenuDetailVo;
import com.suyan.backend.modules.system.domain.vo.SysMenuListVo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 菜单表对象相互转换
 */
public abstract class SysMenuConvertor {

    public static SysMenuListVo toSysMenuListVo(SysMenu sysMenu) {
        if (Objects.isNull(sysMenu)) {
            return null;
        }
        SysMenuListVo vo = BeanUtil.copyProperties(sysMenu, SysMenuListVo.class);
        return vo;
    }

    public static SysMenuDetailVo toSysMenuDetailVo(SysMenu sysMenu) {
        if (Objects.isNull(sysMenu)) {
            return null;
        }
        SysMenuDetailVo vo = BeanUtil.copyProperties(sysMenu, SysMenuDetailVo.class);
        return vo;
    }

    public static List<SysMenuListVo> toSysMenuListVoList(List<SysMenu> sysMenuList) {
        if (ObjectUtil.isEmpty(sysMenuList)) {
            return new ArrayList<>();
        }
        List<SysMenuListVo> voList = new ArrayList<>(sysMenuList.size());
        for (SysMenu sysMenu : sysMenuList) {
            voList.add(toSysMenuListVo(sysMenu));
        }
        return voList;
    }

    public static SysMenu toSysMenu(SysMenuDto dto) {
        if (Objects.isNull(dto)) {
            return null;
        }
        SysMenu sysMenu = BeanUtil.copyProperties(dto, SysMenu.class);
        return sysMenu;
    }

    public static List<SysMenu> toSysMenuList(List<SysMenuDto> dtoList) {
        if (ObjectUtil.isEmpty(dtoList)) {
            return new ArrayList<>();
        }
        List<SysMenu> sysMenuList = new ArrayList<>(dtoList.size());
        for (SysMenuDto dto : dtoList) {
            sysMenuList.add(toSysMenu(dto));
        }
        return sysMenuList;
    }

}
