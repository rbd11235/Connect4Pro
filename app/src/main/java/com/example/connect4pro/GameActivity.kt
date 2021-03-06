package com.example.connect4pro

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import kotlin.random.Random
import kotlin.random.nextInt

private const val ID1 =
    "private.withAI"
private const val ID2 =
    "private.playerColor"


private const val RED = 1
private const val YELLOW = 2
class GameActivity : AppCompatActivity() {
    private lateinit var redLabel: TextView
    private lateinit var yellowLabel: TextView
    private lateinit var winLabel: TextView

    private lateinit var newGame: Button
    private lateinit var saveReplay: Button
    //Two dimensional array containing all the ImageViews that make up the board
    private lateinit var pieces: Array<Array<ImageView>>
    private lateinit var buttons: Array<ImageButton>


    private lateinit var button1: ImageButton
    private lateinit var button2: ImageButton
    private lateinit var button3: ImageButton
    private lateinit var button4: ImageButton
    private lateinit var button5: ImageButton
    private lateinit var button6: ImageButton
    private lateinit var button7: ImageButton


    private val gameModel: GameModel by lazy {
        ViewModelProviders.of(this).get(GameModel::class.java)
    }

    private val replayDetailViewModel: ReplayDetailViewModel by lazy {
        ViewModelProviders.of(this).get(ReplayDetailViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        redLabel = findViewById(R.id.redLabel)
        yellowLabel = findViewById(R.id.yellowLabel)
        winLabel = findViewById(R.id.win_label)

        button1 = findViewById(R.id.drop1)
        button2 = findViewById(R.id.drop2)
        button3 = findViewById(R.id.drop3)
        button4 = findViewById(R.id.drop4)
        button5 = findViewById(R.id.drop5)
        button6 = findViewById(R.id.drop6)
        button7 = findViewById(R.id.drop7)
        buttons = arrayOf(button1, button2, button3, button4, button5, button6, button7)
        newGame = findViewById(R.id.new_game)
        saveReplay = findViewById(R.id.save_replay)


        val A1: ImageView = findViewById(R.id.A1)
        val A2: ImageView = findViewById(R.id.A2)
        val A3: ImageView = findViewById(R.id.A3)
        val A4: ImageView = findViewById(R.id.A4)
        val A5: ImageView = findViewById(R.id.A5)
        val A6: ImageView = findViewById(R.id.A6)
        val A7: ImageView = findViewById(R.id.A7)
        val row1 = arrayOf(A1, A2, A3, A4, A5, A6, A7)


        val B1: ImageView  = findViewById(R.id.B1)
        val B2: ImageView = findViewById(R.id.B2)
        val B3: ImageView = findViewById(R.id.B3)
        val B4: ImageView  = findViewById(R.id.B4)
        val B5: ImageView  = findViewById(R.id.B5)
        val B6: ImageView  = findViewById(R.id.B6)
        val B7: ImageView  = findViewById(R.id.B7)

        var row2 = arrayOf(B1, B2, B3, B4, B5, B6, B7)

        val C1: ImageView = findViewById(R.id.C1)
        val C2: ImageView = findViewById(R.id.C2)
        val C3: ImageView = findViewById(R.id.C3)
        val C4: ImageView = findViewById(R.id.C4)
        val C5: ImageView = findViewById(R.id.C5)
        val C6: ImageView = findViewById(R.id.C6)
        val C7: ImageView = findViewById(R.id.C7)

        var row3 = arrayOf(C1, C2, C3, C4, C5, C6, C7)

        val D1: ImageView = findViewById(R.id.D1)
        val D2: ImageView = findViewById(R.id.D2)
        val D3: ImageView = findViewById(R.id.D3)
        val D4: ImageView = findViewById(R.id.D4)
        val D5: ImageView = findViewById(R.id.D5)
        val D6: ImageView = findViewById(R.id.D6)
        val D7: ImageView = findViewById(R.id.D7)

        var row4 = arrayOf(D1, D2, D3, D4, D5, D6, D7)

        val E1: ImageView = findViewById(R.id.E1)
        val E2: ImageView = findViewById(R.id.E2)
        val E3: ImageView = findViewById(R.id.E3)
        val E4: ImageView = findViewById(R.id.E4)
        val E5: ImageView = findViewById(R.id.E5)
        val E6: ImageView = findViewById(R.id.E6)
        val E7: ImageView = findViewById(R.id.E7)

        var row5 = arrayOf(E1, E2, E3, E4, E5, E6, E7)

        val F1: ImageView = findViewById(R.id.F1)
        val F2: ImageView = findViewById(R.id.F2)
        val F3: ImageView = findViewById(R.id.F3)
        val F4: ImageView = findViewById(R.id.F4)
        val F5: ImageView = findViewById(R.id.F5)
        val F6: ImageView = findViewById(R.id.F6)
        val F7: ImageView = findViewById(R.id.F7)

        var row6 = arrayOf(F1, F2, F3, F4, F5, F6, F7)

        //Fills up the pieces array
        pieces = arrayOf(row1, row2, row3, row4, row5, row6)

        gameModel.withAI = intent.getBooleanExtra(ID1, false)
        gameModel.playerColor = intent.getIntExtra(ID2, 1)
        //Red always starts the game
        gameModel.whoseTurn = RED
        yellowLabel.visibility = View.INVISIBLE
        if(gameModel.playerColor == YELLOW && gameModel.withAI)
        {
            val slot = aiChooseSlot()
            takeTurn(gameModel.whoseTurn, slot)
        }
        button1.setOnClickListener { view: View ->
            button1.isEnabled = false
           takeTurn(gameModel.whoseTurn, 1)

        }

        button2.setOnClickListener { view: View ->
            button2.isEnabled = false
            takeTurn(gameModel.whoseTurn, 2)

        }

        button3.setOnClickListener { view: View ->
            button3.isEnabled = false
            takeTurn(gameModel.whoseTurn, 3)

        }

        button4.setOnClickListener { view: View ->
            button4.isEnabled = false
            takeTurn(gameModel.whoseTurn, 4)

        }

        button5.setOnClickListener { view: View ->
            button5.isEnabled = false
            takeTurn(gameModel.whoseTurn, 5)

        }

        button6.setOnClickListener { view: View ->
            button6.isEnabled = false
            takeTurn(gameModel.whoseTurn, 6)

        }

        button7.setOnClickListener { view: View ->
            button7.isEnabled = false
            takeTurn(gameModel.whoseTurn, 7)

        }

        newGame.setOnClickListener { view: View ->
           resetGame()
        }

        saveReplay.setOnClickListener { view: View ->
            var gameReplay = Game()
            gameReplay.gameString = gameModel.moveList
            gameReplay.moveNumber = gameModel.moveList.length - 1
            gameReplay.winner = gameModel.winner


            //TODO("Save gameReplay here")
            replayDetailViewModel.saveGame(gameReplay)

        }

    }

    private fun takeTurn(color: Int, slot: Int)
    {

        placePiece(color, slot)

        if(fourInARow())
        {
           declareWinner(false)
        }
        else if(fullBoard())
        {
            declareWinner(true)
        }
        else
        {
            changeTurn()
            for(i in 0..6)
            {
                buttons[i].isEnabled = true
            }
        }
    }

    private fun fullBoard(): Boolean
    {
        for(i in 0..6)
        {
            if(gameModel.gameBoard[5][i] == 0)
            {
                return false
            }
        }
        return true
    }

    private fun resetGame()
    {
        redLabel.visibility = View.VISIBLE
        yellowLabel.visibility = View.INVISIBLE
        winLabel.visibility = View.INVISIBLE
        newGame.visibility = View.INVISIBLE
        saveReplay.visibility = View.INVISIBLE

        for(i in 0..6)
        {
            buttons[i].visibility = View.VISIBLE
            buttons[i].isEnabled = true
            buttons[i].setImageResource(R.drawable.redpiece)
        }


        gameModel.whoseTurn = RED
        gameModel.moveList = ""
        gameModel.playerColor = Random.nextInt(1..2)
        for(row in 0..5)
        {
            for(col in 0..6)
            {
                gameModel.gameBoard[row][col] = 0
                pieces[row][col].setImageResource(R.drawable.emptypiece)
            }
        }

        if(gameModel.playerColor == YELLOW && gameModel.withAI)
        {
            val slot = aiChooseSlot()
            takeTurn(gameModel.whoseTurn, slot)
        }
    }

    private fun fourInARow(): Boolean
    {
        var foundMatch = false
        var matchedMain: MutableList<ImageView> = ArrayList()
        for(row in 0..5)
        {
            for(col in 0..6)
            {
                if(gameModel.gameBoard[row][col] != 0)
                {
                    //Check Up
                    if(row <= 2)
                    {
                        var inARow = 0
                        var chainBroken = false
                        var matchedSub: MutableList<ImageView> = ArrayList()
                        for(i in row..5)
                        {
                            if(chainBroken == false)
                            {
                                if(gameModel.gameBoard[i][col] == gameModel.gameBoard[row][col])
                                {
                                    inARow += 1
                                    matchedSub.add(pieces[i][col])
                                }
                                else
                                {
                                    chainBroken = true
                                }
                            }
                        }

                        if(inARow >= 4)
                        {
                            foundMatch = true
                            for(element in matchedSub)
                            {
                                if(!matchedMain.contains(element))
                                {
                                    matchedMain.add(element)
                                }
                            }
                        }
                    }

                    //Check Right
                    if(col <= 3)
                    {
                        var inARow = 0
                        var chainBroken = false
                        var matchedSub: MutableList<ImageView> = ArrayList()
                        for(i in col..6)
                        {
                            if(chainBroken == false)
                            {
                                if(gameModel.gameBoard[row][i] == gameModel.gameBoard[row][col])
                                {
                                    inARow += 1
                                    matchedSub.add(pieces[row][i])
                                }
                                else
                                {
                                    chainBroken = true
                                }
                            }
                        }

                        if(inARow >= 4)
                        {
                            foundMatch = true
                            for(element in matchedSub)
                            {
                                if(!matchedMain.contains(element))
                                {
                                    matchedMain.add(element)
                                }
                            }
                        }
                    }

                    //Check Up Right
                    if(row <= 2 && col <= 3)
                    {
                        var distRight = 7 - col
                        var distUp = 6 - row
                        var maxDistance = 0


                        if(distRight >= distUp)
                        {
                            maxDistance = distUp
                        }
                        else
                        {
                            maxDistance = distRight
                        }

                        var inARow = 0
                        var chainBroken = false
                        var matchedSub: MutableList<ImageView> = ArrayList()

                        for(i in 0 until maxDistance)
                        {
                            if(chainBroken == false)
                            {
                                if(gameModel.gameBoard[row+i][col+i] == gameModel.gameBoard[row][col])
                                {
                                    inARow += 1
                                    matchedSub.add(pieces[row+i][col+i])
                                }
                                else
                                {
                                    chainBroken = true
                                }
                            }
                        }

                        if(inARow >= 4)
                        {
                            foundMatch = true
                            for(element in matchedSub)
                            {
                                if(!matchedMain.contains(element))
                                {
                                    matchedMain.add(element)
                                }
                            }
                        }

                    }

                    //Check Up Left
                    if(row <= 2 && col >= 3)
                    {
                        var distLeft = col + 1
                        var distUp = 6 - row
                        var maxDistance = 0


                        if(distLeft >= distUp)
                        {
                            maxDistance = distUp
                        }
                        else
                        {
                            maxDistance = distLeft
                        }

                        var inARow = 0
                        var chainBroken = false
                        var matchedSub: MutableList<ImageView> = ArrayList()

                        for(i in 0 until maxDistance)
                        {
                            if(chainBroken == false)
                            {
                                if(gameModel.gameBoard[row+i][col-i] == gameModel.gameBoard[row][col])
                                {
                                    inARow += 1
                                    matchedSub.add(pieces[row+i][col-i])
                                }
                                else
                                {
                                    chainBroken = true
                                }
                            }
                        }

                        if(inARow >= 4)
                        {
                            foundMatch = true
                            for(element in matchedSub)
                            {
                                if(!matchedMain.contains(element))
                                {
                                    matchedMain.add(element)
                                }
                            }
                        }

                    }
                }



                //Check Up Right

                //Check Up Left
            }
        }
        //Highlights the winning pieces
        if(foundMatch)
        {
            for(i in 0..5)
            {
                for(j in 0..6)
                {
                    pieces[i][j].setImageResource(R.drawable.emptypiece)
                }
            }
            for(element in matchedMain)
            {
                if(gameModel.whoseTurn == RED)
                {
                    element.setImageResource(R.drawable.redpiece)
                }
                else if(gameModel.whoseTurn == YELLOW)
                {
                    element.setImageResource(R.drawable.yellowpiece)
                }
            }
        }
        return foundMatch
    }


    private fun declareWinner(tie: Boolean)
    {

        redLabel.visibility = View.INVISIBLE
        yellowLabel.visibility = View.INVISIBLE
        winLabel.visibility = View.VISIBLE
        newGame.visibility = View.VISIBLE
        saveReplay.visibility = View.VISIBLE

        gameModel.moveList = gameModel.moveList + "0"
        for(i in 0..6)
        {
            buttons[i].visibility = View.INVISIBLE
        }

        if(!tie)
        {
            if(gameModel.whoseTurn == RED)
            {
                winLabel.text = getString(R.string.red_wins)
                gameModel.winner = "Red"
            }
            else if(gameModel.whoseTurn == YELLOW)
            {
                winLabel.text = getString(R.string.yellow_wins)
                gameModel.winner = "Yellow"
            }
        }
        else
        {
            winLabel.text = getString(R.string.tied_game)
            gameModel.winner = "Tie"
        }

    }


    private fun changeTurn()
    {

        if(gameModel.whoseTurn == RED)
        {
            gameModel.whoseTurn = YELLOW
            redLabel.visibility = View.INVISIBLE
            yellowLabel.visibility = View.VISIBLE
            for(i in 0..6)
            {
                buttons[i].setImageResource(R.drawable.yellowpiece)
            }

        }
        else if(gameModel.whoseTurn == YELLOW)
        {
            gameModel.whoseTurn = RED
            redLabel.visibility = View.VISIBLE
            yellowLabel.visibility = View.INVISIBLE

            for(i in 0..6)
            {
                buttons[i].setImageResource(R.drawable.redpiece)
            }
        }

        for(i in 0..6)
        {
            if(gameModel.gameBoard[5][i] != 0)
            {
                buttons[i].visibility = View.INVISIBLE
            }
        }


        if(gameModel.withAI && gameModel.whoseTurn != gameModel.playerColor)
        {

            var slot = aiChooseSlot()
            takeTurn(gameModel.whoseTurn, slot)
        }

    }

    private fun aiChooseSlot(): Int
    {
        var availableSlots: MutableList<Int> = ArrayList()

        for(i in 0..6)
        {
            if(buttons[i].visibility == View.VISIBLE)
            {
                availableSlots.add(i+1)
            }
        }
        val x = availableSlots.size - 1
        return availableSlots[Random.nextInt(0..x)]
    }

    private fun placePiece(color: Int, slot: Int)
    {
        var row = -1
        gameModel.moveList = gameModel.moveList + slot.toString()
        for(x in 5 downTo(0))
        {
            if(gameModel.gameBoard[x][slot-1] == 0)
            {
                row = x
            }
        }
        if(row == -1)
        {
            Log.d("Errors", "No empty spaces in column ")
        }
        else
        {
            gameModel.gameBoard[row][slot-1] = color
            anim(color, row, slot-1)
        }
    }

    private fun removePiece(slot: Int)
    {
        var row = -1

        //currentTurn -= 1


        for(x in 5 downTo(0))
        {
            if(gameModel.gameBoard[x][slot-1] != 0)
            {
                if(row == -1)
                {
                    row = x
                }

            }
        }
        if(row == -1)
        {
            Log.d("Errors", "No piece in column to remove")
        }
        else
        {
            gameModel.gameBoard[row][slot-1] = 0
            pieces[row][slot-1].setImageResource(R.drawable.emptypiece)
        }
    }

    //Updates the image views to place the piece on the board
    //If we have time, we can add more complex "animation"
    private fun anim(color: Int, row: Int, col: Int)
    {
        if(color == RED)
        {
            pieces[row][col].setImageResource(R.drawable.redpiece)
        }
        else if(color == YELLOW)
        {
            pieces[row][col].setImageResource(R.drawable.yellowpiece)
        }

    }
    companion object {
        fun newIntent(packageContext: Context, withAI: Boolean, playerColor: Int): Intent {
            return Intent(packageContext, GameActivity::class.java).apply {
                putExtra(ID1, withAI)
                putExtra(ID2, playerColor)
            }
        }
    }

}