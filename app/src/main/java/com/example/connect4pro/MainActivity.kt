package com.example.connect4pro

import android.content.ClipData.newIntent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
private const val RED = 1
private const val YELLOW = 2
class MainActivity : AppCompatActivity() {

    private lateinit var one_player: Button
    private lateinit var two_player: Button
    private lateinit var replays: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        one_player = findViewById(R.id.one_player)
        two_player = findViewById(R.id.two_player)

        one_player.setOnClickListener { view: View ->

            val intent = GameActivity.newIntent(this@MainActivity, true, RED)
            startActivity(intent)
        }

        two_player.setOnClickListener { view: View ->

            val intent = GameActivity.newIntent(this@MainActivity, false, RED)
            startActivityForResult(intent, 0)
        }
    }
}