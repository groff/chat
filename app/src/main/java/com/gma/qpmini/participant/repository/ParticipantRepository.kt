package com.gma.qpmini.participant.repository

import com.gma.qpmini.api.ChatClient
import com.gma.qpmini.common.Repository
import com.gma.qpmini.participant.dao.ParticipantDao
import com.gma.qpmini.participant.model.Participant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ParticipantRepository(private val dao: ParticipantDao) : Repository() {

    private fun insertParticipant(participant: Participant) {
        dao.insert(participant)
    }

    suspend fun loadParticipant(participantId: String): Participant {
        return withContext(Dispatchers.IO) {
            var data = dao.selectParticipantById(participantId = participantId)
            if (data == null) {
                data = client.getParticipant(participantId = participantId)
                insertParticipant(data)
            }
            return@withContext data
        }
    }
}