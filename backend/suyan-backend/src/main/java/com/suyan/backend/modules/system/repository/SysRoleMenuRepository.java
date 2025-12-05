package com.suyan.backend.modules.system.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.hutool.core.util.ObjectUtil;
import com.suyan.base.exception.ServiceException;
import com.suyan.backend.modules.system.dao.SysRoleMenuMapper;
import com.suyan.backend.modules.system.domain.model.SysRoleMenu;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * 数据仓库层-角色菜单关联表实现类
 */
@Slf4j
@Service
public class SysRoleMenuRepository extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> {

    /**
     * 删除角色菜单关联表
     */
    public Boolean deleteSysRoleMenu(Long id) {
        getBaseSysRoleMenu(id);
        return super.removeById(id);
    }

    public SysRoleMenu getBaseSysRoleMenu(Long id) {
        SysRoleMenu sysRoleMenu = super.getById(id);
        if (ObjectUtil.isNull(sysRoleMenu)) {
            throw new ServiceException("角色菜单关联表不存在");
        }
        return sysRoleMenu;
    }

    public Map<Long, SysRoleMenu> getByIds(List<Long> ids) {
        List<SysRoleMenu> list = listByIds(ids);
        Map<Long, SysRoleMenu> map = new HashMap<>();
        if (ObjectUtil.isNotEmpty(list)) {
            map = list.stream().collect(Collectors.toMap(SysRoleMenu::getId, bean -> bean));
        }
        return map;
    }

}
