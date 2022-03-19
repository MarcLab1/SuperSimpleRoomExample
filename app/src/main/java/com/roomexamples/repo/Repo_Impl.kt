package com.roomexamples.repo

import androidx.lifecycle.LiveData
import androidx.room.Database
import com.roomexamples.database.SomethingDatabase
import com.roomexamples.model.Something
import kotlinx.coroutines.flow.Flow


class Repo_Impl(private val somethingDatabase: SomethingDatabase) : Repo {

    private val somethingDao = somethingDatabase.dao()

    override suspend fun insertSomething(something: Something) {
        return somethingDao.insert(something)
    }

    override suspend fun updateSomething(something: Something) {
       return somethingDao.update(something)
    }

    override suspend fun deleteSomething(something: Something) {
        return somethingDao.delete(something)
    }

    override suspend fun getSomethingById(id: Int): Something {
        return somethingDao.getSomethingById(id)
    }

    override suspend fun getSomethingsList(): List<Something> {
        return somethingDao.getSomethingsList()
    }

    override fun getSomethingsFlow(): Flow<List<Something>> {
        return somethingDao.getSomethingsFlow()
    }
}