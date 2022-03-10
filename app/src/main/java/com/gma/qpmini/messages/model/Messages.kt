package com.gma.qpmini.messages.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gma.qpmini.enums.MessageType
import com.gma.qpmini.room.TABLE_MESSAGES

const val VIEW_TYPE_CURRENT_USER = 0
const val VIEW_TYPE_PARTICIPANT = 1

@Entity(
    tableName = TABLE_MESSAGES
)
data class Messages(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long,
    @ColumnInfo(name = "body")
    var body: String,
    /**
     * This field is to identify if the message is a text, image, etc
     */
    @ColumnInfo(name = "type")
    var type: MessageType,
    @ColumnInfo(name = "width")
    var width: Int?,
    @ColumnInfo(name = "height")
    var height: Int?,
    /**
     * This field is to identify if the message was sent from the current user or the participant
     */
    @ColumnInfo(name = "viewType")
    var viewType: Int
)