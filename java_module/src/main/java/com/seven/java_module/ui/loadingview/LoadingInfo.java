package com.seven.java_module.ui.loadingview;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created  on 2018/8/27.
 * author:seven
 * email:seven2016s@163.com
 */
public class LoadingInfo implements Parcelable {
    private String title;

    protected LoadingInfo(Parcel in) {
        title = in.readString();
        if (in.readByte() == 0) {
            time = null;
        } else {
            time = in.readLong();
        }
    }

    public static final Creator<LoadingInfo> CREATOR = new Creator<LoadingInfo>() {
        @Override
        public LoadingInfo createFromParcel(Parcel in) {
            return new LoadingInfo(in);
        }

        @Override
        public LoadingInfo[] newArray(int size) {
            return new LoadingInfo[size];
        }
    };

    public LoadingInfo() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    private Long time;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        if (time == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(time);
        }
    }
}
