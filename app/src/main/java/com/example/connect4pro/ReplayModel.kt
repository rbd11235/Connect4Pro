package com.example.connect4pro

import androidx.lifecycle.ViewModel

class ReplayModel: ViewModel() {
    var gameBoard = arrayOf(
        arrayOf(0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0, 0, 0)
    )

    var currentTurn = 0
    var whoseTurn = 1
    var moveList = ""
    var winner = "Tie"
}