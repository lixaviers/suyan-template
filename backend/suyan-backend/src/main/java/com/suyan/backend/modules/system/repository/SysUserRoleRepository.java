package com.suyan.backend.modules.system.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.hutool.core.util.ObjectUtil;
import com.suyan.base.exception.ServiceException;
import com.suyan.backend.modules.system.dao.SysUserRoleMapper;
import com.suyan.backend.modules.system.domain.model.SysUserRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * 数据仓库层-用户角色关联表实现类
 */
@Slf4j
@Service
public class SysUserRoleRepository extends ServiceImpl<SysUserRoleMapper, SysUserRole> {

    /**
     * 删除用户角色关联表
     */
    public Boolean deleteSysUserRole(Long id) {
        getBaseSysUserRole(id);
        return super.removeById(id);
    }

    public SysUserRole getBaseSysUserRole(Long id) {
        SysUserRole sysUserRole = super.getById(id);
        if (ObjectUtil.isNull(sysUserRole)) {
            throw new ServiceException("用户角色关联表不存在");
        }
        return sysUserRole;
    }

    public Map<Long, SysUserRole> getByIds(List<Long> ids) {
        List<SysUserRole> list = listByIds(ids);
        Map<Long, SysUserRole> map = new HashMap<>();
        if (ObjectUtil.isNotEmpty(list)) {
            map = list.stream().collect(Collectors.toMap(SysUserRole::getId, bean -> bean));
        }
        return map;
    }

}
