package com.suyan.backend.modules.system.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.hutool.core.util.ObjectUtil;
import com.suyan.base.exception.ServiceException;
import com.suyan.backend.modules.system.dao.SysUserMapper;
import com.suyan.backend.modules.system.domain.model.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * 数据仓库层-用户表实现类
 */
@Slf4j
@Service
public class SysUserRepository extends ServiceImpl<SysUserMapper, SysUser> {

    /**
     * 删除用户表
     */
    public Boolean deleteSysUser(Long id) {
        getBaseSysUser(id);
        return super.removeById(id);
    }

    public SysUser getBaseSysUser(Long id) {
        SysUser sysUser = super.getById(id);
        if (ObjectUtil.isNull(sysUser)) {
            throw new ServiceException("用户表不存在");
        }
        return sysUser;
    }

    public Map<Long, SysUser> getByIds(List<Long> ids) {
        List<SysUser> list = listByIds(ids);
        Map<Long, SysUser> map = new HashMap<>();
        if (ObjectUtil.isNotEmpty(list)) {
            map = list.stream().collect(Collectors.toMap(SysUser::getId, bean -> bean));
        }
        return map;
    }

}
