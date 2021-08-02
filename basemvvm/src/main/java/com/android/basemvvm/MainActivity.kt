package com.android.basemvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.launcher.ARouter
import com.example.basemvvm.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun click(view: View) {
        ARouter.getInstance().build(ActivityPathList.sDomeActivity).navigation(this)
    }
}