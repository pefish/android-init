package com.pefish.joy.greendaotest.pages.usercenter.model;

import com.pefish.joy.greendaotest.entities.TestHttpApi;
import com.pefish.joy.greendaotest.pages.usercenter.presenter.IUserCenterConstract;
import com.pefish.joy.greendaotest.utils.contants.Keys;
import com.pefish.joy.greendaotest.utils.http.HttpRequestHelper;
import com.pefish.joy.greendaotest.utils.http.IHttpResponseListener;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author：joy
 * @version:
 * @ClassName:
 * @Description: ${todo}(这里用一句话描述这个类的作用)
 * @date：08/03/2017 5:24 PM
 */

public class UserCenterCenterModelImpl implements IUserCenterConstract.IUserCenterModel {
    @Override
    public void doGetWeather(Map query, final IHttpResponseListener<TestHttpApi> presenter) {
        Call<TestHttpApi> call = HttpRequestHelper.getApiServices().getWeatherBeijing(Keys.envicloudPrivateKey, "101010100", new HashMap<String, String>());
        call.enqueue(new Callback<TestHttpApi>() {
            @Override
            public void onResponse(Call<TestHttpApi> call, Response<TestHttpApi> response) {
                // model获取到数据传递给presenter
                presenter.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<TestHttpApi> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
