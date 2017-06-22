package asd.com.retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/11/9.
 */

public class RetrofitUtil {
    private static RetrofitUtil retrofitUtil;

    public synchronized static RetrofitUtil getInstance() {
        if (null == retrofitUtil) {
            retrofitUtil = new RetrofitUtil();
        }
        return retrofitUtil;
    }

    public Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("http://www.tngou.net")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

}
