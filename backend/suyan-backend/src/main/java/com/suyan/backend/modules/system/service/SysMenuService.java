package com.suyan.backend.modules.system.service;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.suyan.base.domain.PageResultVo;
import com.suyan.base.util.BeanUtil;
import com.suyan.base.query.SuyanLambdaQueryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.suyan.backend.modules.system.convertor.SysMenuConvertor;
import com.suyan.backend.modules.system.req.SysMenuQueryDto;
import com.suyan.backend.modules.system.model.SysMenu;
import com.suyan.backend.modules.system.req.SysMenuDto;
import com.suyan.backend.modules.system.resp.SysMenuListVo;
import com.suyan.backend.modules.system.resp.SysMenuDetailVo;
import com.suyan.backend.modules.system.repository.SysMenuRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 业务逻辑层-菜单表实现类
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SysMenuService {

    private final SysMenuRepository sysMenuRepository;

    /**
     * 创建菜单表
     */
    @Transactional(rollbackFor = Exception.class)
    public void createSysMenu(SysMenuDto dto) {
        SysMenu sysMenu = SysMenuConvertor.toSysMenu(dto);
        sysMenu.setId(null);
        sysMenuRepository.save(sysMenu);
    }

    /**
     * 更新菜单表
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateSysMenu(SysMenuDto dto) {
        sysMenuRepository.getBaseSysMenu(dto.getId());
        SysMenu sysMenu  = SysMenuConvertor.toSysMenu(dto);
        sysMenuRepository.updateById(sysMenu);
    }

    /**
    * 删除菜单表
    */
    @Transactional(rollbackFor = Exception.class)
    public void deleteSysMenu(Long id) {
        sysMenuRepository.deleteSysMenu(id);
    }

    /**
     * 根据ID获取菜单表信息
     */
    public SysMenuDetailVo getSysMenu(Long id) {
        SysMenu sysMenu = sysMenuRepository.getBaseSysMenu(id);
        return SysMenuConvertor.toSysMenuDetailVo(sysMenu);
    }

    /**
     * 分页查询菜单表信息
     */
    public PageResultVo<SysMenuListVo> pageSysMenu(SysMenuQueryDto queryDTO) {
        Page<SysMenu> page = new Page<>();
        page.setCurrent(queryDTO.getPageNo());
        page.setSize(queryDTO.getPageSize());
        SuyanLambdaQueryWrapper<SysMenu> wrapper = SysMenu.gw();
        wrapper.eqIfPresent(SysMenu::getId, queryDTO.getId());
        wrapper.eqIfPresent(SysMenu::getParentId, queryDTO.getParentId());
        wrapper.likeIfPresent(SysMenu::getMenuName, queryDTO.getMenuName());
        wrapper.eqIfPresent(SysMenu::getMenuType, queryDTO.getMenuType());
        wrapper.likeIfPresent(SysMenu::getMenuPath, queryDTO.getMenuPath());
        wrapper.likeIfPresent(SysMenu::getMenuComponent, queryDTO.getMenuComponent());
        wrapper.likeIfPresent(SysMenu::getMenuIcon, queryDTO.getMenuIcon());
        wrapper.eqIfPresent(SysMenu::getMenuSort, queryDTO.getMenuSort());
        wrapper.likeIfPresent(SysMenu::getMenuPermission, queryDTO.getMenuPermission());
        wrapper.eqIfPresent(SysMenu::getIsEnabled, queryDTO.getIsEnabled());
        wrapper.geIfPresent(SysMenu::getCreateTime, queryDTO.getCreateTimeFrom());
        wrapper.leIfPresent(SysMenu::getCreateTime, queryDTO.getCreateTimeTo());
        wrapper.eqIfPresent(SysMenu::getCreateUserId, queryDTO.getCreateUserId());
        wrapper.geIfPresent(SysMenu::getUpdateTime, queryDTO.getUpdateTimeFrom());
        wrapper.leIfPresent(SysMenu::getUpdateTime, queryDTO.getUpdateTimeTo());
        wrapper.eqIfPresent(SysMenu::getUpdateUserId, queryDTO.getUpdateUserId());
        wrapper.orderByDesc(SysMenu::getId);
        Page<SysMenu> result = sysMenuRepository.page(page, wrapper);
        PageResultVo<SysMenuListVo> queryVo = BeanUtil.pageToPageResultVo(result, SysMenuListVo.class);
        queryVo.setRecords(SysMenuConvertor.toSysMenuListVoList(result.getRecords()));
        return queryVo;
    }

}
