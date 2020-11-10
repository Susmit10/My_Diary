package com.example.mydiary

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.selects.select

@Dao
interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("Select * from `notes table` order by id ASC")
    fun getAllNotes(): LiveData<List<Note>>

}