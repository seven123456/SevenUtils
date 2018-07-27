package com.seven.sevenutils.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.seven.sevenutils.R;

/**
 * Created  on 2018/7/27 0027.
 * author:seven
 * email:seven2016s@163.com
 */
public class BaseLoadStatusView extends FrameLayout {

    private int loadingLayout, errorLayout;
    private View loadingView, errorView;
    private boolean showLayout;

    public BaseLoadStatusView(@NonNull Context context) {
        super(context);
    }

    public BaseLoadStatusView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public BaseLoadStatusView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.BaseLoadStatusView);
        if (typedArray != null) {
            loadingLayout = typedArray.getResourceId(R.styleable.BaseLoadStatusView_loading_view, R.layout.base_loading_view);
            errorLayout = typedArray.getResourceId(R.styleable.BaseLoadStatusView_error_view, R.layout.base_error_view);
        }
        typedArray.recycle();
        loadingView = inflate(context, loadingLayout, this);
        errorView = inflate(context, errorLayout, this);
        if (showLayout) {
            LayoutParams layoutParams = new LayoutParams(context, attrs);
            layoutParams.gravity = Gravity.CENTER;
            loadingView.setLayoutParams(layoutParams);
            errorView.setLayoutParams(layoutParams);
        }
        initListener();
    }

    /*展示loading的页面*/
    public void showLoadingView() {
        showView(0);
    }

    /*展示错误的页面*/
    public void showErrorView() {
        showView(1);
    }

    public View getLoadingView() {
        return loadingView;
    }

    public View getErrorView() {
        return errorView;
    }

    /*根据不同的序号来获取baseloadstatusview里面的子类 也就是我们添加进来的view*/
    private void showView(int index) {
        for (int i = 0; i < this.getChildCount(); i++) {
            View child = this.getChildAt(i);
            if (index == i && child instanceof RelativeLayout) {
                viewShow(i, child);
                showLayout = true;
            } else {
                showLayout = false;
                viewHide(i, child, index);
            }
        }
    }

    /*如果遍历的i 和要显示的index不相等，就都隐藏掉*/
    private void viewHide(int i, View child, int index) {
        if (index != i) {
            if (i == 0) {
                child.findViewById(R.id.progress).setVisibility(GONE);
            }
            child.setVisibility(GONE);
        }
    }

    /*显示对应的view就完了*/
    private void viewShow(int index, View child) {
        child.setVisibility(VISIBLE);
    }

    private void initListener() {
        loadingView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (loadOnClickListener != null) {
                    loadOnClickListener.loadingOnClick();
                }
            }
        });
    }

    private LoadOnClickListener loadOnClickListener;

    public void setLoadOnClickListener(LoadOnClickListener loadOnClickListener) {
        this.loadOnClickListener = loadOnClickListener;
    }

    public interface LoadOnClickListener {
        void loadingOnClick();
    }

}
