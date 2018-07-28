package com.seven.sevenutils;

import android.app.Application;

import com.seven.base_core.base.BaseApplicationProxy;


/**
 * Created  on 2018/7/28.
 * author:seven
 * email:seven2016s@163.com
 */
public class KotlinApplication extends JavaApplication {


    public KotlinApplication(Application application) {
        super(application);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
