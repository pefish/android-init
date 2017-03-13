package com.pefish.joy.greendaotest.pages.testPage.view;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.pefish.joy.greendaotest.R;
import com.pefish.joy.greendaotest.base.BaseFragment;
import com.pefish.joy.greendaotest.events.Test1Event;
import com.pefish.joy.greendaotest.events.TestEvent;
import com.pefish.joy.greendaotest.utils.Navigator;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author：joy
 * @version:
 * @ClassName:
 * @Description: ${todo}(这里用一句话描述这个类的作用)
 * @date：13/03/2017 11:07 AM
 */

public class TestViewFragment extends BaseFragment {
  @BindView(R.id.tv_test_page_test_text)
  TextView tv_test_page_test_text;
  @BindView(R.id.btn_test_page_test_buttom)
  Button btn_test_page_test_buttom;

  @OnClick(R.id.btn_test_page_test_buttom)
  public void testButtomOnClicked (View v) {
    EventBus.getDefault().post(new Test1Event("FirstEvent btn clicked"));
//    Navigator.pop(getActivity());
  }

  @Override
  protected int getLayoutId() {
    return R.layout.test_page_fragment;
  }

  @Override
  protected void onFragmentCreate() {
    tv_test_page_test_text.setText("ywtwyuetyi");
  }

  @Override
  protected void onFragmentDestroy() {

  }
}
