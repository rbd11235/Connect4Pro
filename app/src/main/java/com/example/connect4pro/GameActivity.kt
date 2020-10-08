package com.example.connect4pro

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
private const val ID1 =
    "private.name1"
private const val ID2 =
    "private.name2"

private const val ID3 =
    "private.name3"
private const val ID4 =
    "private.name4"
class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
    }

    companion object {
        fun newIntent(packageContext: Context, withAI: Boolean, playerColor: String): Intent {
            return Intent(packageContext, GameActivity::class.java).apply {
                putExtra(ID1, withAI)
                putExtra(ID2, playerColor)
            }
        }
    }

}