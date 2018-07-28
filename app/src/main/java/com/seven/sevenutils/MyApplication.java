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
 * MultiDexApplication
 * 在android5.0之前，每一个android应用中只会含有一个dex文件，但是因为Android系统本身的BUG，
 * 使得这个dex的方法数量被限制在65535之内，这就是著名的"64K(641024)"*事件。为了解决这个问题
 * 同样的在每个module下面的dradle里面也记得配置相关信息
 */
public class MyApplication extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        /*初始化BaseApplicationProxy*/
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
