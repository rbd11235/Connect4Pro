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

private const val ID3 =
    "private.replayString"
private const val ID4 =
    "private.winner"


private const val RED = 1
private const val YELLOW = 2
class ReplayActivity : AppCompatActivity() {
    private lateinit var redLabel: TextView
    private lateinit var yellowLabel: TextView
    private lateinit var winLabel: TextView

    private lateinit var turnText: TextView

    private lateinit var nextButton: ImageButton
    private lateinit var prevButton: ImageButton

    //Two dimensional array containing all the ImageViews that make up the board
    private lateinit var pieces: Array<Array<ImageView>>
    private lateinit var drops: Array<ImageView>





    private val replayModel: ReplayModel by lazy {
        ViewModelProviders.of(this).get(ReplayModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_replay)
        redLabel = findViewById(R.id.redLabel)
        yellowLabel = findViewById(R.id.yellowLabel)
        winLabel = findViewById(R.id.win_label)

        turnText = findViewById(R.id.turnText)
        nextButton = findViewById(R.id.next)
        prevButton = findViewById(R.id.previous)

        var drop1: ImageView = findViewById(R.id.drop1)
        var drop2: ImageView = findViewById(R.id.drop2)
        var drop3: ImageView = findViewById(R.id.drop3)
        var drop4: ImageView = findViewById(R.id.drop4)
        var drop5: ImageView = findViewById(R.id.drop5)
        var drop6: ImageView = findViewById(R.id.drop6)
        var drop7: ImageView = findViewById(R.id.drop7)
        drops = arrayOf(drop1, drop2, drop3, drop4, drop5, drop6, drop7)




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


        //Red always starts the game
        replayModel.currentTurn = 0
        replayModel.whoseTurn = RED
        replayModel.moveList = intent.getStringExtra(ID3).toString()
        replayModel.winner = intent.getStringExtra(ID4).toString()
        yellowLabel.visibility = View.INVISIBLE
        prevButton.visibility = View.INVISIBLE
        prevButton.isEnabled = false
        for(i in 0..6)
        {
            drops[i].visibility = View.INVISIBLE
        }
        drops[replayModel.currentTurn].visibility = View.VISIBLE
        drops[replayModel.currentTurn].setImageResource(R.drawable.redpiece)

        nextButton.setOnClickListener { view: View ->


            placePiece(replayModel.whoseTurn, Character.getNumericValue(replayModel.moveList[replayModel.currentTurn]))
            changeTurn()


            val nextMove = Character.getNumericValue(replayModel.moveList[replayModel.currentTurn + 1])
            if(nextMove != 0)
            {
                for(i in 0..6)
                {
                    drops[i].visibility = View.INVISIBLE
                }
                drops[nextMove - 1].visibility = View.VISIBLE
                if(replayModel.whoseTurn == RED)
                {
                    drops[nextMove - 1].setImageResource(R.drawable.redpiece)
                }
                else if(replayModel.whoseTurn == YELLOW)
                {
                    drops[nextMove - 1].setImageResource(R.drawable.yellowpiece)
                }
            }
            else
            {
                declareWinner(replayModel.winner)
                nextButton.visibility = View.INVISIBLE
            }

            replayModel.currentTurn += 1
            prevButton.visibility = View.VISIBLE
            prevButton.isEnabled = true
            if(replayModel.currentTurn < 9)
            {
                turnText.text = "Turn: 0" + (replayModel.currentTurn + 1).toString()
            }
            else
            {
                turnText.text = "Turn: " + (replayModel.currentTurn + 1).toString()
            }
        }

        prevButton.setOnClickListener { view: View ->
            winLabel.visibility = View.INVISIBLE
            removePiece(Character.getNumericValue(replayModel.moveList[replayModel.currentTurn - 1]))
            changeTurn()

            replayModel.currentTurn -= 1
            for(i in 0..6)
            {
                drops[i].visibility = View.INVISIBLE
            }
            drops[Character.getNumericValue(replayModel.moveList[replayModel.currentTurn]) - 1].visibility = View.VISIBLE
            if(replayModel.whoseTurn == RED)
            {
                drops[Character.getNumericValue(replayModel.moveList[replayModel.currentTurn]) - 1].setImageResource(R.drawable.redpiece)
            }
            else if(replayModel.whoseTurn == YELLOW)
            {
                drops[Character.getNumericValue(replayModel.moveList[replayModel.currentTurn]) - 1].setImageResource(R.drawable.yellowpiece)
            }


            if(replayModel.currentTurn == 0)
            {
                prevButton.visibility = View.INVISIBLE
                prevButton.isEnabled = false
            }

            nextButton.visibility = View.VISIBLE
            nextButton.isEnabled = true

            if(replayModel.currentTurn < 9)
            {
                turnText.text = "Turn: 0" + (replayModel.currentTurn + 1).toString()
            }
            else
            {
                turnText.text = "Turn: " + (replayModel.currentTurn + 1).toString()
            }
        }
    }




    private fun declareWinner(winner: String)
    {

        redLabel.visibility = View.INVISIBLE
        yellowLabel.visibility = View.INVISIBLE
        winLabel.visibility = View.VISIBLE

        for(i in 0..6)
        {
            drops[i].visibility = View.INVISIBLE
        }

        if(winner == "Red")
        {
            winLabel.text = getString(R.string.red_wins)
        }
        else if(winner == "Yellow")
        {
            winLabel.text = getString(R.string.yellow_wins)
        }
        else
        {
            winLabel.text = getString(R.string.tied_game)
        }

    }


    private fun changeTurn()
    {

        if(replayModel.whoseTurn == RED)
        {
            replayModel.whoseTurn = YELLOW
            redLabel.visibility = View.INVISIBLE
            yellowLabel.visibility = View.VISIBLE


        }
        else if(replayModel.whoseTurn == YELLOW)
        {
            replayModel.whoseTurn = RED
            redLabel.visibility = View.VISIBLE
            yellowLabel.visibility = View.INVISIBLE

        }

    }


    private fun placePiece(color: Int, slot: Int)
    {
        var row = -1
        for(x in 5 downTo(0))
        {
            if(replayModel.gameBoard[x][slot-1] == 0)
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
            replayModel.gameBoard[row][slot-1] = color
            anim(color, row, slot-1)
        }
    }

    private fun removePiece(slot: Int)
    {
        var row = -1

        for(x in 5 downTo(0))
        {
            if(replayModel.gameBoard[x][slot-1] != 0)
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
            replayModel.gameBoard[row][slot-1] = 0
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
        fun newIntent(packageContext: Context, replayString: String, winner: String): Intent {
            return Intent(packageContext, ReplayActivity::class.java).apply {
                putExtra(ID3, replayString)
                putExtra(ID4, winner)
            }
        }
    }

}