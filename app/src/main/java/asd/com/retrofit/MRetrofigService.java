package asd.com.retrofit;

import asd.com.retrofit.bean.Tngou;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2016/11/7.
 */

public interface MRetrofigService {
    @GET("/api/{type}/list")
    Call<Tngou> getTngouByGet(@Path("type") String type, @Query("id") int id, @Query("page") int page, @Query("rows") int rows);

    @POST("/api/{type}/list")
    @FormUrlEncoded
    Call<Tngou> getTngouByPost(@Path("type") String type, @Field("id") int id, @Field("page") int page, @Field("rows") int rows);

    @POST("/api/{type}/list")
    @FormUrlEncoded
    Observable<Tngou> getTngouByPost_(@Path("type") String type, @Field("id") int id, @Field("page") int page, @Field("rows") int rows);

}
