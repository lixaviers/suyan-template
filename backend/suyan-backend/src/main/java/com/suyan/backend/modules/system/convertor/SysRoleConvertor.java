package com.suyan.backend.modules.system.convertor;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.suyan.backend.modules.system.domain.model.SysRole;
import com.suyan.backend.modules.system.domain.dto.SysRoleDto;
import com.suyan.backend.modules.system.domain.vo.SysRoleDetailVo;
import com.suyan.backend.modules.system.domain.vo.SysRoleListVo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 角色表对象相互转换
 */
public abstract class SysRoleConvertor {

    public static SysRoleListVo toSysRoleListVo(SysRole sysRole) {
        if (Objects.isNull(sysRole)) {
            return null;
        }
        SysRoleListVo vo = BeanUtil.copyProperties(sysRole, SysRoleListVo.class);
        return vo;
    }

    public static SysRoleDetailVo toSysRoleDetailVo(SysRole sysRole) {
        if (Objects.isNull(sysRole)) {
            return null;
        }
        SysRoleDetailVo vo = BeanUtil.copyProperties(sysRole, SysRoleDetailVo.class);
        return vo;
    }

    public static List<SysRoleListVo> toSysRoleListVoList(List<SysRole> sysRoleList) {
        if (ObjectUtil.isEmpty(sysRoleList)) {
            return new ArrayList<>();
        }
        List<SysRoleListVo> voList = new ArrayList<>(sysRoleList.size());
        for (SysRole sysRole : sysRoleList) {
            voList.add(toSysRoleListVo(sysRole));
        }
        return voList;
    }

    public static SysRole toSysRole(SysRoleDto dto) {
        if (Objects.isNull(dto)) {
            return null;
        }
        SysRole sysRole = BeanUtil.copyProperties(dto, SysRole.class);
        return sysRole;
    }

    public static List<SysRole> toSysRoleList(List<SysRoleDto> dtoList) {
        if (ObjectUtil.isEmpty(dtoList)) {
            return new ArrayList<>();
        }
        List<SysRole> sysRoleList = new ArrayList<>(dtoList.size());
        for (SysRoleDto dto : dtoList) {
            sysRoleList.add(toSysRole(dto));
        }
        return sysRoleList;
    }

}
