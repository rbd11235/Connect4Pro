package com.example.connect4pro

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.Observer
import java.util.*

private const val TAG = "ReplayFragment"
private const val ARG_GAME_ID = "game_id"

class ReplayFragment : Fragment(){

    private lateinit var game: Game
    //Temp Text Variable:
    private lateinit var replayRedLabel: TextView
    private val replayDetailViewModel: ReplayDetailViewModel by lazy {
        ViewModelProviders.of(this).get(ReplayDetailViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        game = Game()
        val gameId: UUID = arguments?.getSerializable(ARG_GAME_ID) as UUID
        Log.d(TAG, "args bundle game ID: $gameId")
        // Eventually, load game from database
        replayDetailViewModel.loadGame(gameId)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        replayDetailViewModel.gameLiveData.observe(
            viewLifecycleOwner,
            Observer { game ->
                game?.let {
                    this.game = game
                    updateUI()
                }
            })
    }

    private fun updateUI() {
        replayRedLabel.setText(game.gameString)
    }

    companion object {
        fun newInstance(gameId: UUID): ReplayFragment {
            val args = Bundle().apply {
                putSerializable(ARG_GAME_ID, gameId)
            }
            return ReplayFragment().apply {
                arguments = args
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_replay, container, false)

        replayRedLabel = view.findViewById(R.id.replayRedLabel) as TextView

        return view
    }
}