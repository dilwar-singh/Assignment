package com.example.application

import android.app.Application
import com.example.application.di.ApplicationComponent
import com.example.application.di.DaggerApplicationComponent

class MainApplication  : Application() {

        lateinit var applicationComponent: ApplicationComponent

        override fun onCreate() {
            super.onCreate()

            applicationComponent = DaggerApplicationComponent.factory().create(this)
        }
    }