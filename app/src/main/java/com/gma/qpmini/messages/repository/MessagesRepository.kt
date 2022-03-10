package com.gma.qpmini.messages.repository

import com.gma.qpmini.common.Repository
import com.gma.qpmini.messages.dao.MessagesDao

class MessagesRepository(private val dao: MessagesDao) : Repository() {

    /**
     *    TODO
     *    - Receive POST response, save in database, and send to viewModel
     */
    suspend fun sendMessage(participantId: String, message: String) {
        client.sendMessage(participantId = participantId, body = message)
    }
}