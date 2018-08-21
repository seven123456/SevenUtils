package com.seven.base_core.utils;

import android.content.Context;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * Created  on 2018/8/21 0021.
 * author:seven
 * email:seven2016s@163.com
 * 写在base_core里面，其他module也可以一起使用
 * 接口交由application去操作并且返回context
 */
public interface IApplicationService extends IProvider {
    Context getApplication();
}
