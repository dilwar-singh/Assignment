package com.example.application.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.application.model.Project

@Database(entities = [Project::class], version = 1)
abstract class ProjectDB : RoomDatabase() {

    abstract fun getProjectDAO(): ProjectDAO

}