package com.android.basemvvm

import com.android.basemvvm.dome.DomeActivity

object ActivityPathList {

    val activitys = hashMapOf<String, Any>()

    const val sDomeActivity = "/main/domeActivity"

    init {
        activitys[sDomeActivity] = DomeActivity::class.java
    }
}