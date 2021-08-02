package com.android.basemvvm.dome

import android.view.View
import android.widget.Toast
import androidx.databinding.library.baseAdapters.BR
import com.android.basemvvm.base.BaseViewModel
import com.example.basemvvm.R

class DomeViewModel : BaseViewModel<DomeModel>() {

    override fun variableId(): Int = BR.viewModel

    override fun createModel(): DomeModel = DomeModel()

    // 输入的文本
    var inputText: String = ""

    // 点击事件
    var onClickListen = View.OnClickListener { v ->
        when (v?.id) {
            R.id.bu_query -> {
                Toast.makeText(v.context,"${inputText}",Toast.LENGTH_SHORT).show()
            }
        }
    }
}