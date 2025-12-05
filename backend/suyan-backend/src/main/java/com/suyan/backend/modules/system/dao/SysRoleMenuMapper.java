package com.suyan.backend.modules.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.suyan.backend.modules.system.domain.model.SysRoleMenu;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据持久层-角色菜单关联表管理类
 */
@Mapper
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {


}
