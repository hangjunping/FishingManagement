package com.sinovatio.fishing.net;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.sinovatio.fishing.net.HttpConfig.BASE_URL;


/**
 * description: RetrofitClient
 */
public class RetrofitClient {

    public static class RetrofitInstance{
        public static RetrofitClient instance=new RetrofitClient();
    }

    public static RetrofitClient getInstance(){
        return RetrofitInstance.instance;
    }

    private APIService apiService;


    private RetrofitClient() {

    }

    /**
     * 设置Header
     *
     * @return
     */
    private Interceptor getHeaderInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                String token ="";
                Request original = chain.request();
                Request.Builder requestBuilder = original.newBuilder()
                        .header("token", token);   //添加token
                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        };
    }

    /**
     * 设置日志拦截器
     *
     * @return
     */
    private Interceptor getInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        //显示日志
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    /**
     * 创建网络请求接口实例
     *
     * @return
     */
    public APIService getApi() {
        //初始化一个Client，不然Retrofit会自己默认添加一个
        OkHttpClient client = new OkHttpClient().newBuilder()
                //超时时间
                .connectTimeout(3, TimeUnit.MINUTES)
                .readTimeout(3, TimeUnit.MINUTES)
                .writeTimeout(3, TimeUnit.MINUTES)
                //设置Header
                .addInterceptor(getHeaderInterceptor())
                //设置拦截器
                .addInterceptor(getInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                //设置网络请求地址
                .baseUrl(BASE_URL)
                //设置数据解析器
                .addConverterFactory(GsonConverterFactory.create())
                //设置网络请求适配器，使其支持RxJava与RxAndroid
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        //创建网络请求接口实例
        apiService = retrofit.create(APIService.class);
        return apiService;
    }
}
