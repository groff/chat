package com.gma.qpmini.messages.repository

import com.gma.qpmini.api.ChatClient
import com.gma.qpmini.messages.dao.MessagesDao

class MessagesRepository(private val dao: MessagesDao) {

    private val client = ChatClient()

    /**
     *    TODO
     *    - Receive POST response, save in database, and send to viewModel
     */
    suspend fun sendMessage(participantId: String, message: String) {
        client.sendMessage(participantId = participantId, body = message)
    }
}