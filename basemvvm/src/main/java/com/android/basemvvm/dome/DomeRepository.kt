package com.android.basemvvm.dome

import com.android.basemvvm.base.BaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class DomeRepository : BaseRepository() {

    fun search(text: String): Flow<String> {
        return flow<String> {
            delay(1000)
            emit(text)
        }.flowOn(Dispatchers.IO)
    }
}