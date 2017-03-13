package com.pefish.joy.greendaotest.pages.main.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;

import com.pefish.joy.greendaotest.MyApplication;
import com.pefish.joy.greendaotest.R;
import com.pefish.joy.greendaotest.base.BaseActivity;
import com.pefish.joy.greendaotest.daos.SuggestionDao;
import com.pefish.joy.greendaotest.daos.TestHttpApiDao;
import com.pefish.joy.greendaotest.entities.TestHttpApi;
import com.pefish.joy.greendaotest.pages.usercenter.presenter.IUserCenterConstract;
import com.pefish.joy.greendaotest.pages.usercenter.presenter.UserCenterCenterPresenter;

import java.util.HashMap;
import java.util.List;

public class MainActivity extends BaseActivity implements IUserCenterConstract.IUserCenterView {

    @Override
    protected Class<? extends Fragment> getFragmentClass() {
        return MainFragment.class;
    }

    @Override
    protected void onCreate() {
// 演示GreenDao
//        UserDao mUserDao = MyApplication.getInstances().getDaoSession().getUserDao();
//        User user1 = new User();
//        user1.setName("11");
//        User user2 = new User();
//        user2.setName("22");
//        mUserDao.insert(user1);
//        mUserDao.insert(user2);
//
//        List<User> users = mUserDao.loadAll();
//        String userName = "";
//        for (int i = 0; i < users.size(); i++) {
//            userName += users.get(i).getName()+",";
//        }
//        Log.e("haha", "查询全部数据==>" + userName);

        // 演示okhttp
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                //创建okHttpClient对象
//                OkHttpClient mOkHttpClient = new OkHttpClient();
//                //创建一个Request
//                final Request request = new Request.Builder()
//                    .url("https://baidu.com")
//                    .build();
//                //new call
//                Call call = mOkHttpClient.newCall(request);
//                //请求加入调度
//                call.enqueue(new Callback()
//                {
//
//                    @Override
//                    public void onFailure(Call call, IOException e) {
//
//                    }
//
//                    @Override
//                    public void onResponse(Call call, Response response) throws IOException {
//                        String htmlStr =  response.body().string();
//                        Log.e("okhttp", htmlStr);
//                    }
//                });
//            }
//        }).start();

        // 演示retrofit2
//        UserCenterCenterPresenter userCenterPresenter = new UserCenterCenterPresenter(this);
//        userCenterPresenter.doGetWeather(new HashMap());
    }

    @Override
    public void onGetWeatherResult(TestHttpApi result) {
        TestHttpApiDao mUserDao = MyApplication.getInstances().getDaoSession().getTestHttpApiDao();
        SuggestionDao suggestionDao = MyApplication.getInstances().getDaoSession().getSuggestionDao();
        suggestionDao.insert(result.getSuggestion());
        result.setSuggestionId(result.getSuggestion().getId());
        mUserDao.insert(result);

        List<TestHttpApi> testHttpApis = mUserDao.loadAll();
        Log.e("f", "ry");
    }
}
