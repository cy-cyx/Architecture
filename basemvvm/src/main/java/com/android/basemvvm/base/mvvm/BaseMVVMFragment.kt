package com.android.basemvvm.base.mvvm

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.basemvvm.base.BaseFragment
import java.lang.reflect.ParameterizedType

/**
 * create by caiyx in 2021/8/26
 */
abstract class BaseMVVMFragment<M : BaseRepository, VM : BaseViewModel<M>> : BaseFragment() {

    protected var viewModel: VM? = null

    override fun setContentView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return initViewModel(inflater, container)
    }

    @SuppressLint("UseRequireInsteadOfGet")
    private fun initViewModel(inflater: LayoutInflater, container: ViewGroup?): View? {
        val type = javaClass.genericSuperclass
        viewModel = ViewModelProvider(
            this, ViewModelProvider.AndroidViewModelFactory
                .getInstance(activity!!.application)
        ).get((type as ParameterizedType).actualTypeArguments[1] as Class<VM>)
        val viewDataBinding =
            DataBindingUtil.inflate<ViewDataBinding>(inflater, getLayoutId(), container, true)
        viewDataBinding.lifecycleOwner = this
        viewDataBinding.setVariable(viewModel!!.variableId(), viewModel)

        initViewModelBase()

        return viewDataBinding.root
    }

    private fun initViewModelBase() {
        lifecycle.addObserver(viewModel!!)

        viewModel?.showLoading?.observe(this.viewLifecycleOwner, Observer<Boolean> {
            if (it) {
                loadingDialog.show()
            } else {
                loadingDialog.dismiss()
            }
        })
    }

}