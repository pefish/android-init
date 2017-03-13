package com.pefish.joy.greendaotest.utils.http;

import com.pefish.joy.greendaotest.utils.contants.Urls;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpRequestHelper {
    public static boolean isAddLog = true;
    private static final int CONNECT_TIMEOUT = 30;
    private static final int READ_TIMEOUT = 30;
    private static final int WRITE_TIMEOUT = 30;
    private Retrofit retrofit;
    private static ApiManager apiManager;
    private static HttpRequestHelper httpRequestManager;
    private OkHttpClient.Builder httpClientBuilder;

    public static void setIsAddRequestLog(boolean islog) {
        isAddLog = islog;
    }

    private HttpRequestHelper() {
        httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS);
        httpClientBuilder.readTimeout(READ_TIMEOUT, TimeUnit.SECONDS);//设置读取超时时间
        httpClientBuilder.writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS);//设置写的超时时间
        if (isAddLog) {
            //打印log类
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClientBuilder.addInterceptor(interceptor);
        }
        retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Urls.baseUrl)
                .build();

        apiManager = retrofit.create(ApiManager.class);
    }


    public static ApiManager getApiServices() {
        if (httpRequestManager == null) {
            synchronized (HttpRequestHelper.class) {
                if (httpRequestManager == null) {
                    httpRequestManager = new HttpRequestHelper();
                }
            }
        }
        return apiManager;
    }
}
