package com.gma.qpmini.views

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gma.qpmini.messages.model.Messages

class ChatListAdapter(private val data: List<Messages>) : RecyclerView.Adapter<ChatListAdapter.ChatViewHolder>() {

    /**
     *    TODO
     *    - Create logic to identify if it's current user message or participant message
     *    - Create layout for both messages
     */

    class ChatViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = data.size
}