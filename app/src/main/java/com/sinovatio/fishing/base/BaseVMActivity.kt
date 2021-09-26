package com.sinovatio.fishing.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider

open class BaseVMActivity< T : BaseViewModel<*>?, B : ViewDataBinding> : BaseActivity<B>() {

    var viewModel: T?=null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getLayoutId(): Int {
        return 0
    }

    /**
     * 创建ViewModel
     *
     * @param cls
     * @param <T>
     * @return
    </T> */
    fun createViewModel(css:Class<T>) {
        viewModel= ViewModelProvider(this)[css]!!.setLifecycleOwner(this) as T?
    }
}