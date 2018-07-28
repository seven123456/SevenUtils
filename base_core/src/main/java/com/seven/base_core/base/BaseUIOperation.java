package com.seven.base_core.base;

import android.os.Bundle;
import android.view.View;

/**
 * Created  on 2018/7/26.
 * author:seven
 * email:seven2016s@163.com
 * activity fragment统一的一些操作方法
 */
public interface BaseUIOperation {
    /**
     * 返回activity的布局文件
     */
    int getContentViewResId();

    /**
     * 查找子控件并且初始化
     * @param bundle 保留一些状态，数据
     */
    void initView(Bundle bundle);

    /**
     * 设置监听器
     */
    void initListener();

    /**
     * 初始化数据
     */
    void initData();

    /**
     * 由子类处理点击事件
     * @param v 点击的控件
     */
    void widgetClick(View v);

    /*增加钩子控制页面是否沉浸式,
    *子类可自行决定是否要沉浸式
    * */
    boolean isNeedTranslateBar();
}
