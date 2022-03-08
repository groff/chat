package com.gma.qpmini.participant.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.gma.qpmini.room.TABLE_PARTICIPANT

@Entity(
    tableName = TABLE_PARTICIPANT,
    indices = [
        Index(value = ["id"], unique = true)
    ]
)
data class Participant(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: String,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "imageURL")
    var imageURL: String
)