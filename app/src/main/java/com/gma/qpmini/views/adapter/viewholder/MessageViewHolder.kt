package com.gma.qpmini.views.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.gma.qpmini.databinding.MessageCurrentUserBinding
import com.gma.qpmini.databinding.MessageParticipantBinding
import com.gma.qpmini.messages.model.Messages

abstract class MessageViewHolder<in T>(itemView: ViewBinding) : RecyclerView.ViewHolder(itemView.root){
    abstract fun bind(item: T)
}

class CurrentUserViewHolder(val vb: MessageCurrentUserBinding) : MessageViewHolder<Messages>(vb) {
    override fun bind(item: Messages) {
        vb.message.text = item.body
    }
}

class ParticipantViewHolder(val vb: MessageParticipantBinding) : MessageViewHolder<Messages>(vb) {
    override fun bind(item: Messages) {
        vb.message.text = item.body
    }
}