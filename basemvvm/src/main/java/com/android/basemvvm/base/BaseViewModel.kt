package com.android.basemvvm.base

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel<M : BaseRepository> : ViewModel(), LifecycleObserver, CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Job() + Dispatchers.Main

    var repository: M? = null

    init {
        repository = createModel()
    }

    override fun onCleared() {
        super.onCleared()
        cancel()
    }

    abstract fun variableId(): Int

    abstract fun createModel(): M

    // 通用控件
    val showLoading = MutableLiveData<Boolean>()
}
