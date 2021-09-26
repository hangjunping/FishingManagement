package com.sinovatio.fishing.base;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;

import java.lang.ref.WeakReference;

/**
 * @author zjp1002038
 */
public class BaseViewModel<T extends BaseModel> extends ViewModel {

    private WeakReference<LifecycleOwner> lifecycleOwner;
    public T model;


    private final ObservableBoolean mIsLoading = new ObservableBoolean();

    public ObservableBoolean getIsLoading() {
        return mIsLoading;
    }

    public void setIsLoading(boolean isLoading) {
        mIsLoading.set(isLoading);
    }

    public LifecycleOwner getLifecycleOwner() {
        return lifecycleOwner.get();
    }

    public BaseViewModel setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        this.lifecycleOwner =new WeakReference<>(lifecycleOwner) ;
        return this;
    }
}
