package com.pefish.joy.greendaotest.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * @author：joy
 * @version:
 * @ClassName:
 * @Description: ${todo}(这里用一句话描述这个类的作用)
 * @date：13/03/2017 11:34 AM
 */

public class Navigator {
  public static void push (Context context, Class<? extends Activity> cls, Bundle bundle) {
    Intent intent = new Intent();
    if (null != bundle) {
      intent.putExtras(bundle);
    }
    intent.setClass(context, cls);
    context.startActivity(intent);
  }

  public static void pop (Activity activity) {
    activity.finish();
  }
}
