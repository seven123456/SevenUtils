package com.seven.sevenutils;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.seven.base_core.utils.IApplicationService;

import static com.seven.base_core.base.RouterURL.MYAPP_CONTEXT;


/**
 * Created  on 2018/8/21 0021.
 * author:seven
 * email:seven2016s@163.com
 * Myapplication基本上代表了整个项目中的application ，所以他提供的context基本代表了各模块的context
 * 因为使用的是arouter的模块之间类调用(数据提供) 所以也需要填写URL数据以便于指向对应的service
 */
@Route(path = MYAPP_CONTEXT)
public class MyApplicationService implements IApplicationService {
    @Override
    public Context getApplication() {
        Log.d("MyApplicationService","是不是真的"+(MyApplication.getContext()==null));
        return MyApplication.getContext();
    }

    @Override
    public void init(Context context) {

    }
}
