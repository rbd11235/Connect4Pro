package com.example.connect4pro

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders

private const val ID1 =
    "private.withAI"
private const val ID2 =
    "private.playerColor"


private const val RED = 1
private const val YELLOW = 2
class GameActivity : AppCompatActivity() {
    private lateinit var redLabel: TextView
    private lateinit var yellowLabel: TextView

    //Two dimensional array containing all the ImageViews that make up the board
    private lateinit var pieces: Array<Array<ImageView>>

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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        redLabel = findViewById(R.id.redLabel)
        yellowLabel = findViewById(R.id.yellowLabel)

        button1 = findViewById(R.id.drop1)
        button2 = findViewById(R.id.drop2)
        button3 = findViewById(R.id.drop3)
        button4 = findViewById(R.id.drop4)
        button5 = findViewById(R.id.drop5)
        button6 = findViewById(R.id.drop6)
        button7 = findViewById(R.id.drop7)


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
        button1.setOnClickListener { view: View ->
           takeTurn(gameModel.whoseTurn, 1)

        }

        button2.setOnClickListener { view: View ->
            takeTurn(gameModel.whoseTurn, 2)

        }

        button3.setOnClickListener { view: View ->
            takeTurn(gameModel.whoseTurn, 3)

        }

        button4.setOnClickListener { view: View ->
            takeTurn(gameModel.whoseTurn, 4)

        }

        button5.setOnClickListener { view: View ->
            takeTurn(gameModel.whoseTurn, 5)

        }

        button6.setOnClickListener { view: View ->
            takeTurn(gameModel.whoseTurn, 6)

        }

        button7.setOnClickListener { view: View ->
            takeTurn(gameModel.whoseTurn, 7)

        }
    }

    private fun takeTurn(color: Int, slot: Int)
    {

        placePiece(color, slot)

        //Check if game over

            //End game setup

        //
    }

    private fun placePiece(color: Int, slot: Int)
    {
        var row = -1

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

    //Updates the image views to place the piece on the board
    //If we have time, we can add more complex "animation"
    private fun anim(color: Int, row: Int, col: Int)
    {
        if(color == 1)
        {
            pieces[row][col].setImageResource(R.drawable.redpiece)
        }
        else if(color == 2)
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