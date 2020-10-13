package com.example.connect4pro

import android.app.Application

class Connect4ProApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        GameRepository.initialize(this)
    }
}