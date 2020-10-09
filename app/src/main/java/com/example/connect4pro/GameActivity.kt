package com.example.connect4pro

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

    private lateinit var A1: ImageView
    private lateinit var A2: ImageView
    private lateinit var A3: ImageView
    private lateinit var A4: ImageView
    private lateinit var A5: ImageView
    private lateinit var A6: ImageView
    private lateinit var A7: ImageView

    private lateinit var B1: ImageView
    private lateinit var B2: ImageView
    private lateinit var B3: ImageView
    private lateinit var B4: ImageView
    private lateinit var B5: ImageView
    private lateinit var B6: ImageView
    private lateinit var B7: ImageView

    private lateinit var C1: ImageView
    private lateinit var C2: ImageView
    private lateinit var C3: ImageView
    private lateinit var C4: ImageView
    private lateinit var C5: ImageView
    private lateinit var C6: ImageView
    private lateinit var C7: ImageView

    private lateinit var D1: ImageView
    private lateinit var D2: ImageView
    private lateinit var D3: ImageView
    private lateinit var D4: ImageView
    private lateinit var D5: ImageView
    private lateinit var D6: ImageView
    private lateinit var D7: ImageView

    private lateinit var E1: ImageView
    private lateinit var E2: ImageView
    private lateinit var E3: ImageView
    private lateinit var E4: ImageView
    private lateinit var E5: ImageView
    private lateinit var E6: ImageView
    private lateinit var E7: ImageView

    private lateinit var F1: ImageView
    private lateinit var F2: ImageView
    private lateinit var F3: ImageView
    private lateinit var F4: ImageView
    private lateinit var F5: ImageView
    private lateinit var F6: ImageView
    private lateinit var F7: ImageView

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

        A1 = findViewById(R.id.A1)
        A2 = findViewById(R.id.A2)
        A3 = findViewById(R.id.A3)
        A4 = findViewById(R.id.A4)
        A5 = findViewById(R.id.A5)
        A6 = findViewById(R.id.A6)
        A7 = findViewById(R.id.A7)

        B1 = findViewById(R.id.B1)
        B2 = findViewById(R.id.B2)
        B3 = findViewById(R.id.B3)
        B4 = findViewById(R.id.B4)
        B5 = findViewById(R.id.B5)
        B6 = findViewById(R.id.B6)
        B7 = findViewById(R.id.B7)

        C1 = findViewById(R.id.C1)
        C2 = findViewById(R.id.C2)
        C3 = findViewById(R.id.C3)
        C4 = findViewById(R.id.C4)
        C5 = findViewById(R.id.C5)
        C6 = findViewById(R.id.C6)
        C7 = findViewById(R.id.C7)

        D1 = findViewById(R.id.D1)
        D2 = findViewById(R.id.D2)
        D3 = findViewById(R.id.D3)
        D4 = findViewById(R.id.D4)
        D5 = findViewById(R.id.D5)
        D6 = findViewById(R.id.D6)
        D7 = findViewById(R.id.D7)

        E1 = findViewById(R.id.E1)
        E2 = findViewById(R.id.E2)
        E3 = findViewById(R.id.E3)
        E4 = findViewById(R.id.E4)
        E5 = findViewById(R.id.E5)
        E6 = findViewById(R.id.E6)
        E7 = findViewById(R.id.E7)

        F1 = findViewById(R.id.F1)
        F2 = findViewById(R.id.F2)
        F3 = findViewById(R.id.F3)
        F4 = findViewById(R.id.F4)
        F5 = findViewById(R.id.F5)
        F6 = findViewById(R.id.F6)
        F7 = findViewById(R.id.F7)

        gameModel.withAI = intent.getBooleanExtra(ID1, false)
        gameModel.playerColor = intent.getIntExtra(ID2, 1)
        //Red always starts the game
        gameModel.whoseTurn = RED
        button1.setOnClickListener { view: View ->


        }

        button2.setOnClickListener { view: View ->


        }

        button3.setOnClickListener { view: View ->


        }

        button4.setOnClickListener { view: View ->


        }

        button5.setOnClickListener { view: View ->


        }

        button6.setOnClickListener { view: View ->


        }

        button7.setOnClickListener { view: View ->


        }
    }

    private fun takeTurn(color: Int, slot: Int)
    {

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