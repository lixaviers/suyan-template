package com.suyan.backend.modules.system.convertor;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.suyan.backend.modules.system.domain.model.SysUserRole;
import com.suyan.backend.modules.system.domain.dto.SysUserRoleDto;
import com.suyan.backend.modules.system.domain.vo.SysUserRoleDetailVo;
import com.suyan.backend.modules.system.domain.vo.SysUserRoleListVo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 用户角色关联表对象相互转换
 */
public abstract class SysUserRoleConvertor {

    public static SysUserRoleListVo toSysUserRoleListVo(SysUserRole sysUserRole) {
        if (Objects.isNull(sysUserRole)) {
            return null;
        }
        SysUserRoleListVo vo = BeanUtil.copyProperties(sysUserRole, SysUserRoleListVo.class);
        return vo;
    }

    public static SysUserRoleDetailVo toSysUserRoleDetailVo(SysUserRole sysUserRole) {
        if (Objects.isNull(sysUserRole)) {
            return null;
        }
        SysUserRoleDetailVo vo = BeanUtil.copyProperties(sysUserRole, SysUserRoleDetailVo.class);
        return vo;
    }

    public static List<SysUserRoleListVo> toSysUserRoleListVoList(List<SysUserRole> sysUserRoleList) {
        if (ObjectUtil.isEmpty(sysUserRoleList)) {
            return new ArrayList<>();
        }
        List<SysUserRoleListVo> voList = new ArrayList<>(sysUserRoleList.size());
        for (SysUserRole sysUserRole : sysUserRoleList) {
            voList.add(toSysUserRoleListVo(sysUserRole));
        }
        return voList;
    }

    public static SysUserRole toSysUserRole(SysUserRoleDto dto) {
        if (Objects.isNull(dto)) {
            return null;
        }
        SysUserRole sysUserRole = BeanUtil.copyProperties(dto, SysUserRole.class);
        return sysUserRole;
    }

    public static List<SysUserRole> toSysUserRoleList(List<SysUserRoleDto> dtoList) {
        if (ObjectUtil.isEmpty(dtoList)) {
            return new ArrayList<>();
        }
        List<SysUserRole> sysUserRoleList = new ArrayList<>(dtoList.size());
        for (SysUserRoleDto dto : dtoList) {
            sysUserRoleList.add(toSysUserRole(dto));
        }
        return sysUserRoleList;
    }

}
