package com.android.basemvvm.base.mvvm

import com.android.basemvvm.base.BaseViewModel
import java.lang.ref.WeakReference

/**
 * create by caiyx in 2021/8/27
 */
abstract class BaseMVVMViewModel<VM, M : BaseRepository> : BaseViewModel() {

    var repository: M? = null
    private var viewRef: WeakReference<VM>? = null

    init {
        repository = createRepository()
    }

    fun setView(view: Any) {
        viewRef = WeakReference(view as VM);
    }

    fun getView(): VM? {
        return viewRef?.get()
    }

    override fun onCleared() {
        super.onCleared()
        repository = null
    }

    abstract fun createRepository(): M
}