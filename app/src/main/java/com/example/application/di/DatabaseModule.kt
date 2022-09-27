package com.example.application.di

import android.content.Context
import androidx.room.Room
import com.example.application.db.ProjectDB
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideProjectDB(context: Context): ProjectDB {
        return Room.databaseBuilder(context, ProjectDB::class.java, "ProjectDB").build()
    }
}