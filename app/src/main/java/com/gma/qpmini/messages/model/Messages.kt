package com.gma.qpmini.messages.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gma.qpmini.enums.MessageType
import com.gma.qpmini.room.TABLE_MESSAGES

@Entity(
    tableName = TABLE_MESSAGES
)
data class Messages(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long,
    @ColumnInfo(name = "body")
    var body: String,
    @ColumnInfo
    var type: MessageType,
    @ColumnInfo
    var width: Int?,
    @ColumnInfo
    var height: Int?
)