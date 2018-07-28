package com.seven.java_module.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.seven.base_core.base.BaseActivity;
import com.seven.base_core.base.RouterURL;
import com.seven.base_core.utils.AppManager;
import com.seven.java_module.R;
import com.seven.java_module.ui.router.JavaRouterUrl;

/**
 * Created  on 2018/7/28.
 * author:seven
 * email:seven2016s@163.com
 */
public class SplashActivity extends BaseActivity {

    private TextView goJavaVersion, goKotlinVersion;

    @Override
    public int getContentViewResId() {
        return R.layout.java_activity_splash;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        goJavaVersion = findViewById(R.id.tv_java);
        goKotlinVersion = findViewById(R.id.tv_kotlin);
    }

    @Override
    public void initData() {

    }

    @Override
    public void widgetClick(View v) {
        if (v.getId() == R.id.tv_java) {
            JavaRouterUrl.toJavaMain();
        } else if (v.getId() == R.id.tv_kotlin) {
            JavaRouterUrl.toKotlinMain();
        }
        AppManager.getAppManager().finishActivity(mActivity);
    }

    @Override
    public void initListener() {
        goJavaVersion.setOnClickListener(this);
        goKotlinVersion.setOnClickListener(this);
    }
}
