package com.pefish.joy.greendaotest.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.pefish.joy.greendaotest.R;
import com.pefish.joy.greendaotest.pages.main.view.MainFragment;

/**
 * @author：joy
 * @version:
 * @ClassName:
 * @Description: ${todo}(这里用一句话描述这个类的作用)
 * @date：09/03/2017 1:10 PM
 */

public abstract class BaseActivity extends FragmentActivity {
  protected abstract Class<? extends Fragment> getFragmentClass();
  protected abstract void onCreate();

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Fragment fragment = Fragment.instantiate(this, getFragmentClass().getName(), null);
    FragmentManager mFragmentManager = getSupportFragmentManager();
    mFragmentManager
      .beginTransaction()
      .replace(R.id.base_activity_replace, fragment)
      .commitAllowingStateLoss();

    onCreate();
  }
}
