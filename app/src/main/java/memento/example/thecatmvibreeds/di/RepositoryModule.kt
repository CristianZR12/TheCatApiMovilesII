package memento.example.thecatmvibreeds.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import memento.example.thecatmvibreeds.repository.CatRepository
import memento.example.thecatmvibreeds.retrofit.CatRetrofit
import memento.example.thecatmvibreeds.retrofit.NetworkMapper
import memento.example.thecatmvibreeds.room.CacheMapper
import memento.example.thecatmvibreeds.room.CatDao
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideCatRepository(
            catDao: CatDao,
            catRetrofit: CatRetrofit,
            cacheMapper: CacheMapper,
            networkMapper: NetworkMapper
    ):CatRepository {
        return CatRepository(catDao, catRetrofit, cacheMapper, networkMapper)
    }
}