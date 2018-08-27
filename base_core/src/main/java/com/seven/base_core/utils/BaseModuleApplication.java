package com.seven.base_core.utils;

import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.seven.base_core.base.RouterURL;

/**
 * Created  on 2018/8/21 0021.
 * author:seven
 * email:seven2016s@163.com
 * 通过arouter的指向，获取到对应的context 并且返回，任由其他module来调用
 */
public class BaseModuleApplication {
    public static Context getContext() {
        IApplicationService applicationService = (IApplicationService)ARouter.getInstance().build(RouterURL.MYAPP_CONTEXT).navigation();
        if (applicationService != null) {
            return applicationService.getApplication();
        }
        return null;
    }
}
