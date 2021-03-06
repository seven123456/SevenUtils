package com.seven.java_module.adapter;

import android.support.annotation.IntRange;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.seven.base_core.utils.BaseModuleApplication;
import com.seven.java_module.R;
import com.seven.java_module.info.JavaHomeInfos;

import java.util.List;

/**
 * Created  on 2018/8/21 0021.
 * author:seven
 * email:seven2016s@163.com
 */
public class JavaHomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private int layoutId;
    private List<JavaHomeInfos> javaHomeInfosList;

    public JavaHomeAdapter(int layoutId) {
        this.layoutId = layoutId;
    }

    public JavaHomeAdapter(int layoutId, List<JavaHomeInfos> javaHomeInfosList) {
        this.layoutId = layoutId;
        this.javaHomeInfosList = javaHomeInfosList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        RecyclerView.ViewHolder viewHolder = null;
//        Context context = ((IApplicationService) ARouter.getInstance().build(RouterURL.MYAPP_CONTEXT).navigation()).getContext();
        view = LayoutInflater.from(BaseModuleApplication.getContext()).inflate(layoutId, parent, false);
        viewHolder = new JavaHomeViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        JavaHomeInfos javaHomeInfos = javaHomeInfosList.get(position);
        if (javaHomeInfos != null) {
            ((JavaHomeViewHolder) holder).itemTitle.setText(javaHomeInfos.getItemName());
            ((JavaHomeViewHolder) holder).rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(JavaHomeAdapter.this, v, position);
                    }
                }
            });
        }
    }
    @Nullable
    public JavaHomeInfos getItem(@IntRange(from = 0) int position) {
        if (position < javaHomeInfosList.size())
            return javaHomeInfosList.get(position);
        else
            return null;
    }
    @Override
    public int getItemCount() {
        return javaHomeInfosList != null && javaHomeInfosList.size() > 0 ? javaHomeInfosList.size() : 0;
    }

    public class JavaHomeViewHolder extends RecyclerView.ViewHolder {
        private TextView itemTitle;
        private RelativeLayout rootView;

        public JavaHomeViewHolder(View view) {
            super(view);
            itemTitle = view.findViewById(R.id.tv_title);
            rootView = view.findViewById(R.id.rly_root_view);
        }
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.onItemClickListener = itemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(JavaHomeAdapter adapter, View view, int position);
    }
}
