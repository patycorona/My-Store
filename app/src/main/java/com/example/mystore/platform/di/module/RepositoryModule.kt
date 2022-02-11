package com.example.mystore.platform.di.module

import com.example.mystore.api.CoreHomeApi
import com.example.mystore.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ActivityComponent::class)
class RepositoryModule {

    @Provides
    fun productRepositoryProvider(apiService: CoreHomeApi): ProductRepository = ProductRepository(apiService)
}