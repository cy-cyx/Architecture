package com.android.basemvvm.base.mvvm

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.basemvvm.base.BaseActivity
import com.android.basemvvm.base.BaseViewModel
import java.lang.reflect.ParameterizedType

abstract class BaseMVVMActivity<VM : BaseViewModel> : BaseActivity() {

    protected var viewModel: VM? = null

    override fun setContentView() {
        initViewModel()
    }

    private fun initViewModel() {
        val type = javaClass.genericSuperclass
        viewModel = ViewModelProvider(
            this, ViewModelProvider.AndroidViewModelFactory
                .getInstance(application)
        ).get((type as ParameterizedType).actualTypeArguments[0] as Class<VM>)
        (viewModel as? BaseMVVMViewModel<*,*>)?.setView(this)

        if (useDataBinding()){
            val viewDataBinding = DataBindingUtil.setContentView<ViewDataBinding>(this, getLayoutId())
            viewDataBinding.lifecycleOwner = this
            viewDataBinding.setVariable(viewModel!!.variableId(), viewModel)
        }

        initViewModelBase()
    }

    private fun initViewModelBase() {
        lifecycle.addObserver(viewModel!!)

        viewModel?.showLoading?.observe(this, Observer<Boolean> {
            if (it) {
                loadingDialog.show()
            } else {
                loadingDialog.dismiss()
            }
        })
    }

    fun useDataBinding():Boolean{
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel?.let {
            lifecycle.removeObserver(it)
        }
    }
}