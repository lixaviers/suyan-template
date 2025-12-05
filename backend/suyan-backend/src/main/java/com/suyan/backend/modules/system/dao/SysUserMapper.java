package com.suyan.backend.modules.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.suyan.backend.modules.system.domain.model.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据持久层-用户表管理类
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {


}
