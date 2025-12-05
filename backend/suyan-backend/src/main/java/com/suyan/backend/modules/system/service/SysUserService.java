package com.suyan.backend.modules.system.service;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.suyan.base.domain.PageResultVo;
import com.suyan.base.util.BeanUtil;
import com.suyan.base.query.SuyanLambdaQueryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.suyan.backend.modules.system.convertor.SysUserConvertor;
import com.suyan.backend.modules.system.domain.dto.SysUserQueryDto;
import com.suyan.backend.modules.system.domain.model.SysUser;
import com.suyan.backend.modules.system.domain.dto.SysUserDto;
import com.suyan.backend.modules.system.domain.vo.SysUserListVo;
import com.suyan.backend.modules.system.domain.vo.SysUserDetailVo;
import com.suyan.backend.modules.system.repository.SysUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 业务逻辑层-用户表实现类
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SysUserService {

    private final SysUserRepository sysUserRepository;

    /**
     * 创建用户表
     */
    @Transactional(rollbackFor = Exception.class)
    public void createSysUser(SysUserDto dto) {
        SysUser sysUser = SysUserConvertor.toSysUser(dto);
        sysUser.setId(null);
        sysUserRepository.save(sysUser);
    }

    /**
     * 更新用户表
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateSysUser(SysUserDto dto) {
        sysUserRepository.getBaseSysUser(dto.getId());
        SysUser sysUser  = SysUserConvertor.toSysUser(dto);
        sysUserRepository.updateById(sysUser);
    }

    /**
    * 删除用户表
    */
    @Transactional(rollbackFor = Exception.class)
    public void deleteSysUser(Long id) {
        sysUserRepository.deleteSysUser(id);
    }

    /**
     * 根据ID获取用户表信息
     */
    public SysUserDetailVo getSysUser(Long id) {
        SysUser sysUser = sysUserRepository.getBaseSysUser(id);
        return SysUserConvertor.toSysUserDetailVo(sysUser);
    }

    /**
     * 分页查询用户表信息
     */
    public PageResultVo<SysUserListVo> pageSysUser(SysUserQueryDto queryDTO) {
        Page<SysUser> page = new Page<>();
        page.setCurrent(queryDTO.getPageNo());
        page.setSize(queryDTO.getPageSize());
        SuyanLambdaQueryWrapper<SysUser> wrapper = SysUser.gw();
        wrapper.eqIfPresent(SysUser::getId, queryDTO.getId());
        wrapper.likeIfPresent(SysUser::getUserAccount, queryDTO.getUserAccount());
        wrapper.likeIfPresent(SysUser::getUserPassword, queryDTO.getUserPassword());
        wrapper.likeIfPresent(SysUser::getUserNickname, queryDTO.getUserNickname());
        wrapper.likeIfPresent(SysUser::getUserEmail, queryDTO.getUserEmail());
        wrapper.likeIfPresent(SysUser::getUserPhone, queryDTO.getUserPhone());
        wrapper.eqIfPresent(SysUser::getIsEnabled, queryDTO.getIsEnabled());
        wrapper.geIfPresent(SysUser::getCreateTime, queryDTO.getCreateTimeFrom());
        wrapper.leIfPresent(SysUser::getCreateTime, queryDTO.getCreateTimeTo());
        wrapper.eqIfPresent(SysUser::getCreateUserId, queryDTO.getCreateUserId());
        wrapper.geIfPresent(SysUser::getUpdateTime, queryDTO.getUpdateTimeFrom());
        wrapper.leIfPresent(SysUser::getUpdateTime, queryDTO.getUpdateTimeTo());
        wrapper.eqIfPresent(SysUser::getUpdateUserId, queryDTO.getUpdateUserId());
        wrapper.orderByDesc(SysUser::getId);
        Page<SysUser> result = sysUserRepository.page(page, wrapper);
        PageResultVo<SysUserListVo> queryVo = BeanUtil.pageToPageResultVo(result, SysUserListVo.class);
        queryVo.setRecords(SysUserConvertor.toSysUserListVoList(result.getRecords()));
        return queryVo;
    }

}
