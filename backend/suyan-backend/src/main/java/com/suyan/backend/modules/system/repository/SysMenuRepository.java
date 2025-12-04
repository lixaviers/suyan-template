package com.suyan.backend.modules.system.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.hutool.core.util.ObjectUtil;
import com.suyan.base.exception.ServiceException;
import com.suyan.backend.modules.system.dao.SysMenuMapper;
import com.suyan.backend.modules.system.model.SysMenu;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * 数据仓库层-菜单表实现类
 */
@Slf4j
@Service
public class SysMenuRepository extends ServiceImpl<SysMenuMapper, SysMenu> {

    /**
     * 删除菜单表
     */
    public Boolean deleteSysMenu(Long id) {
        getBaseSysMenu(id);
        return super.removeById(id);
    }

    public SysMenu getBaseSysMenu(Long id) {
        SysMenu sysMenu = super.getById(id);
        if (ObjectUtil.isNull(sysMenu)) {
            throw new ServiceException("菜单表不存在");
        }
        return sysMenu;
    }

    public Map<Long, SysMenu> getByIds(List<Long> ids) {
        List<SysMenu> list = listByIds(ids);
        Map<Long, SysMenu> map = new HashMap<>();
        if (ObjectUtil.isNotEmpty(list)) {
            map = list.stream().collect(Collectors.toMap(SysMenu::getId, bean -> bean));
        }
        return map;
    }

}
