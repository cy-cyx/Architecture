package com.android.basemvvm.base

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.cancel

abstract class BaseViewModel<M : BaseModel> : ViewModel(), LifecycleObserver {

    var model: BaseModel? = null

    fun attach() {
        model = createModel()
    }

    fun unAttach() {
        model?.cancel()
        model = null
    }

    abstract fun variableId(): Int

    abstract fun createModel(): M
}
