package com.example.mystore.platform.di.component

import com.example.mystore.platform.di.module.RepositoryModule
import com.example.mystore.platform.di.module.RetrofitModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RepositoryModule::class,
        RetrofitModule::class
    ]
)
interface MainComponent {
}