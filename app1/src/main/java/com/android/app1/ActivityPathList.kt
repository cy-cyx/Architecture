package com.android.app1

import com.android.app1.dome.DomeActivity

object ActivityPathList {

    val activitys = hashMapOf<String, Any>()

    const val sDomeActivity = "/main/domeActivity"

    init {
        activitys[sDomeActivity] = DomeActivity::class.java
    }
}