package com.gma.qpmini.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.gma.qpmini.databinding.ActivityChatBinding
import com.gma.qpmini.messages.model.Messages
import com.gma.qpmini.views.adapter.ChatListAdapter
import com.squareup.picasso.Picasso
import java.util.*

class ChatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChatBinding
    private val viewModel: ChatViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        loadView()
        initChatList()
    }

    private fun loadView() {
        val participant = viewModel.loadView()
        binding.toolbarChat.name.text = participant.name
        Picasso.get()
            .load(participant.imageURL)
            .into(binding.toolbarChat.userIcon)

        binding.send.setOnClickListener {
            val currentUserMessage = Messages(
                id = UUID.randomUUID().toString(),
                body = binding.message.text.toString()
            )
            viewModel.send(currentUserMessage)
            cleanText()
        }
    }

    private fun initChatList() {
        binding.chatList.adapter = ChatListAdapter(viewModel.messages)
        viewModel.onMessageAdded.observe(this) { position ->
            (binding.chatList.adapter as ChatListAdapter).notifyItemInserted(position)
            binding.chatList.smoothScrollToPosition(position)
        }
    }

    private fun cleanText() {
        binding.message.text.clear()
    }
}