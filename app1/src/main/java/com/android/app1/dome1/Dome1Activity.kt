package com.android.app1.dome1

import com.android.app1.R
import com.android.basemvvm.base.mvvm.BaseMVVMActivity

/**
 * create by caiyx in 2021/8/26
 */
class Dome1Activity:BaseMVVMActivity<Dome1Repository,Dome1ViewModel>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_dome1
    }


}