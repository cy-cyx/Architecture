package com.android.basemvvm

object ActivityPathList {

    val activitys = hashMapOf<String, Any>()

    const val DomeActivity = "/main/domeActivity"

    init {
        activitys[DomeActivity] = DomeActivity::class.java
    }
}