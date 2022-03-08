package com.gma.qpmini.room

import androidx.room.Room
import com.gma.qpmini.messages.repository.MessagesRepository
import com.gma.qpmini.participant.repository.ParticipantRepository
import org.koin.dsl.module
import org.koin.android.ext.koin.androidContext

val roomModule = module {
    single {
        val build = Room
            .databaseBuilder(
                androidContext(),
                QPMiniDatabase::class.java,
                DATABASE_NAME
            )
        build.fallbackToDestructiveMigration().build()
    }

    single { ParticipantRepository (get<QPMiniDatabase>().participantDao())}
    single { MessagesRepository (get<QPMiniDatabase>().messagesDao())}
}