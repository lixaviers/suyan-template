package com.suyan.backend.modules.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.suyan.backend.modules.system.domain.model.SysUserRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据持久层-用户角色关联表管理类
 */
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {


}
