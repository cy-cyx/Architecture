package com.android.app1.dome1

import com.android.app1.BR
import com.android.basemvvm.base.BaseViewModel
import com.android.basemvvm.base.mvvm.BaseMVVMViewModel

/**
 * create by caiyx in 2021/8/26
 */
class Dome1ViewModel : BaseMVVMViewModel<Dome1Activity,Dome1Repository>() {

    override fun variableId(): Int = BR.viewModel

    override fun createRepository(): Dome1Repository = Dome1Repository.instance


}