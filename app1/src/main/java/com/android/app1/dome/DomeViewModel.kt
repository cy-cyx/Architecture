package com.android.app1.dome

import android.view.View
import android.widget.Toast
import androidx.databinding.library.baseAdapters.BR
import com.android.app1.R
import com.android.basemvvm.base.BaseViewModel
import com.android.basemvvm.base.mvvm.BaseMVVMViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class DomeViewModel : BaseMVVMViewModel<DomeActivity, DomeRepository>() {

    override fun variableId(): Int = BR.viewModel

    override fun createRepository(): DomeRepository = DomeRepository()

    // 输入的文本
    var inputText: String = ""

    // 点击事件
    var onClickListen = View.OnClickListener { v ->
        when (v?.id) {
            R.id.bu_query -> {
                launch {
                    repository?.search(inputText)?.onStart {
                        showLoading.value = true
                    }?.onCompletion {
                        showLoading.value = false
                    }?.collect {
                        Toast.makeText(v.context, it, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}