package com.android.basemvvm.base.mvvm


/**
 *
 * 建议用法：
 *
 * class DomeRepository : BaseRepository() {
 *
 *    fun search(text: String): Flow<String> {
 *       return flow<String> {
 *           delay(1000)
 *            emit(text)
 *        }.flowOn(Dispatchers.IO)
 *    }
}*/
abstract class BaseRepository {

}