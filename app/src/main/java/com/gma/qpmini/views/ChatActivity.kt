package com.gma.qpmini.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.gma.qpmini.databinding.ActivityChatBinding
import com.gma.qpmini.views.adapter.ChatListAdapter
import com.squareup.picasso.Picasso

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
            viewModel.send(binding.message.text.toString())
            cleanText()
        }
    }

    private fun initChatList() {
        val adapter = ChatListAdapter(mutableListOf())
        adapter.data = viewModel.messages

        viewModel.onMessageAdded.observe(this) { position ->
            adapter.notifyItemInserted(position)
        }
    }

    private fun cleanText() {
        binding.message.setText("")
    }
}