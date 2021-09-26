package com.sinovatio.fishing.base;

import androidx.databinding.ViewDataBinding;

/**
 * @author zjp1002038
 */
public class BaseVMFragment<T extends BaseViewModel,B extends ViewDataBinding> extends  BaseFragment<B>{
    public T viewModel;

    @Override
    protected int getLayoutId() {
        return 0;
    }
}
