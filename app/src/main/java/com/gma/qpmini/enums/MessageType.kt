package com.gma.qpmini.enums

import com.google.gson.annotations.SerializedName

enum class MessageType(val type: String) {
    @SerializedName("text")
    Text("text"),
    @SerializedName("image")
    Image("image")
}