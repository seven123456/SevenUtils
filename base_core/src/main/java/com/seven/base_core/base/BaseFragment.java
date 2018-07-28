package com.seven.base_core.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created  on 2018/7/26.
 * author:seven
 * email:seven2016s@163.com
 * fragment的抽象基类
 */
public abstract class BaseFragment extends Fragment implements BaseUIOperation, View.OnClickListener {
    public View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(getContentViewResId(), container, false);
        }
        initView(savedInstanceState);
        initData();
        initListener();
        return rootView;
    }

    @Override
    public void onClick(View view) {
        widgetClick(view);
    }
}
