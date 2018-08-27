package com.seven.java_module.router;

import com.alibaba.android.arouter.launcher.ARouter;
import com.seven.base_core.base.RouterURL;

/**
 * Created  on 2018/7/28.
 * author:seven
 * email:seven2016s@163.com
 */

public class JavaRouterUrl {
    /*进入Java版本主页*/
    public static void toJavaMain() {
        ARouter.getInstance().build(JavaConstants.JAVA_MAIN).navigation();
    }

    /*进入kotlin版本主页*/
    public static void toKotlinMain() {
        ARouter.getInstance().build(RouterURL.KOTLIN_MAIN).navigation();
    }

    /*进入loadingview*/
    public static void toLoadingView() {
        ARouter.getInstance().build(JavaConstants.LOADING_STATUS).navigation();
    }
}
