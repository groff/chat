package com.gma.qpmini.common

import com.gma.qpmini.api.ChatClient

abstract class Repository {
    val client = ChatClient()
}