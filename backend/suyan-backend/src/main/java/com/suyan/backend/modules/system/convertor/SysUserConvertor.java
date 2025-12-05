package com.suyan.backend.modules.system.convertor;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.suyan.backend.modules.system.domain.model.SysUser;
import com.suyan.backend.modules.system.domain.dto.SysUserDto;
import com.suyan.backend.modules.system.domain.vo.SysUserDetailVo;
import com.suyan.backend.modules.system.domain.vo.SysUserListVo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 用户表对象相互转换
 */
public abstract class SysUserConvertor {

    public static SysUserListVo toSysUserListVo(SysUser sysUser) {
        if (Objects.isNull(sysUser)) {
            return null;
        }
        SysUserListVo vo = BeanUtil.copyProperties(sysUser, SysUserListVo.class);
        return vo;
    }

    public static SysUserDetailVo toSysUserDetailVo(SysUser sysUser) {
        if (Objects.isNull(sysUser)) {
            return null;
        }
        SysUserDetailVo vo = BeanUtil.copyProperties(sysUser, SysUserDetailVo.class);
        return vo;
    }

    public static List<SysUserListVo> toSysUserListVoList(List<SysUser> sysUserList) {
        if (ObjectUtil.isEmpty(sysUserList)) {
            return new ArrayList<>();
        }
        List<SysUserListVo> voList = new ArrayList<>(sysUserList.size());
        for (SysUser sysUser : sysUserList) {
            voList.add(toSysUserListVo(sysUser));
        }
        return voList;
    }

    public static SysUser toSysUser(SysUserDto dto) {
        if (Objects.isNull(dto)) {
            return null;
        }
        SysUser sysUser = BeanUtil.copyProperties(dto, SysUser.class);
        return sysUser;
    }

    public static List<SysUser> toSysUserList(List<SysUserDto> dtoList) {
        if (ObjectUtil.isEmpty(dtoList)) {
            return new ArrayList<>();
        }
        List<SysUser> sysUserList = new ArrayList<>(dtoList.size());
        for (SysUserDto dto : dtoList) {
            sysUserList.add(toSysUser(dto));
        }
        return sysUserList;
    }

}
