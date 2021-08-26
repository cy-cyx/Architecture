package com.android.basemvvm.base.mvvm

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.basemvvm.base.BaseActivity
import java.lang.reflect.ParameterizedType

abstract class BaseMVVMActivity<M : BaseRepository, VM : BaseViewModel<M>> : BaseActivity() {

    protected var viewModel: VM? = null

    override fun setContentView() {
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

    override fun onDestroy() {
        super.onDestroy()
        viewModel?.let {
            lifecycle.removeObserver(it)
        }
    }
}