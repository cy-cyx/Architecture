package com.android.architecture

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainViewModel =
            ViewModelProvider(
                this, ViewModelProvider.AndroidViewModelFactory
                    .getInstance(application)
            ).get(MainViewModel::class.java)

        val viewDataBinding =
            DataBindingUtil.setContentView<ViewDataBinding>(
                this,
                R.layout.activity_main
            )

        viewDataBinding.lifecycleOwner = this
        viewDataBinding.setVariable(BR.data, mainViewModel)

        // 新建ViewModel
        // 绑定数据,Adapter自动绑定了
//        mainViewModel.text.observe(this, object : Observer<String> {
//            override fun onChanged(t: String?) {
//                tv_text.text = t
//            }
//        })

        tv_text.setOnClickListener {
            mainViewModel.onChangeText()
        }

        cv_color.setOnClickListener {
            mainViewModel.onChangeColor()
        }
    }
}
