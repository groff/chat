package com.gma.qpmini.messages.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.gma.qpmini.messages.model.Messages

@Dao
interface MessagesDao {

    @Insert(onConflict = REPLACE)
    fun insertAll(vararg messages: Messages)

    @Insert(onConflict = REPLACE)
    fun insert(participant: Messages)

    @Delete
    fun delete(participant: Messages)

    @Update(onConflict = REPLACE)
    fun update(participant: Messages)

    @Query("SELECT * FROM messages")
    fun getMessages() : LiveData<Messages>
}