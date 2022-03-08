package com.gma.qpmini.api

import com.gma.qpmini.messages.model.Messages
import com.gma.qpmini.participant.model.Participant
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*

class ChatClient {

    private val client = HttpClient(Android) {
        install(JsonFeature) {
            serializer = GsonSerializer {
                setPrettyPrinting()
                disableHtmlEscaping()
            }
        }
    }

    /**
     * participantId - Participant id, which the current user is chatting
     */
    suspend fun getParticipant(participantId: String) : Participant {
        return client.get("https://us-central1-quantumpigeon-aries.cloudfunctions.net/candidate/profile/$participantId")
    }

    /**
     * participantId - Participant id, which the current user is chatting
     */
    suspend fun sendMessage(participantId: String, body: String) : Messages {
        return client.post("https://us-central1-quantumpigeon-aries.cloudfunctions.net/candidate/chat/$participantId") {
            this.body = body
        }
    }
}