package com.roomexamples.database

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.roomexamples.model.Something
import kotlinx.coroutines.flow.Flow

@Dao
interface SomethingDao {

    @Insert(onConflict = REPLACE)
    suspend fun insert(something: Something)

    @Delete
    suspend fun delete(something: Something)

    @Update
    suspend fun update(something: Something)

    @Query("SELECT * FROM something WHERE id=:id")
    suspend fun getSomethingById(id : Int) : Something

    @Query("SELECT * from something")
    fun getSomethingsFlow() : Flow<List<Something>>

    @Query("SELECT * from something")
    fun getSomethingsLiveData() : LiveData<List<Something>>

    @Query("SELECT * from something")
    suspend fun getSomethingsList() : List<Something>
}