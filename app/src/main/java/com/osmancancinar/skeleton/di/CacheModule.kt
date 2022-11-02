package com.osmancancinar.skeleton.di

import android.content.Context
import androidx.room.Room
import com.osmancancinar.skeleton.business.data.cache.CacheDataSource
import com.osmancancinar.skeleton.business.data.cache.CacheDataSourceImpl
import com.osmancancinar.skeleton.business.domain.models.Model
import com.osmancancinar.skeleton.business.domain.util.mappers.EntityMapper
import com.osmancancinar.skeleton.framework.data_source.cache.service.DaoService
import com.osmancancinar.skeleton.framework.data_source.cache.service.DaoServiceImpl
import com.osmancancinar.skeleton.framework.data_source.cache.database.AppDao
import com.osmancancinar.skeleton.framework.data_source.cache.database.Database
import com.osmancancinar.skeleton.framework.data_source.cache.mappers.CacheMapper
import com.osmancancinar.skeleton.framework.data_source.cache.model.CacheEntity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Dependency Injection for Cache Module.Provides Cache Mapper, Database, App Dao, Dao Service & Network Data Source.
 */
@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Singleton
    @Provides
    fun provideCacheMapper(): EntityMapper<CacheEntity, Model> {
        return CacheMapper()
    }

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): Database {
        return Room.databaseBuilder(
            context,
            Database::class.java,
            Database.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideAppDao(database: Database): AppDao {
        return database.appDao()
    }

    @Singleton
    @Provides
    fun provideDaoService(appDao: AppDao): DaoService {
        return DaoServiceImpl(appDao)
    }

    @Singleton
    @Provides
    fun provideCacheDataSource(
        daoService: DaoService,
        cacheMapper: CacheMapper
    ): CacheDataSource {
        return CacheDataSourceImpl(daoService, cacheMapper)
    }
}