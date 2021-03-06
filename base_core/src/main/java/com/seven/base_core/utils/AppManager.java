package com.seven.base_core.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;

import java.util.Stack;

/**
 * Created by seven
 * on 2018/6/27
 * email:seven2016s@163.com
 * 统一管理activity
 */

public class AppManager {
    private volatile static AppManager instance;
    private static Stack<Activity> activityStack;

    public AppManager() {
    }

    /*
    * 单一实例
    * */
    public static AppManager getAppManager() {
        if (instance != null) {

        } else {
            synchronized (AppManager.class) {
                if (instance == null) {
                    instance = new AppManager();
                }
            }
        }
        return instance;
    }

    /*
    *add activity到栈
    * */
    public static void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<>();
        }
        activityStack.add(activity);
    }

    /*
    * 获取当前activity (堆栈中最后一个进入的)
    * */
    public Activity getCurrentActivity() {
        Activity activity = activityStack.lastElement();
        return activity;
    }

    /*
    * 销毁指定类名的activity
    * */
    public void finishActivity(Class<?> cls) {
        for (Activity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                //如果栈中的某一个activity和传进来的activity一样时，移除栈里面的activity，而不是传进来的cls
                finishActivity(activity);
            }
        }
    }

    /*
    * 销毁指定的activity
    * */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    /*
    * 判断集合是否为空
    * */
    public boolean isEmptyList() {
        return activityStack == null && activityStack.size() != 0 ? true : false;
    }

    /*
    * 打印出当前所有的activity
    * */
    public void getAllActivity() {
        if (activityStack.size() != 0 && activityStack != null) {
            for (int i = 0; i < activityStack.size(); i++) {
                Log.d("AppManager:", "存在栈里面的activity:" + activityStack.get(i).getClass() + "\n");
            }
        } else {
            Log.d("AppManager", "集合为null");
        }
    }

    /*
    * 清空栈内所有的activity
    * */
    public void removedAlllActivity(Activity activity) {
        if (activityStack.size() != 0 && activityStack != null) {
            finishActivity(activity);
            activityStack.removeAllElements();
        }
    }

    /**
     * 获取当前进程名称的方法
     *
     * @param context
     * @return
     */
    public static String getCurProcessName(Context context) {
        int pid = android.os.Process.myPid();
        ActivityManager mActivityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : mActivityManager
                .getRunningAppProcesses()) {
            if (appProcess.pid == pid) {
                return appProcess.processName;
            }
        }
        return null;
    }
}

