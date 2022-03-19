package com.roomexamples.di

import android.app.Application
import androidx.room.Room
import com.roomexamples.database.SomethingDatabase
import com.roomexamples.repo.Repo
import com.roomexamples.repo.Repo_Impl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideString() = "blah blah blah"

    @Provides
    @Singleton
    fun provideDatabase(app: Application): SomethingDatabase {
        return Room.databaseBuilder(app, SomethingDatabase::class.java, "db")
            .fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideRepo(somethingDatabase: SomethingDatabase) : Repo
    {
        return Repo_Impl(somethingDatabase)
    }
}