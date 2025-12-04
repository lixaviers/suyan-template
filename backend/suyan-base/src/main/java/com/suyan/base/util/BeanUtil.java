package com.suyan.base.util;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.suyan.base.domain.PageResultVo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BeanUtil {

    public static <S, T> PageResultVo<T> pageToPageResultVo(Page<S> page, Class<T> targetClazz) {
        if (ObjectUtil.isNull(page)) {
            return null;
        }
        PageResultVo<T> result = new PageResultVo();
        result.setPageNo(page.getCurrent());
        result.setPageSize(page.getSize());
        result.setPages(page.getPages());
        result.setTotal(page.getTotal());
        return result;
    }

}
