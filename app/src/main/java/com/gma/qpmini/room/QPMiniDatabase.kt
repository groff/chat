package com.gma.qpmini.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gma.qpmini.messages.dao.MessagesDao
import com.gma.qpmini.messages.model.Messages
import com.gma.qpmini.participant.model.Participant
import com.gma.qpmini.participant.dao.ParticipantDao

const val DATABASE_VERSION = 6
const val DATABASE_NAME = "qp.mini.chat"

@Database(
    version = DATABASE_VERSION,
    exportSchema = false,
    entities = [Participant::class, Messages::class],
)
abstract class QPMiniDatabase : RoomDatabase() {
    abstract fun participantDao(): ParticipantDao
    abstract fun messagesDao(): MessagesDao
}