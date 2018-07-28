package com.seven.kotlin_module;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.seven.base_core.base.BaseActivity;
import com.seven.base_core.base.RouterURL;

/**
 * Created  on 2018/7/28.
 * author:seven
 * email:seven2016s@163.com
 */
@Route(path = RouterURL.KOTLIN_MAIN)
public class KotlinActivity extends BaseActivity {
    @Override
    public int getContentViewResId() {
        return R.layout.kotlin_activity_kotlin;
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
}
