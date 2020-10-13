package com.example.connect4pro

import androidx.lifecycle.ViewModel

class GameListViewModel : ViewModel() {

    /*
    val games = mutableListOf<Game>()

    init {
        for (i in 0 until 50) {
            val game = Game()
            //Put all dummy game info here.
            game.moveNumber = i
            game.winner = "Red"
            games += game
        }
    }*/

    private val gameRepository = GameRepository.get()
    val gameListLiveData = gameRepository.getGames()
}