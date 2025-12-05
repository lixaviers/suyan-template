package com.suyan.backend.modules.system.service;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.suyan.base.domain.PageResultVo;
import com.suyan.base.util.BeanUtil;
import com.suyan.base.query.SuyanLambdaQueryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.suyan.backend.modules.system.convertor.SysRoleConvertor;
import com.suyan.backend.modules.system.domain.dto.SysRoleQueryDto;
import com.suyan.backend.modules.system.domain.model.SysRole;
import com.suyan.backend.modules.system.domain.dto.SysRoleDto;
import com.suyan.backend.modules.system.domain.vo.SysRoleListVo;
import com.suyan.backend.modules.system.domain.vo.SysRoleDetailVo;
import com.suyan.backend.modules.system.repository.SysRoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 业务逻辑层-角色表实现类
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SysRoleService {

    private final SysRoleRepository sysRoleRepository;

    /**
     * 创建角色表
     */
    @Transactional(rollbackFor = Exception.class)
    public void createSysRole(SysRoleDto dto) {
        SysRole sysRole = SysRoleConvertor.toSysRole(dto);
        sysRole.setId(null);
        sysRoleRepository.save(sysRole);
    }

    /**
     * 更新角色表
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateSysRole(SysRoleDto dto) {
        sysRoleRepository.getBaseSysRole(dto.getId());
        SysRole sysRole  = SysRoleConvertor.toSysRole(dto);
        sysRoleRepository.updateById(sysRole);
    }

    /**
    * 删除角色表
    */
    @Transactional(rollbackFor = Exception.class)
    public void deleteSysRole(Long id) {
        sysRoleRepository.deleteSysRole(id);
    }

    /**
     * 根据ID获取角色表信息
     */
    public SysRoleDetailVo getSysRole(Long id) {
        SysRole sysRole = sysRoleRepository.getBaseSysRole(id);
        return SysRoleConvertor.toSysRoleDetailVo(sysRole);
    }

    /**
     * 分页查询角色表信息
     */
    public PageResultVo<SysRoleListVo> pageSysRole(SysRoleQueryDto queryDTO) {
        Page<SysRole> page = new Page<>();
        page.setCurrent(queryDTO.getPageNo());
        page.setSize(queryDTO.getPageSize());
        SuyanLambdaQueryWrapper<SysRole> wrapper = SysRole.gw();
        wrapper.eqIfPresent(SysRole::getId, queryDTO.getId());
        wrapper.likeIfPresent(SysRole::getRoleCode, queryDTO.getRoleCode());
        wrapper.likeIfPresent(SysRole::getRoleName, queryDTO.getRoleName());
        wrapper.likeIfPresent(SysRole::getRemarks, queryDTO.getRemarks());
        wrapper.eqIfPresent(SysRole::getIsEnabled, queryDTO.getIsEnabled());
        wrapper.geIfPresent(SysRole::getCreateTime, queryDTO.getCreateTimeFrom());
        wrapper.leIfPresent(SysRole::getCreateTime, queryDTO.getCreateTimeTo());
        wrapper.eqIfPresent(SysRole::getCreateUserId, queryDTO.getCreateUserId());
        wrapper.geIfPresent(SysRole::getUpdateTime, queryDTO.getUpdateTimeFrom());
        wrapper.leIfPresent(SysRole::getUpdateTime, queryDTO.getUpdateTimeTo());
        wrapper.eqIfPresent(SysRole::getUpdateUserId, queryDTO.getUpdateUserId());
        wrapper.orderByDesc(SysRole::getId);
        Page<SysRole> result = sysRoleRepository.page(page, wrapper);
        PageResultVo<SysRoleListVo> queryVo = BeanUtil.pageToPageResultVo(result, SysRoleListVo.class);
        queryVo.setRecords(SysRoleConvertor.toSysRoleListVoList(result.getRecords()));
        return queryVo;
    }

}
