package com.suyan.backend.modules.system.service;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.suyan.base.domain.PageResultVo;
import com.suyan.base.util.BeanUtil;
import com.suyan.base.query.SuyanLambdaQueryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.suyan.backend.modules.system.convertor.SysRoleMenuConvertor;
import com.suyan.backend.modules.system.domain.dto.SysRoleMenuQueryDto;
import com.suyan.backend.modules.system.domain.model.SysRoleMenu;
import com.suyan.backend.modules.system.domain.dto.SysRoleMenuDto;
import com.suyan.backend.modules.system.domain.vo.SysRoleMenuListVo;
import com.suyan.backend.modules.system.domain.vo.SysRoleMenuDetailVo;
import com.suyan.backend.modules.system.repository.SysRoleMenuRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 业务逻辑层-角色菜单关联表实现类
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SysRoleMenuService {

    private final SysRoleMenuRepository sysRoleMenuRepository;

    /**
     * 创建角色菜单关联表
     */
    @Transactional(rollbackFor = Exception.class)
    public void createSysRoleMenu(SysRoleMenuDto dto) {
        SysRoleMenu sysRoleMenu = SysRoleMenuConvertor.toSysRoleMenu(dto);
        sysRoleMenu.setId(null);
        sysRoleMenuRepository.save(sysRoleMenu);
    }

    /**
     * 更新角色菜单关联表
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateSysRoleMenu(SysRoleMenuDto dto) {
        sysRoleMenuRepository.getBaseSysRoleMenu(dto.getId());
        SysRoleMenu sysRoleMenu  = SysRoleMenuConvertor.toSysRoleMenu(dto);
        sysRoleMenuRepository.updateById(sysRoleMenu);
    }

    /**
    * 删除角色菜单关联表
    */
    @Transactional(rollbackFor = Exception.class)
    public void deleteSysRoleMenu(Long id) {
        sysRoleMenuRepository.deleteSysRoleMenu(id);
    }

    /**
     * 根据ID获取角色菜单关联表信息
     */
    public SysRoleMenuDetailVo getSysRoleMenu(Long id) {
        SysRoleMenu sysRoleMenu = sysRoleMenuRepository.getBaseSysRoleMenu(id);
        return SysRoleMenuConvertor.toSysRoleMenuDetailVo(sysRoleMenu);
    }

    /**
     * 分页查询角色菜单关联表信息
     */
    public PageResultVo<SysRoleMenuListVo> pageSysRoleMenu(SysRoleMenuQueryDto queryDTO) {
        Page<SysRoleMenu> page = new Page<>();
        page.setCurrent(queryDTO.getPageNo());
        page.setSize(queryDTO.getPageSize());
        SuyanLambdaQueryWrapper<SysRoleMenu> wrapper = SysRoleMenu.gw();
        wrapper.eqIfPresent(SysRoleMenu::getId, queryDTO.getId());
        wrapper.eqIfPresent(SysRoleMenu::getRoleId, queryDTO.getRoleId());
        wrapper.eqIfPresent(SysRoleMenu::getMenuId, queryDTO.getMenuId());
        wrapper.geIfPresent(SysRoleMenu::getCreateTime, queryDTO.getCreateTimeFrom());
        wrapper.leIfPresent(SysRoleMenu::getCreateTime, queryDTO.getCreateTimeTo());
        wrapper.eqIfPresent(SysRoleMenu::getCreateUserId, queryDTO.getCreateUserId());
        wrapper.geIfPresent(SysRoleMenu::getUpdateTime, queryDTO.getUpdateTimeFrom());
        wrapper.leIfPresent(SysRoleMenu::getUpdateTime, queryDTO.getUpdateTimeTo());
        wrapper.eqIfPresent(SysRoleMenu::getUpdateUserId, queryDTO.getUpdateUserId());
        wrapper.orderByDesc(SysRoleMenu::getId);
        Page<SysRoleMenu> result = sysRoleMenuRepository.page(page, wrapper);
        PageResultVo<SysRoleMenuListVo> queryVo = BeanUtil.pageToPageResultVo(result, SysRoleMenuListVo.class);
        queryVo.setRecords(SysRoleMenuConvertor.toSysRoleMenuListVoList(result.getRecords()));
        return queryVo;
    }

}
