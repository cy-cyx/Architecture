package com.android.app1.dome1.fragment

import android.view.View
import android.widget.Toast
import com.android.app1.BR
import com.android.app1.R
import com.android.app1.dome1.Dome1Repository
import com.android.basemvvm.base.mvvm.BaseMVVMViewModel

/**
 * create by caiyx in 2021/8/27
 */
class ViewModel1 : BaseMVVMViewModel<Fragment1, Dome1Repository>() {

    override fun variableId(): Int = BR.viewModel

    override fun createRepository(): Dome1Repository = Dome1Repository.instance

    val onClick = View.OnClickListener {
        when (it.id) {
            R.id.bn_message -> {
                Toast.makeText(getView()?.context, "message", Toast.LENGTH_SHORT).show()
            }
        }
    }
}