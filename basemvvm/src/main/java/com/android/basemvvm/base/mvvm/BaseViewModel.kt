package com.android.basemvvm.base.mvvm

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel<M : BaseRepository> : ViewModel(), LifecycleObserver, CoroutineScope {
    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    var repository: M? = null

    init {
        repository = createRepository()
    }

    override fun onCleared() {
        super.onCleared()
        cancel()
    }

    abstract fun variableId(): Int

    abstract fun createRepository(): M

    // 通用控件
    val showLoading = MutableLiveData<Boolean>()
}
