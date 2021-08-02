package com.android.basemvvm.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BaseModel : CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Job() + Dispatchers.Main


}