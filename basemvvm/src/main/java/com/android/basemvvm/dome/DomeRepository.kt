package com.android.basemvvm.dome

import com.android.basemvvm.base.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class DomeRepository : Repository() {

    fun search(): Flow<String> {
        return flow<String> {
            delay(1000)
            emit("ss")
        }.flowOn(Dispatchers.IO)
    }
}