package com.pefish.joy.greendaotest.pages.main.view;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.pefish.joy.greendaotest.R;
import com.pefish.joy.greendaotest.base.BaseFragment;
import com.pefish.joy.greendaotest.events.Test1Event;
import com.pefish.joy.greendaotest.events.TestEvent;
import com.pefish.joy.greendaotest.pages.testPage.view.TestViewActivity;
import com.pefish.joy.greendaotest.utils.Navigator;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.OnClick;

public class MainFragment extends BaseFragment {
  // 所有控件
  @BindView(R.id.tv_test_text)
  TextView textTextView;
  @BindView(R.id.btn_test_button)
  Button btn_test_button;

  // 所有控件监听事件
  @OnClick(R.id.btn_test_button)
  public void testButtomOnClick (View v) {
    Navigator.push(getContext(), TestViewActivity.class, null);
  }

  // 所有局部变量
  private Handler handler;

  // 所有复写方法
  @Override
  public int getLayoutId() {
    return R.layout.fragment_test;
  }

  @Override
  protected void onFragmentCreate() {
    handler = new Handler();

    EventBus.getDefault().register(this);
  }

  @Override
  protected void onFragmentDestroy() {
    EventBus.getDefault().unregister(this);
  }

  // 所有订阅事件
  @Subscribe(threadMode = ThreadMode.MAIN)
  public void onTestEvent(TestEvent event) {
    String msg = "onEventMainThread收到了消息：" + event.getMsg();
    textTextView.setText(msg);
  }

  @Subscribe(threadMode = ThreadMode.MAIN)
  public void onTest1Event(Test1Event event) {
    String msg = "onEventMainThread收到了消息1：" + event.getMsg();
    textTextView.setText(msg);
  }
}
