package com.seven.java_module.ui.loadingview;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.seven.base_core.base.BaseActivity;
import com.seven.base_core.utils.AppManager;
import com.seven.java_module.R;
import com.seven.java_module.router.JavaConstants;
import com.seven.java_module.view.javaBaseToolBar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created  on 2018/8/27.
 * author:seven
 * email:seven2016s@163.com
 */
@Route(path = JavaConstants.LOADING_STATUS)
public class JavaLoadingViewActivity extends BaseActivity {

    private BaseLoadStatusView baseLoadStatusView;
    private RecyclerView recyclerView;
    private LoadingAdapater loadingAdapater;
    private javaBaseToolBar javaBaseToolBar;

    @Override
    public int getContentViewResId() {
        return R.layout.java_activity_loading_view;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        javaBaseToolBar = findViewById(R.id.base_title);
        javaBaseToolBar.setLeftIconDrawable(getResources().getDrawable(R.drawable.icon_return_normal));
        baseLoadStatusView = findViewById(R.id.base_loading_view);
        baseLoadStatusView.showErrorView();
        recyclerView = findViewById(R.id.recycler_loading);
        defaultRecycler();
    }

    private void defaultRecycler() {
        loadingAdapater = new LoadingAdapater(R.layout.java_recyclerview_loading_item);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(loadingAdapater);
    }

    @Override
    public void initData() {

    }

    private void pareDataToRecycler(List<LoadingInfo> loadingInfos) {
        loadingAdapater = new LoadingAdapater(R.layout.java_recyclerview_loading_item, loadingInfos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(loadingAdapater);
        baseLoadStatusView.setVisibility(View.GONE);
    }

    @Override
    public void widgetClick(View v) {
    }

    @Override
    public void initListener() {
        baseLoadStatusView.setLoadOnClickListener(new BaseLoadStatusView.LoadOnClickListener() {
            @Override
            public void loadingOnClick(int type) {
                switch (type) {
                    case 1:
                        break;
                    case 2:
                        baseLoadStatusView.showLoadingView();
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Thread.sleep(3000);
                                    new Handler(getMainLooper()).post(runnable);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }).start();

                        break;
                }
            }
        });
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

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            List<LoadingInfo> loadingInfos = new ArrayList<>();
            for (int i = 0; i < 40; i++) {
                LoadingInfo loadingInfo = new LoadingInfo();
                loadingInfo.setTime(System.currentTimeMillis());
                loadingInfo.setTitle("我是第" + i + "个title");
                loadingInfos.add(loadingInfo);
            }
            pareDataToRecycler(loadingInfos);
        }
    };

    @Override
    public boolean isNeedTranslateBar() {
        return false;
    }
}
