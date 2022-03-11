package com.gma.qpmini.views.adapter.viewholder

import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.gma.qpmini.databinding.MessageCurrentUserBinding
import com.gma.qpmini.databinding.MessageParticipantBinding
import com.gma.qpmini.enums.MessageType
import com.gma.qpmini.messages.model.Messages
import com.squareup.picasso.Picasso

abstract class MessageViewHolder<in T>(itemView: ViewBinding) :
    RecyclerView.ViewHolder(itemView.root) {
    abstract fun bind(item: T)
}

class CurrentUserViewHolder(private val vb: MessageCurrentUserBinding) :
    MessageViewHolder<Messages>(vb) {
    override fun bind(item: Messages) {
        vb.message.text = item.body
    }
}

class ParticipantViewHolder(private val vb: MessageParticipantBinding) :
    MessageViewHolder<Messages>(vb) {
    override fun bind(item: Messages) {
        when (item.type) {
            MessageType.Text.type -> {
                setVisibility(showImage = false, vb = vb)
                vb.participantMessage.text = item.body
            }
            MessageType.Image.type -> {
                setVisibility(showImage = true, vb = vb)
                if (item.width != null && item.height != null) {
                    Picasso.get()
                        .load(item.body)
                        .resize(
                            item.width!!,
                            item.height!!
                        ) // I only used !! here, because I have a null check verification to reach this point
                        .into(vb.participantImage)
                } else {
                    Picasso.get()
                        .load(item.body)
                        .into(vb.participantImage)
                }
            }
        }
    }

    private fun setVisibility(showImage: Boolean, vb: MessageParticipantBinding) {
        vb.participantMessage.isVisible = !showImage
        vb.participantImage.isVisible = showImage
    }
}