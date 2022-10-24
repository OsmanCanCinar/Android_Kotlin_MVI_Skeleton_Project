package com.osmancancinar.skeleton.di

import androidx.fragment.app.FragmentFactory
import com.osmancancinar.skeleton.framework.presentation.MainFragmentFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FragmentModule {

    @Singleton
    @Provides
    fun provideRepository(): FragmentFactory {
    //fun provideRepository(string: String): FragmentFactory {
        //return MainFragmentFactory(string)
        return MainFragmentFactory()
    }
}