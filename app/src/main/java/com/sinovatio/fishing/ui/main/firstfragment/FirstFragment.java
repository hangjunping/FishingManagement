package com.sinovatio.fishing.ui.main.firstfragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;

import com.sinovatio.fishing.R;
import com.sinovatio.fishing.STApplication;
import com.sinovatio.fishing.base.BaseVMFragment;
import com.sinovatio.fishing.databinding.FragmentFirstBinding;

/**
 * @author zjp1002038
 */
public class FirstFragment extends BaseVMFragment<FirstViewModel,FragmentFirstBinding> {

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_first;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        binding.setClick(new ClickBinding());
    }

    public class ClickBinding{

        public void buttonClick(View view){
            NavOptions navOptions = new NavOptions.Builder()
                    .build();
            NavController navController = Navigation.findNavController(view);
            navController.navigate(R.id.secondFragment, null, navOptions);
            STApplication.toastShow("click");
        }
    }
}
