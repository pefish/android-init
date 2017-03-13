package com.pefish.joy.greendaotest.pages.usercenter.presenter;

import com.pefish.joy.greendaotest.entities.TestHttpApi;
import com.pefish.joy.greendaotest.pages.usercenter.model.UserCenterCenterModelImpl;
import com.pefish.joy.greendaotest.utils.http.IHttpResponseListener;

import java.util.HashMap;
import java.util.Map;

/**
 * @author：joy
 * @version:
 * @ClassName:
 * @Description: ${todo}(这里用一句话描述这个类的作用)
 * @date：08/03/2017 5:27 PM
 */

public class UserCenterCenterPresenter implements IUserCenterConstract.IUserCenterPresenter {
    private IUserCenterConstract.IUserCenterView mView;
    private UserCenterCenterModelImpl model;

    public UserCenterCenterPresenter(IUserCenterConstract.IUserCenterView view){
        mView=view;
        model = new UserCenterCenterModelImpl();
    }

    @Override
    public void doGetWeather(Map query) {
        model.doGetWeather(new HashMap(), new IHttpResponseListener<TestHttpApi>() {
            @Override
            public void onSuccess(TestHttpApi o) {
                // presenter获取到数据传递给view
                mView.onGetWeatherResult(o);
            }

            @Override
            public void onError(int code, String error) {

            }
        });
    }
}
