package com.gma.qpmini.views

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gma.qpmini.messages.model.Messages
import com.gma.qpmini.messages.repository.MessagesRepository
import com.gma.qpmini.participant.model.Participant
import com.gma.qpmini.participant.repository.ParticipantRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.koin.java.KoinJavaComponent.inject

const val PARTICIPANT_ID = "671aa2b8-0210-11ec-9a03-0242ac130003"

class ChatViewModel : ViewModel() {

    private val participantRepo: ParticipantRepository by inject(ParticipantRepository::class.java)
    private val messagesRepo: MessagesRepository by inject(MessagesRepository::class.java)

    fun loadView(): Participant = runBlocking {
        participantRepo.loadParticipant(participantId = PARTICIPANT_ID)
    }

    /**
     *    TODO
     *    - Receive POST response and inform list adapter
     *    - Change this to livedata
     */
    var messages = mutableListOf<Messages>()
    var onMessageAdded = MutableLiveData<Int>()

    fun send(message: String) = runBlocking {
        launch {
            messagesRepo.sendMessage(participantId = PARTICIPANT_ID, message = message)
        }
    }
}