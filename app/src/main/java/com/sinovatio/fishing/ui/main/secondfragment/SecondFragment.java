package com.sinovatio.fishing.ui.main.secondfragment;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.sinovatio.fishing.R;
import com.sinovatio.fishing.STApplication;
import com.sinovatio.fishing.base.BaseFragment;
import com.sinovatio.fishing.databinding.FragmentSecondBinding;

/**
 * @author zjp1002038
 */
public class SecondFragment extends BaseFragment< FragmentSecondBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_second;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        STApplication.toastShow("SecondFragment");

    }

}
