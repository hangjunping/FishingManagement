//package com.sinovatio.sample.base;
//
//import android.os.Bundle;
//
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.databinding.DataBindingUtil;
//import androidx.databinding.ViewDataBinding;
//
//import com.sinovatio.sample.databinding.ActivityMainBinding;
//
///**
// * @author zjp1002038
// */
//public abstract class BaseActivity<B extends ViewDataBinding>  extends AppCompatActivity {
//
//    public B binding;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        binding= DataBindingUtil.setContentView(this, getLayoutId());
//    }
//
//    /**
//     * 获取活动页面的布局id
//     * @return
//     */
//    protected abstract int getLayoutId();
//
////    inline fun <reified T> startActivity(context: Context,block : Intent.() -> Unit){
////        val intent = Intent(context,T::class.java)
////        intent.block()
////        context.startActivity(intent)
////    }
//}
