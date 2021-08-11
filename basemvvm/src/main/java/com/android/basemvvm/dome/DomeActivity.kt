package com.android.basemvvm.dome

import com.alibaba.android.arouter.facade.annotation.Route
import com.android.basemvvm.ActivityPathList
import com.android.basemvvm.base.BaseActivity
import com.example.basemvvm.R

@Route(path = ActivityPathList.sDomeActivity)
class DomeActivity : BaseActivity<DomeRepository, DomeViewModel>() {

    override fun getLayoutId(): Int = R.layout.activity_dome
}