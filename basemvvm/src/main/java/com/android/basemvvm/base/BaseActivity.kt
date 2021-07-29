package com.android.basemvvm.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import java.lang.reflect.ParameterizedType

abstract class BaseActivity<T : BaseViewModel> : AppCompatActivity() {

    protected var viewModel: T? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
    }

    private fun initViewModel() {
        val type = javaClass.genericSuperclass
        viewModel = ViewModelProvider(
            this, ViewModelProvider.AndroidViewModelFactory
                .getInstance(application)
        ).get((type as ParameterizedType).actualTypeArguments[1] as Class<T>)
        val viewDataBinding = DataBindingUtil.setContentView<ViewDataBinding>(this, getLayoutId())
        viewDataBinding.lifecycleOwner = this
        viewDataBinding.setVariable(variableId(), viewModel)
    }

    abstract fun getLayoutId(): Int
    abstract fun variableId(): Int
}