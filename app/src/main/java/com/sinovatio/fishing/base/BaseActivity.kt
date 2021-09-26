package com.sinovatio.fishing.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<B : ViewDataBinding>  : AppCompatActivity() {

    lateinit var binding: B

     abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,getLayoutId())
    }

    inline fun <reified T> onStartActivity(context: Context, block : Intent.() -> Unit){
        val intent = Intent(context,T::class.java)
        intent.block()
        context.startActivity(intent)
    }
}