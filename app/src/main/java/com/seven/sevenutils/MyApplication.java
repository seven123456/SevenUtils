package com.seven.sevenutils;

import android.app.Application;
import android.support.multidex.MultiDexApplication;
import android.text.TextUtils;

import com.seven.base_core.base.BaseApplicationProxy;
import com.seven.base_core.utils.AppManager;


/**
 * Created  on 2018/7/28.
 * author:seven
 * email:seven2016s@163.com
 */
public class MyApplication extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        BaseApplicationProxy application = createProxy(this);
        application.onCreate();
    }

    /**
     * 不同的进程，创建不同的ApplicationProxy来进行初始化
     *
     * @param application
     * @return
     */
    public BaseApplicationProxy createProxy(Application application) {
        String processName = AppManager.getCurProcessName(application);
        if (!TextUtils.isEmpty(processName)) {
            String pkgname = application.getPackageName();
            if (processName.equals(pkgname)) {
                return new JavaApplication(application);
            }
        }
        return new KotlinApplication(application);
    }
}
