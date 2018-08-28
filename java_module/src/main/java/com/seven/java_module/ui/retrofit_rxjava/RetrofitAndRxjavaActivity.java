package com.seven.java_module.ui.retrofit_rxjava;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.seven.base_core.base.BaseActivity;
import com.seven.base_core.utils.AppManager;
import com.seven.java_module.R;
import com.seven.java_module.view.javaBaseToolBar;

import static com.seven.java_module.router.JavaConstants.RETROFIT_RXJAVA;

/**
 * Created  on 2018/8/28.
 * author:seven
 * email:seven2016s@163.com
 */
@Route(path = RETROFIT_RXJAVA)
public class RetrofitAndRxjavaActivity extends BaseActivity {

    private com.seven.java_module.view.javaBaseToolBar javaBaseToolBar;

    @Override
    public int getContentViewResId() {
        return R.layout.java_activity_retrofit_rxjava;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        javaBaseToolBar = findViewById(R.id.base_title);
        javaBaseToolBar.setLeftIconDrawable(getResources().getDrawable(R.drawable.icon_return_normal));
    }

    @Override
    public void initData() {

    }

    @Override
    public void widgetClick(View v) {

    }

    @Override
    public void initListener() {
        javaBaseToolBar.setBaseToolBaseOnClickListener(new javaBaseToolBar.onBaseToolBaseOnClickListener() {
            @Override
            public void leftOnClick() {
                AppManager.getAppManager().finishActivity(mActivity);
            }

            @Override
            public void rightTitleOnClick() {

            }

            @Override
            public void rightIcon1OnClick() {

            }

            @Override
            public void rightIcon2OnClick() {

            }

            @Override
            public void rightIcon3OnClick() {

            }
        });
    }

    @Override
    public boolean isNeedTranslateBar() {
        return false;
    }
}
