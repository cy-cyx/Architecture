package com.android.app1

import com.android.app1.dome.DomeActivity
import com.android.app1.dome1.Dome1Activity

object ActivityPathList {

    val activitys = hashMapOf<String, Any>()

    const val sDomeActivity = "/main/domeActivity"
    const val sFragmentActivity = "/main/fragmentActivity"

    init {
        activitys[sDomeActivity] = DomeActivity::class.java
        activitys[sFragmentActivity] = Dome1Activity::class.java
    }
}