package com.gma.qpmini.api

import android.util.Log
import com.gma.qpmini.messages.model.Messages
import com.gma.qpmini.participant.model.Participant
import com.google.gson.JsonParser
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.json.Json

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
    suspend fun getParticipant(participantId: String): Participant {
        return client.get("https://us-central1-quantumpigeon-aries.cloudfunctions.net/candidate/profile/$participantId")
    }

    /**
     * participantId - Participant id, which the current user is chatting
     */
    suspend fun sendMessage(participantId: String, message: Messages): Messages {
        val response: Messages =
            client.post("https://us-central1-quantumpigeon-aries.cloudfunctions.net/candidate/chat/$participantId") {
                headers {
                    append(HttpHeaders.ContentType, "application/json")
                }
                contentType(ContentType.Application.Json)
                body = message
            }
        return response
    }
}