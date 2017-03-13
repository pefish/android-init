package com.pefish.joy.greendaotest.base;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * @author：joy
 * @version:
 * @ClassName:
 * @Description: ${todo}(这里用一句话描述这个类的作用)
 * @date：09/03/2017 1:11 PM
 */

public abstract class BaseFragment extends Fragment {
    protected abstract int getLayoutId();
    protected abstract void onFragmentCreate();
    protected abstract void onFragmentDestroy();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, view);
        onFragmentCreate();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        onFragmentDestroy();
    }
}
