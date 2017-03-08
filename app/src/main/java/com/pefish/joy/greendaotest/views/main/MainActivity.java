package com.pefish.joy.greendaotest.views.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;

import com.pefish.joy.greendaotest.MyApplication;
import com.pefish.joy.greendaotest.R;
import com.pefish.joy.greendaotest.daos.UserDao;
import com.pefish.joy.greendaotest.entities.User;

import java.util.List;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment fragment = Fragment.instantiate(this, MainFragment.class.getName(), null);
        FragmentManager mFragmentManager = getSupportFragmentManager();
        mFragmentManager
            .beginTransaction()
            .replace(R.id.base_activity_replace, fragment)
            .commitAllowingStateLoss();

        UserDao mUserDao = MyApplication.getInstances().getDaoSession().getUserDao();
        User user1 = new User();
        user1.setName("11");
        User user2 = new User();
        user2.setName("22");
        mUserDao.insert(user1);
        mUserDao.insert(user2);

        List<User> users = mUserDao.loadAll();
        String userName = "";
        for (int i = 0; i < users.size(); i++) {
            userName += users.get(i).getName()+",";
        }
        Log.e("haha", "查询全部数据==>" + userName);
    }


}
