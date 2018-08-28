package com.seven.java_module.ui.retrofit_rxjava;

import java.io.IOException;
import java.util.List;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created  on 2018/8/28.
 * author:seven
 * email:seven2016s@163.com
 */
public class BaseUrlInterceptor implements Interceptor {

    private HttpUrl newsUrl;

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();
        List<String> headers = request.headers("url_name");
        if (headers != null && headers.size() > 0) {
            builder.removeHeader("url_name");
            String header =headers.get(0);
            HttpUrl httpUrl =null;
            if("wanandroid".equals(header)){
                httpUrl =HttpUrl.parse(ApiRetrofit.BASE_WANANDROID);
            }else if("gank".equals(header)){
                httpUrl =HttpUrl.parse(ApiRetrofit.BASE_GANK);
            }
            HttpUrl oldUrl =request.url();
            newsUrl = oldUrl.newBuilder()
                    .scheme(httpUrl.scheme())
                    .host(httpUrl.host())
                    .port(httpUrl.port())
                    .build();
        }
        return chain.proceed(builder.url(newsUrl).build());
    }
}
