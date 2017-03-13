package com.pefish.joy.greendaotest.pages.usercenter.presenter;

import com.pefish.joy.greendaotest.entities.TestHttpApi;
import com.pefish.joy.greendaotest.utils.http.IHttpResponseListener;

import java.util.Map;

/**
 * @author：joy
 * @version:
 * @ClassName:
 * @Description: ${todo}(这里用一句话描述这个类的作用)
 * @date：08/03/2017 7:04 PM
 */

public interface IUserCenterConstract {
    interface IUserCenterView {
        void onGetWeatherResult(TestHttpApi result);
    }

    interface IUserCenterPresenter {
        void doGetWeather(Map query);
    }

    interface IUserCenterModel {
        void doGetWeather(Map query, IHttpResponseListener<TestHttpApi> presenter);
    }
}
