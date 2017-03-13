package com.pefish.joy.greendaotest.utils.http;

import com.pefish.joy.greendaotest.entities.TestHttpApi;

import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface ApiManager {

    /**
     * 验证手机号
     */
//    @FormUrlEncoded
//    @POST("auth/mobile")
//    Observable<VerificationPhoneBean> getVerifPhoneNumber(@HeaderMap Map<String, String> header, @FieldMap Map<String, String> query);


    /**
     * 获取重置密码时间
     */
//    @GET("user/pin/forget")
//    Observable<ForgetPinTimerBean> getResetPinTime(@HeaderMap Map<String, String> Map);

    /**
     * 忘记密码
     */

//    @PUT("user/pin")
//    Observable<CommonNullResultBean> getResetPin(@HeaderMap Map<String, String> Map, @QueryMap Map<String, String> query);


    /**
     * delete wllets
     */
//    @DELETE("wallet/{currencyCode}")
//    Observable<AddCurrencyResultBean> getDeletewallets(@HeaderMap Map<String, String> Map, @Path("currencyCode") String currencyCode);


//    @FormUrlEncoded
//    @POST("card/{cardGoodsId}")
//    Observable<CardCreateResultBean> createDebitCardOrder(@HeaderMap Map<String, String> Map, @Path("cardGoodsId") String cardGoodsId,
//                                                          @FieldMap Map<String, String> query);

    // 查询城市天气
    @GET("v2/weatherforecast/{accesskey}/{citycode}")
    Call<TestHttpApi> getWeatherBeijing(@Path("accesskey") String accesskey, @Path("citycode") String citycode, @HeaderMap Map<String, String> Map);
}


