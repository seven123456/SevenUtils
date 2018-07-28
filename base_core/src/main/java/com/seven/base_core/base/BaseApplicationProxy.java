package com.seven.base_core.base;

import android.app.Application;

/**
 * Created  on 2018/7/28.
 * author:seven
 * email:seven2016s@163.com
 */
public abstract class BaseApplicationProxy {
    protected Application application;

    public BaseApplicationProxy(Application application) {
        this.application = application;
    }

    public abstract void onCreate();
}
