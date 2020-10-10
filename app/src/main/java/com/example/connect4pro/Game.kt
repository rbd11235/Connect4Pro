package com.example.connect4pro

import java.util.*

data class Game(var id: UUID = UUID.randomUUID(),
                var moveNumber: Int = 0,
                var gameString: String = "",
                var winner: String = "",
                var date: Date = Date()
)