package com.sinovatio.fishing.ui.main;

import androidx.lifecycle.MutableLiveData;

import com.sinovatio.fishing.base.BaseModel;
import com.sinovatio.fishing.net.Resource;
import com.sinovatio.fishing.data.AppDataBase;
import com.sinovatio.fishing.data.entity.SecHunterEntity;
import com.sinovatio.fishing.utils.ThreadPoolExecutorUtil;

import java.util.List;

/**
 * @author zjp1002038
 */
public class MainModel extends BaseModel {


    public MutableLiveData<List<SecHunterEntity>> getSecEntity(String type) {
        MutableLiveData<List<SecHunterEntity>> liveData =new MutableLiveData<>();
        ThreadPoolExecutorUtil.addPoolExecutor(new Runnable() {
            @Override
            public void run() {
                liveData.postValue(AppDataBase.getInstance().secHunterDao().getSecHunterList(type));
            }
        });
        return liveData;
    }

    public MutableLiveData<Resource<Object>> netGetSec(){
        return observeGo( getApiService().getSec());
    }
}
