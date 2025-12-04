package com.suyan.base.query;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import org.springframework.util.StringUtils;

import java.util.Collection;

public class SuyanLambdaQueryWrapper<T> extends LambdaQueryWrapper<T> {

    public SuyanLambdaQueryWrapper<T> likeIfPresent(SFunction<T, ?> column, String val) {
        if (StringUtils.hasText(val)) {
            return (SuyanLambdaQueryWrapper<T>) super.like(column, val);
        }
        return this;
    }

    public SuyanLambdaQueryWrapper<T> inIfPresent(SFunction<T, ?> column, Collection<?> values) {
        if (ObjectUtil.isAllNotEmpty(values) && !ArrayUtil.isEmpty(values)) {
            return (SuyanLambdaQueryWrapper<T>) super.in(column, values);
        }
        return this;
    }

    public SuyanLambdaQueryWrapper<T> inIfPresent(SFunction<T, ?> column, Object... values) {
        if (ObjectUtil.isAllNotEmpty(values) && !ArrayUtil.isEmpty(values)) {
            return (SuyanLambdaQueryWrapper<T>) super.in(column, values);
        }
        return this;
    }

    public SuyanLambdaQueryWrapper<T> eqIfPresent(SFunction<T, ?> column, Object val) {
        if (ObjectUtil.isNotEmpty(val)) {
            return (SuyanLambdaQueryWrapper<T>) super.eq(column, val);
        }
        return this;
    }

    public SuyanLambdaQueryWrapper<T> neIfPresent(SFunction<T, ?> column, Object val) {
        if (ObjectUtil.isNotEmpty(val)) {
            return (SuyanLambdaQueryWrapper<T>) super.ne(column, val);
        }
        return this;
    }

    public SuyanLambdaQueryWrapper<T> gtIfPresent(SFunction<T, ?> column, Object val) {
        if (val != null) {
            return (SuyanLambdaQueryWrapper<T>) super.gt(column, val);
        }
        return this;
    }

    public SuyanLambdaQueryWrapper<T> geIfPresent(SFunction<T, ?> column, Object val) {
        if (val != null) {
            return (SuyanLambdaQueryWrapper<T>) super.ge(column, val);
        }
        return this;
    }

    public SuyanLambdaQueryWrapper<T> ltIfPresent(SFunction<T, ?> column, Object val) {
        if (val != null) {
            return (SuyanLambdaQueryWrapper<T>) super.lt(column, val);
        }
        return this;
    }

    public SuyanLambdaQueryWrapper<T> leIfPresent(SFunction<T, ?> column, Object val) {
        if (val != null) {
            return (SuyanLambdaQueryWrapper<T>) super.le(column, val);
        }
        return this;
    }

    public SuyanLambdaQueryWrapper<T> betweenIfPresent(SFunction<T, ?> column, Object val1, Object val2) {
        if (val1 != null && val2 != null) {
            return (SuyanLambdaQueryWrapper<T>) super.between(column, val1, val2);
        }
        if (val1 != null) {
            return (SuyanLambdaQueryWrapper<T>) ge(column, val1);
        }
        if (val2 != null) {
            return (SuyanLambdaQueryWrapper<T>) le(column, val2);
        }
        return this;
    }


}
