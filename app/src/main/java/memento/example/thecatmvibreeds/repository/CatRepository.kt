package memento.example.thecatmvibreeds.repository

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import memento.example.thecatmvibreeds.retrofit.CatRetrofit
import memento.example.thecatmvibreeds.retrofit.NetworkMapper
import memento.example.thecatmvibreeds.room.CacheMapper
import memento.example.thecatmvibreeds.room.CatDao
import memento.example.thecatmvibreeds.utils.DataState
import java.lang.Exception

class CatRepository constructor(
        private val catDao:CatDao,
        private val catRetrofit:CatRetrofit,
        private val cacheMapper: CacheMapper,
        private val networkMapper: NetworkMapper
) {
    suspend fun getCats():Flow<DataState> = flow {
        emit(DataState.Loading)
        delay(1000)
        try {
            val catData = catRetrofit.getCats()
            val catMap = networkMapper.mapToEntityList(catData)
            for(tempCat in catMap) {
                catDao.insert(cacheMapper.mapFromEntity(tempCat))
            }
            val cacheCat = catDao.get()
            emit(DataState.Success(cacheMapper.mapToListEntity(cacheCat)))
        } catch (e:Exception) {
            emit(DataState.Error(e))
        }
    }
}