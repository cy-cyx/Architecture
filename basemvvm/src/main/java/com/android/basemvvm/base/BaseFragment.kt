package com.android.basemvvm.base

import android.app.Dialog
import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * create by caiyx in 2021/8/26
 */
abstract class BaseFragment : Fragment() {

    // 通用的部分
    protected lateinit var loadingDialog: Dialog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        loadingDialog = ProgressDialog(activity)

        return setContentView(inflater, container, savedInstanceState)
    }

    open fun setContentView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       return inflater.inflate(getLayoutId(), container, false)
    }


    abstract fun getLayoutId(): Int

}