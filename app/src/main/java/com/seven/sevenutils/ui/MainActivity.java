package com.seven.sevenutils.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.seven.sevenutils.R;
import com.seven.sevenutils.base.BaseActivity;
import com.seven.sevenutils.ui.activity.VerifyEmptyActivity;
import com.seven.sevenutils.utils.BaseLoadStatusView;
import com.seven.sevenutils.utils.BaseToolBar;

public class MainActivity extends BaseActivity {


    private BaseLoadStatusView baseLoadStatusView;

    @Override
    public int getContentViewResId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        baseLoadStatusView = findViewById(R.id.base_load);
        findViewById(R.id.tv_verfiy_empty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mActivity, VerifyEmptyActivity.class));
            }
        });
        baseLoadStatusView.showLoadingView();

    }

    @Override
    public void initData() {

    }

    @Override
    public void widgetClick(View v) {

    }

    @Override
    public void initListener() {
        baseLoadStatusView.setLoadOnClickListener(new BaseLoadStatusView.LoadOnClickListener() {
            @Override
            public void loadingOnClick() {
                baseLoadStatusView.showErrorView();
            }
        });
    }

    @Override
    public boolean isNeedTranslateBar() {
        return false;
    }
}
