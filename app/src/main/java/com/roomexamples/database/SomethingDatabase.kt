package com.roomexamples.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.roomexamples.model.Something

@Database (entities = [Something::class], version = 1)
abstract class SomethingDatabase : RoomDatabase() {

    abstract fun dao() : SomethingDao

}