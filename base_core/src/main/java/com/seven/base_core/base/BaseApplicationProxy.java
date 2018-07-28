package com.seven.base_core.base;

import android.app.Application;

/**
 * Created  on 2018/7/28.
 * author:seven
 * email:seven2016s@163.com
 * 整个project的application代理基类，为了解决项目中多application冲突问题
 * 可在各个application中做相对应的初始化操作，只需继承这里，重写oncreate方法即可
 */
public abstract class BaseApplicationProxy {
    protected Application application;

    public BaseApplicationProxy(Application application) {
        this.application = application;
    }

    public abstract void onCreate();
}
