package com.seven.sevenutils;

import android.app.Application;

import com.seven.base_core.base.BaseApplicationProxy;
import com.seven.base_core.utils.RouterConfig;
import com.seven.java_module.BuildConfig;


/**
 * Created  on 2018/7/28.
 * author:seven
 * email:seven2016s@163.com
 * 继承抽象application代理基类，初始化arouter
 */
public class JavaApplication extends BaseApplicationProxy {

    public JavaApplication(Application application) {
        super(application);
    }

    @Override
    public void onCreate() {
        RouterConfig.init(application, BuildConfig.DEBUG);
    }
}
