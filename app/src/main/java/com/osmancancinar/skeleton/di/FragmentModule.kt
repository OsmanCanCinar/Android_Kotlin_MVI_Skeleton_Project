package com.osmancancinar.skeleton.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import com.osmancancinar.skeleton.framework.presentation.FragmentFactory

/**
 * Dependency Injection for custom Fragment Factory.
 */
@Module
@InstallIn(SingletonComponent::class)
object FragmentModule {

    @Singleton
    @Provides
    fun provideRepository(): androidx.fragment.app.FragmentFactory {
        return FragmentFactory()
    }
}