package com.sinovatio.fishing.base;

import androidx.lifecycle.MutableLiveData;

import com.sinovatio.fishing.net.APIService;
import com.sinovatio.fishing.net.Resource;
import com.sinovatio.fishing.net.RetrofitClient;
import com.sinovatio.fishing.net.RxScheduler;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;

/**
 * @author zjp1002038
 */
public class BaseModel {

    public <T> MutableLiveData<Resource<T>> observeGo(Flowable<T> flowable){
        final MutableLiveData<Resource<T>> liveData = new MutableLiveData<>();
        flowable
                .compose(RxScheduler.flo_io_main())
                .subscribe(new Consumer<Object>() {

                    @Override
                    public void accept(Object o) throws Exception {
                        Resource resource=new Resource<T>((T)o,0,"1");
                        liveData.postValue(resource);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Resource resource=new Resource<T>(null,-1,throwable.getMessage());
                        liveData.postValue(resource);
                    }
                });
        return liveData;
    }

    public APIService getApiService() {
        return  RetrofitClient.getInstance().getApi();
    }
}
