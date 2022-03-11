package com.gma.qpmini.views

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gma.qpmini.messages.model.Messages
import com.gma.qpmini.messages.repository.MessagesRepository
import com.gma.qpmini.participant.model.Participant
import com.gma.qpmini.participant.repository.ParticipantRepository
import kotlinx.coroutines.*
import org.koin.java.KoinJavaComponent.inject

const val PARTICIPANT_ID = "671aa2b8-0210-11ec-9a03-0242ac130003"

class ChatViewModel : ViewModel() {

    private val participantRepo: ParticipantRepository by inject(ParticipantRepository::class.java)
    private val messagesRepo: MessagesRepository by inject(MessagesRepository::class.java)

    fun loadView(): Participant = runBlocking {
        participantRepo.loadParticipant(participantId = PARTICIPANT_ID)
    }

    var messages = mutableListOf<Messages>()
    var onMessageAdded = MutableLiveData<Int>()

    fun send(message: Messages) = viewModelScope.launch {
        messages.add(message)
        onMessageAdded.value = messages.size
        sendToApi(message = message)
    }

    private suspend fun sendToApi(message: Messages) {
        val newMessage = messagesRepo.sendMessage(participantId = PARTICIPANT_ID, message = message)
        if (newMessage != null) {
            messages.add(newMessage)
            onMessageAdded.value = messages.size
        }
    }
}