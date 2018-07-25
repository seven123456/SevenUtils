package com.seven.sevenutils.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.seven.sevenutils.utils.AppManager;
import com.seven.sevenutils.utils.StatusBarUtil;

/**
 * Created  on 2018/7/26.
 * author:seven
 * email:seven2016s@163.com
 * activity抽象基类
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseUIOperation, View.OnClickListener {
    private BaseActivity mActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//竖屏
        setContentView(getContentViewResId());
        //每开启一个activity都直接存入堆里面,方便管理
        AppManager.getAppManager().addActivity(this);
        mActivity = this;
        //是否开启沉浸式
        if (isNeedTranslateBar()) {
            StatusBarUtil.setTranslate(mActivity, true);
        }
        initView(savedInstanceState);
        initData();
        initListener();
    }

    public boolean isNeedTranslateBar() {
        return true;
    }

    public abstract void initView(Bundle savedInstanceState);

    public abstract void initData();

    public abstract void initListener();

    @Override
    public void onClick(View view) {
        widgetClick(view);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //销毁activity的时候从栈内销毁
        AppManager.getAppManager().finishActivity(this);
    }

   /* public void toast(String msg) {
        ToastUtils.showSingleToast(mActivity, msg);
    }*/

}
