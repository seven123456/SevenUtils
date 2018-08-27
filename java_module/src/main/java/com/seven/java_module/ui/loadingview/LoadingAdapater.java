package com.seven.java_module.ui.loadingview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.seven.base_core.base.BaseApplicationProxy;
import com.seven.base_core.utils.BaseModuleApplication;
import com.seven.java_module.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created  on 2018/8/27.
 * author:seven
 * email:seven2016s@163.com
 */
public class LoadingAdapater extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private int layoutId;
    private List<LoadingInfo> loadingInfoList;

    public LoadingAdapater(int layoutId, List<LoadingInfo> loadingInfoList) {
        this.layoutId = layoutId;
        this.loadingInfoList = loadingInfoList;
    }

    public LoadingAdapater(int layoutId) {
        this.layoutId = layoutId;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LoadingViewHolder(LayoutInflater.from(BaseModuleApplication.getContext()).inflate(layoutId,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        LoadingInfo loadingInfo =loadingInfoList.get(position);
        if(loadingInfo!=null){
            ((LoadingViewHolder)holder).onBind(loadingInfo);
        }
    }

    @Override
    public int getItemCount() {
        return loadingInfoList!=null&&loadingInfoList.size()>0?loadingInfoList.size():0;
    }

    private class LoadingViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView,time;

        public LoadingViewHolder(View inflate) {
            super(inflate);
            textView = inflate.findViewById(R.id.tv_loading_title);
            time =inflate.findViewById(R.id.tv_time);
        }
        public void onBind(LoadingInfo loadingInfo){
            textView.setText(loadingInfo.getTitle());
            time.setText(getData(loadingInfo.getTime()));
        }
    }
    public String getData(Long longs){
        Date date =new Date(longs);
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       return simpleDateFormat.format(date);
    }
}
