package com.suyan.backend.modules.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.suyan.backend.modules.system.domain.model.SysRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据持久层-角色表管理类
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {


}
