package com.sinovatio.fishing.ui.main;

import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;

import android.Manifest;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.sinovatio.fishing.R;
import com.sinovatio.fishing.base.BaseVMActivity;
import com.sinovatio.fishing.databinding.ActivityMainBinding;
import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.functions.Consumer;

/**
 * @author zjp1002038
 */
public class MainActivity extends BaseVMActivity<MainViewModel, ActivityMainBinding> {

    NavOptions navOptions;
    NavController navController;
    private static Context context;
    protected String[] needPermissions = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CHANGE_WIFI_STATE,
            Manifest.permission.ACCESS_FINE_LOCATION,
    };

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
        /**
         * 数据模型及ui绑定
         */
        createViewModel(MainViewModel.class);
        binding.setVm(getViewModel());
        binding.setCb(new ClickBinding());
        getViewModel().getSecHunter("1");

        /**
         * 权限申请
         */
        new RxPermissions(this).request(needPermissions).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
            }
        });

        /**
         * 导航器配置
         */
        navOptions = new NavOptions.Builder().build();
        navController = Navigation.findNavController(MainActivity.this,R.id.host_fragment);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    public class ClickBinding{
        /**
         * 导航到卫士页面
         * @param v
         */
        public void clickGuard(View v){
            navController.navigate(R.id.secondFragment, null, navOptions);

        }

        /**
         * 导航到我的页面
         * @param v
         */
        public void clickMore(View v){
            navController.navigate(R.id.firstFragment, null, navOptions);
        }
    }

}