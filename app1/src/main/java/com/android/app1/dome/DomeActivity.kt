package com.android.app1.dome

import com.alibaba.android.arouter.facade.annotation.Route
import com.android.app1.ActivityPathList
import com.android.app1.R
import com.android.basemvvm.base.BaseActivity

@Route(path = ActivityPathList.sDomeActivity)
class DomeActivity : BaseActivity<DomeRepository, DomeViewModel>() {

    override fun getLayoutId(): Int = R.layout.activity_dome


}