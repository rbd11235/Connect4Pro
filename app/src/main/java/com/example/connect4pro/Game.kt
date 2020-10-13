package com.example.connect4pro

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity (tableName = "table_game")
data class Game(@PrimaryKey var id: UUID = UUID.randomUUID(),
                var moveNumber: Int = 0,
                var gameString: String = "",
                var winner: String = "",
                var date: Date = Date()
)