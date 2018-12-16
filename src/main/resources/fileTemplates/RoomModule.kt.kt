package com.memebattle.memebattle.core.di.core.module

import android.content.Context
import androidx.room.Room
import com.bignerdranch.android.osm.data.room.AppDatabase
import com.memebattle.memebattle.core.di.core.scope.FragmentScope
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideAppDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "database").build()
    }
}