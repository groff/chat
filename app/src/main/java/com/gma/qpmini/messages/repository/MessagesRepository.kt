package com.gma.qpmini.messages.repository

import com.gma.qpmini.common.Repository
import com.gma.qpmini.messages.dao.MessagesDao
import com.gma.qpmini.messages.model.Messages
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MessagesRepository(private val dao: MessagesDao) : Repository() {

    suspend fun sendMessage(participantId: String, message: Messages): Messages? {
        return withContext(Dispatchers.IO) {
            val response = client.sendMessage(participantId = participantId, message = message)
            if (response.body.isNullOrEmpty()) { // FIXME I don't like this solution.
                null
            } else {
                response.viewType = 1
                response
            }
        }
    }
}