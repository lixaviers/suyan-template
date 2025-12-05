package com.suyan.backend.modules.system.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.hutool.core.util.ObjectUtil;
import com.suyan.base.exception.ServiceException;
import com.suyan.backend.modules.system.dao.SysRoleMapper;
import com.suyan.backend.modules.system.domain.model.SysRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * 数据仓库层-角色表实现类
 */
@Slf4j
@Service
public class SysRoleRepository extends ServiceImpl<SysRoleMapper, SysRole> {

    /**
     * 删除角色表
     */
    public Boolean deleteSysRole(Long id) {
        getBaseSysRole(id);
        return super.removeById(id);
    }

    public SysRole getBaseSysRole(Long id) {
        SysRole sysRole = super.getById(id);
        if (ObjectUtil.isNull(sysRole)) {
            throw new ServiceException("角色表不存在");
        }
        return sysRole;
    }

    public Map<Long, SysRole> getByIds(List<Long> ids) {
        List<SysRole> list = listByIds(ids);
        Map<Long, SysRole> map = new HashMap<>();
        if (ObjectUtil.isNotEmpty(list)) {
            map = list.stream().collect(Collectors.toMap(SysRole::getId, bean -> bean));
        }
        return map;
    }

}
