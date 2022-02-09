package com.example.mystore.platform.di.component

import com.example.mystore.platform.di.module.RepositoryModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RepositoryModule::class
    ]
)
interface MainComponent {
}