package com.seven.java_module;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.seven.base_core.base.BaseActivity;
import com.seven.java_module.adapter.JavaHomeAdapter;
import com.seven.java_module.info.JavaHomeInfos;
import com.seven.java_module.router.JavaConstants;

import java.util.ArrayList;
import java.util.List;

import static com.seven.java_module.router.JavaRouterUrl.toLoadingView;
import static com.seven.java_module.router.JavaRouterUrl.toRetrofitView;

/**
 * Created  on 2018/7/28.
 * author:seven
 * email:seven2016s@163.com
 */
@Route(path = JavaConstants.JAVA_MAIN)
public class MainActivity extends BaseActivity {

    private JavaHomeAdapter javaHomeAdapter;
    private RecyclerView recyclerView;
    private List<JavaHomeInfos> javaHomeInfosList;

    @Override
    public int getContentViewResId() {
        return R.layout.java_activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        //记得初始化list 不然list=null而不是0
        javaHomeInfosList = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler_home);
        defaultRecycler();
    }

    //初始化一个无数据的adapter来占位
    private void defaultRecycler() {
        recyclerView.setLayoutManager(new GridLayoutManager(mActivity, 3));
        javaHomeAdapter = new JavaHomeAdapter(R.layout.java_recyclerview_home_item);
        recyclerView.setAdapter(javaHomeAdapter);
    }

    @Override
    public void initData() {
        javaHomeInfosList.add(new JavaHomeInfos("页面加载状态", 1));
        javaHomeInfosList.add(new JavaHomeInfos("Retrofit2+Rxjava2结合使用", 2));
        loadRecyclerView(javaHomeInfosList);
    }

    /*有数据时再填充数据给adapter，在网络请求中也可以这样做*/
    private void loadRecyclerView(List<JavaHomeInfos> javaHomeInfosList) {
        recyclerView.setLayoutManager(new GridLayoutManager(mActivity, 2));
        javaHomeAdapter = new JavaHomeAdapter(R.layout.java_recyclerview_home_item, javaHomeInfosList);
        recyclerView.setAdapter(javaHomeAdapter);
        javaHomeAdapter.setOnItemClickListener(new JavaHomeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(JavaHomeAdapter adapter, View view, int position) {
                JavaHomeInfos javaHomeInfos =adapter.getItem(position);
                if(javaHomeInfos!=null){
                    switch (javaHomeInfos.getType()){
                        case 1:
                            toLoadingView();
                            break;
                        case 2:
                            toRetrofitView();
                            break;
                    }
                }
            }
        });
    }

    @Override
    public void widgetClick(View v) {

    }

    @Override
    public void initListener() {

    }

    @Override
    public boolean isNeedTranslateBar() {
        return false;
    }
}
