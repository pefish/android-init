package com.pefish.joy.greendaotest.pages.testPage.view;

import android.support.v4.app.Fragment;

import com.pefish.joy.greendaotest.base.BaseActivity;
import com.pefish.joy.greendaotest.base.BaseFragment;

/**
 * @author：joy
 * @version:
 * @ClassName:
 * @Description: ${todo}(这里用一句话描述这个类的作用)
 * @date：13/03/2017 11:40 AM
 */

public class TestViewActivity extends BaseActivity {

  @Override
  protected Class<? extends Fragment> getFragmentClass() {
    return TestViewFragment.class;
  }

  @Override
  protected void onCreate() {

  }
}
