package com.gma.qpmini

import android.app.Application
import com.gma.qpmini.room.roomModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ChatApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ChatApplication)
            modules(
                roomModule
            )
        }
    }
}