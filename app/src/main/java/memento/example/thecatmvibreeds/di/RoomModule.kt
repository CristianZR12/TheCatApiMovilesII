package memento.example.thecatmvibreeds.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import dagger.hilt.android.qualifiers.ApplicationContext
import memento.example.thecatmvibreeds.room.CatDao
import memento.example.thecatmvibreeds.room.CatDatabase
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun provideCatDb(@ApplicationContext context: Context):CatDatabase {
        return Room
                .databaseBuilder(context, CatDatabase::class.java, CatDatabase.DATABASE_NAME).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideCatDao(catDatabase: CatDatabase):CatDao {
        return catDatabase.catDao()
    }
}