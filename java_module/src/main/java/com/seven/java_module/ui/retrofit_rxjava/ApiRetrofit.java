package com.seven.java_module.ui.retrofit_rxjava;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created  on 2018/8/28.
 * author:seven
 * email:seven2016s@163.com
 */
public class ApiRetrofit {
    private static volatile ApiRetrofit apiRetrofit;
    //连接超时
    private static final int CONNECT_TIMEOUT = 10;
    //读取超时
    private static final int READ_TIMEOUT = 10;
    //写入超时
    private static final int WRITE_TIMEOUT = 10;
    //gson处理器
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    //rxjava特有的adapter
    private static CallAdapter.Factory adapterFactory = RxJava2CallAdapterFactory.create();
    //api接口
    private ApiServise apiServise;
    public static final String BASE_WANANDROID = "http://wanandroid.com";
    public static final String BASE_GANK = "http://gank.io";

    public ApiServise getApiServise() {
        return apiServise;
    }

    private ApiRetrofit(String baseUrl) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .retryOnConnectionFailure(true)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(adapterFactory)
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .build();
        //绑定api接口类
        apiServise = retrofit.create(ApiServise.class);
    }

    public static ApiRetrofit getApiRetrofit(String url) {
        if (apiRetrofit == null) {
            synchronized (ApiRetrofit.class) {
                if (apiRetrofit == null) {
                    apiRetrofit = new ApiRetrofit(url);
                }
            }
        }
        return apiRetrofit;
    }

    /*
     * 打印日志拦截器
     * */
    private static final HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY);
}
