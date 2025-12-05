package com.suyan.backend.modules.system.service;

import cn.dev33.satoken.stp.StpInterface;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ObjectUtil;
import com.suyan.backend.modules.system.domain.dto.LoginDto;
import com.suyan.backend.modules.system.domain.model.SysUser;
import com.suyan.backend.modules.system.repository.SysUserRepository;
import com.suyan.base.exception.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginService implements StpInterface {

    private final SysUserRepository sysUserRepository;

    @Override
    public List<String> getPermissionList(Object o, String s) {
        return List.of();
    }

    @Override
    public List<String> getRoleList(Object o, String s) {
        return List.of();
    }

    public void login(LoginDto dto) {
        SysUser user = sysUserRepository.getOne(SysUser.gw().eq(SysUser::getUserAccount, dto.getUserAccount()));
        if (ObjectUtil.isNull(user)) {
            throw new ServiceException("账号不存在");
        }
        // todo 密码验证

        StpUtil.login(user.getId());
    }

}
