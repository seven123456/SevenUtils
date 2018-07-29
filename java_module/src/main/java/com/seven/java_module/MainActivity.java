package com.seven.java_module;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.seven.base_core.base.BaseActivity;
import com.seven.base_core.base.RouterURL;

/**
 * Created  on 2018/7/28.
 * author:seven
 * email:seven2016s@163.com
 */
@Route(path = RouterURL.JAVA_MAIN)
public class MainActivity extends BaseActivity {
    @Override
    public int getContentViewResId() {
        return R.layout.java_activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @Override
    public void initData() {

    }

    @Override
    public void widgetClick(View v) {

    }

    @Override
    public void initListener() {

    }

    @Override
    public boolean isNeedTranslateBar() {
        return true;
    }
}
