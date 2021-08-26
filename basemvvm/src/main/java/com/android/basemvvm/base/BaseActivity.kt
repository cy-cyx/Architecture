package com.android.basemvvm.base

import android.app.Dialog
import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * create by caiyx in 2021/8/26
 */
abstract class BaseActivity : AppCompatActivity() {

    // 通用的部分
    protected lateinit var loadingDialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView()
        initView()
        loadingDialog = ProgressDialog(this)
    }

    open fun setContentView() {
        setContentView(getLayoutId())
    }

    abstract fun getLayoutId(): Int

    abstract fun initView()
}