package com.android.app1.dome

import com.alibaba.android.arouter.facade.annotation.Route
import com.android.app1.ActivityPathList
import com.android.app1.R
import com.android.basemvvm.base.BaseActivity
import com.android.basemvvm.base.mvvm.BaseMVVMActivity

@Route(path = ActivityPathList.sDomeActivity)
class DomeActivity : BaseMVVMActivity<DomeRepository, DomeViewModel>() {

    override fun getLayoutId(): Int = R.layout.activity_dome

    override fun initView() {

    }


}