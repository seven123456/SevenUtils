package com.seven.sevenutils.ui.info;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created  on 2018/7/26 0026.
 * author:seven
 * email:seven2016s@163.com
 */
public class VerifyInfo implements Parcelable {
    private String msg;//要验证的string
    private String msgTip;//为空时的tip
    private boolean isSuccess;//是否符合正则
    private String isFailTip;//正则验证失败，提示对应的tip

    protected VerifyInfo(Parcel in) {
        msg = in.readString();
        msgTip = in.readString();
        isSuccess = in.readByte() != 0;
        isFailTip = in.readString();
    }

    public VerifyInfo(String msg, String msgTip, boolean isSuccess, String isFailTip) {
        this.msg = msg;
        this.msgTip = msgTip;
        this.isSuccess = isSuccess;
        this.isFailTip = isFailTip;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(msg);
        dest.writeString(msgTip);
        dest.writeByte((byte) (isSuccess ? 1 : 0));
        dest.writeString(isFailTip);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<VerifyInfo> CREATOR = new Creator<VerifyInfo>() {
        @Override
        public VerifyInfo createFromParcel(Parcel in) {
            return new VerifyInfo(in);
        }

        @Override
        public VerifyInfo[] newArray(int size) {
            return new VerifyInfo[size];
        }
    };

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsgTip() {
        return msgTip;
    }

    public void setMsgTip(String msgTip) {
        this.msgTip = msgTip;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getIsFailTip() {
        return isFailTip;
    }

    public void setIsFailTip(String isFailTip) {
        this.isFailTip = isFailTip;
    }

    public static Creator<VerifyInfo> getCREATOR() {
        return CREATOR;
    }
}
