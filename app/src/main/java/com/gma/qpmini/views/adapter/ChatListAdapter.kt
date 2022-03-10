package com.gma.qpmini.views.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gma.qpmini.R
import com.gma.qpmini.databinding.MessageCurrentUserBinding
import com.gma.qpmini.databinding.MessageParticipantBinding
import com.gma.qpmini.messages.model.Messages
import com.gma.qpmini.messages.model.VIEW_TYPE_CURRENT_USER
import com.gma.qpmini.messages.model.VIEW_TYPE_PARTICIPANT
import com.gma.qpmini.views.adapter.viewholder.CurrentUserViewHolder
import com.gma.qpmini.views.adapter.viewholder.MessageViewHolder
import com.gma.qpmini.views.adapter.viewholder.ParticipantViewHolder
import java.lang.IllegalArgumentException

class ChatListAdapter(var data: MutableList<Messages>) :
    RecyclerView.Adapter<MessageViewHolder<*>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder<*> {
        return when (viewType) {
            VIEW_TYPE_CURRENT_USER -> {
                val binding = MessageCurrentUserBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                CurrentUserViewHolder(binding)
            }
            VIEW_TYPE_PARTICIPANT -> {
                val binding = MessageParticipantBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                ParticipantViewHolder(binding)
            }
            else -> {
                throw IllegalArgumentException(parent.context.resources.getString(R.string.error_view_type_adapter))
            }
        }
    }

    override fun onBindViewHolder(holder: MessageViewHolder<*>, position: Int) {
        val item = data[position]
        when (holder) {
            is CurrentUserViewHolder -> {
                holder.bind(item)
            }
            is ParticipantViewHolder -> {
                holder.bind(item)
            }
            else -> {
                throw IllegalArgumentException()
            }
        }
    }

    override fun getItemCount() = data.size

    override fun getItemViewType(position: Int) = data[position].viewType
}