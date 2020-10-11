package com.example.connect4pro

import androidx.lifecycle.ViewModel
import java.util.*


class GameModel: ViewModel() {

    var gameBoard = arrayOf(
        arrayOf(0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0)
    )

    var playerColor = 1
    var withAI = false
    var whoseTurn = 1
    var moveList = ""
    var winner = "Tie"


}