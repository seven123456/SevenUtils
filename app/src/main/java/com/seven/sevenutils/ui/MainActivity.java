package com.seven.sevenutils.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.seven.sevenutils.R;
import com.seven.sevenutils.base.BaseActivity;
import com.seven.sevenutils.ui.activity.VerifyEmptyActivity;

public class MainActivity extends BaseActivity {


    @Override
    public int getContentViewResId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        findViewById(R.id.tv_verfiy_empty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mActivity,VerifyEmptyActivity.class));
            }
        });
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
