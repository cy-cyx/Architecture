package com.android.basemvvm.base

import android.app.Dialog
import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import java.lang.reflect.ParameterizedType

abstract class BaseActivity<M : BaseRepository, VM : BaseViewModel<M>> : AppCompatActivity() {

    protected var viewModel: VM? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadingDialog = ProgressDialog(this)

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

    abstract fun getLayoutId(): Int

    // 通用的部分
    private lateinit var loadingDialog : Dialog

}