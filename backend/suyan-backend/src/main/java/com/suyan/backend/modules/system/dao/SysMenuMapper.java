package com.suyan.backend.modules.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.suyan.backend.modules.system.model.SysMenu;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据持久层-菜单表管理类
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {


}
