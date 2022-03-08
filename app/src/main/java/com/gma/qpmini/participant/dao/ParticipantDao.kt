package com.gma.qpmini.participant.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.gma.qpmini.participant.model.Participant

@Dao
interface ParticipantDao {

    @Insert(onConflict = REPLACE)
    fun insert(participant: Participant)

    @Delete
    fun delete(participant: Participant)

    @Update(onConflict = REPLACE)
    fun update(participant: Participant)

    @Query("SELECT * FROM participant WHERE participant.id = :participantId")
    fun selectParticipantById(participantId: String) : Participant?
}