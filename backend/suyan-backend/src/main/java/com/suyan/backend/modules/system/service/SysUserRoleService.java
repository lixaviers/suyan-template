package com.suyan.backend.modules.system.service;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.suyan.base.domain.PageResultVo;
import com.suyan.base.util.BeanUtil;
import com.suyan.base.query.SuyanLambdaQueryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.suyan.backend.modules.system.convertor.SysUserRoleConvertor;
import com.suyan.backend.modules.system.domain.dto.SysUserRoleQueryDto;
import com.suyan.backend.modules.system.domain.model.SysUserRole;
import com.suyan.backend.modules.system.domain.dto.SysUserRoleDto;
import com.suyan.backend.modules.system.domain.vo.SysUserRoleListVo;
import com.suyan.backend.modules.system.domain.vo.SysUserRoleDetailVo;
import com.suyan.backend.modules.system.repository.SysUserRoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 业务逻辑层-用户角色关联表实现类
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SysUserRoleService {

    private final SysUserRoleRepository sysUserRoleRepository;

    /**
     * 创建用户角色关联表
     */
    @Transactional(rollbackFor = Exception.class)
    public void createSysUserRole(SysUserRoleDto dto) {
        SysUserRole sysUserRole = SysUserRoleConvertor.toSysUserRole(dto);
        sysUserRole.setId(null);
        sysUserRoleRepository.save(sysUserRole);
    }

    /**
     * 更新用户角色关联表
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateSysUserRole(SysUserRoleDto dto) {
        sysUserRoleRepository.getBaseSysUserRole(dto.getId());
        SysUserRole sysUserRole  = SysUserRoleConvertor.toSysUserRole(dto);
        sysUserRoleRepository.updateById(sysUserRole);
    }

    /**
    * 删除用户角色关联表
    */
    @Transactional(rollbackFor = Exception.class)
    public void deleteSysUserRole(Long id) {
        sysUserRoleRepository.deleteSysUserRole(id);
    }

    /**
     * 根据ID获取用户角色关联表信息
     */
    public SysUserRoleDetailVo getSysUserRole(Long id) {
        SysUserRole sysUserRole = sysUserRoleRepository.getBaseSysUserRole(id);
        return SysUserRoleConvertor.toSysUserRoleDetailVo(sysUserRole);
    }

    /**
     * 分页查询用户角色关联表信息
     */
    public PageResultVo<SysUserRoleListVo> pageSysUserRole(SysUserRoleQueryDto queryDTO) {
        Page<SysUserRole> page = new Page<>();
        page.setCurrent(queryDTO.getPageNo());
        page.setSize(queryDTO.getPageSize());
        SuyanLambdaQueryWrapper<SysUserRole> wrapper = SysUserRole.gw();
        wrapper.eqIfPresent(SysUserRole::getId, queryDTO.getId());
        wrapper.eqIfPresent(SysUserRole::getUserId, queryDTO.getUserId());
        wrapper.eqIfPresent(SysUserRole::getRoleId, queryDTO.getRoleId());
        wrapper.geIfPresent(SysUserRole::getCreateTime, queryDTO.getCreateTimeFrom());
        wrapper.leIfPresent(SysUserRole::getCreateTime, queryDTO.getCreateTimeTo());
        wrapper.eqIfPresent(SysUserRole::getCreateUserId, queryDTO.getCreateUserId());
        wrapper.geIfPresent(SysUserRole::getUpdateTime, queryDTO.getUpdateTimeFrom());
        wrapper.leIfPresent(SysUserRole::getUpdateTime, queryDTO.getUpdateTimeTo());
        wrapper.eqIfPresent(SysUserRole::getUpdateUserId, queryDTO.getUpdateUserId());
        wrapper.orderByDesc(SysUserRole::getId);
        Page<SysUserRole> result = sysUserRoleRepository.page(page, wrapper);
        PageResultVo<SysUserRoleListVo> queryVo = BeanUtil.pageToPageResultVo(result, SysUserRoleListVo.class);
        queryVo.setRecords(SysUserRoleConvertor.toSysUserRoleListVoList(result.getRecords()));
        return queryVo;
    }

}
