package com.gma.qpmini.messages.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gma.qpmini.enums.MessageType
import com.gma.qpmini.room.TABLE_MESSAGES
import java.util.*

const val VIEW_TYPE_CURRENT_USER = 0
const val VIEW_TYPE_PARTICIPANT = 1

@Entity(
    tableName = TABLE_MESSAGES
)
data class Messages(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "body")
    var body: String,
    /**
     * This field is to identify if the message is a text, image, etc
     */
    @ColumnInfo(name = "type")
    var type: String = MessageType.Text.type,
    @ColumnInfo(name = "width")
    var width: Int? = 0,
    @ColumnInfo(name = "height")
    var height: Int? = 0,
    /**
     * This field is to identify if the message was sent from the current user or the participant
     * Current User = 0
     * Participant = 1
     */
    @ColumnInfo(name = "viewType")
    var viewType: Int = 0
)