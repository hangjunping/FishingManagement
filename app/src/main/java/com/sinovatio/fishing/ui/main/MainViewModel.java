package com.sinovatio.fishing.ui.main;

import androidx.databinding.ObservableField;
import androidx.lifecycle.Observer;

import com.sinovatio.fishing.base.BaseViewModel;
import com.sinovatio.fishing.data.AppDataBase;
import com.sinovatio.fishing.data.entity.SecHunterEntity;
import com.sinovatio.fishing.utils.ThreadPoolExecutorUtil;
import com.sinovatio.fishing.utils.WifiUtil;

import java.util.List;

/**
 * @author zjp1002038
 */
public class MainViewModel extends BaseViewModel<MainModel> {
    public static int wifiType=0;

    public MainViewModel(){
        model=new MainModel();

        ThreadPoolExecutorUtil.addPoolExecutor(new Runnable() {
            @Override
            public void run() {
//                wifiChange();
            }
        });
    }

    public ObservableField<String> wifiName = new ObservableField<>();
    public ObservableField<SecHunterEntity> entity = new ObservableField<>();

    public void getSecHunter(String type){
        model.getSecEntity("1").observe(getLifecycleOwner(), new Observer<List<SecHunterEntity>>() {
            @Override
            public void onChanged(List<SecHunterEntity> secHunterEntities) {
                if(secHunterEntities.size()>0) {
                    entity.set(secHunterEntities.get(secHunterEntities.size()-1));
                }
            }
        });

//        model.netGetSec().observe(getLifecycleOwner(), new Observer<Resource<Object>>() {
//            @Override
//            public void onChanged(Resource<Object> objectResource) {
//
//            }
//        });

        AppDataBase.getInstance().secHunterDao().getSecHunter(type).observe(getLifecycleOwner(), new Observer<List<SecHunterEntity>>() {
            @Override
            public void onChanged(List<SecHunterEntity> secHunterEntities) {
                if(secHunterEntities.size()>0) {
                    entity.set(secHunterEntities.get(secHunterEntities.size()-1));
                }
            }
        });
    }

    public void wifiChange(){
        while (true){
            AppDataBase.getInstance().secHunterDao().insertSecHunter(new SecHunterEntity(System.currentTimeMillis(),"1"));

            if(wifiType==0){
                wifiType=1;
                WifiUtil.getIns().changeToWifi("enee.....n","1234567890");
                wifiName.set("enee.....n");
            }else {
                wifiType=0;
                WifiUtil.getIns().changeToWifi("JH_IOT","JHiot-+abcd1234");
                wifiName.set("JH_IOT");
            }
            try {
                Thread.sleep(5*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
