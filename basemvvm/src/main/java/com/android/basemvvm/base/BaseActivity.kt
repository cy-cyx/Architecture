package com.android.basemvvm.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import java.lang.reflect.ParameterizedType

abstract class BaseActivity<M : BaseModel, VM : BaseViewModel<M>> : AppCompatActivity() {

    protected var viewModel: VM? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
    }

    private fun initViewModel() {
        val type = javaClass.genericSuperclass
        viewModel = ViewModelProvider(
            this, ViewModelProvider.AndroidViewModelFactory
                .getInstance(application)
        ).get((type as ParameterizedType).actualTypeArguments[1] as Class<VM>)
        val viewDataBinding = DataBindingUtil.setContentView<ViewDataBinding>(this, getLayoutId())
        viewDataBinding.lifecycleOwner = this
        viewDataBinding.setVariable(viewModel!!.variableId(), viewModel)

        lifecycle.addObserver(viewModel!!)
        viewModel?.attach()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel?.let {
            lifecycle.removeObserver(it)
            it.unAttach()
        }
    }

    abstract fun getLayoutId(): Int
}