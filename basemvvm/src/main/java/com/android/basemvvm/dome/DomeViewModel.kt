package com.android.basemvvm.dome

import androidx.databinding.library.baseAdapters.BR
import com.android.basemvvm.base.BaseViewModel

class DomeViewModel : BaseViewModel<DomeModel>() {

    override fun variableId(): Int = BR.viewModel

    override fun createModel(): DomeModel = DomeModel()
}