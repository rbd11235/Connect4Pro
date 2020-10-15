package com.example.connect4pro

import androidx.lifecycle.LiveData
import org.hamcrest.CoreMatchers.`is`
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import java.util.*

class ReplayDetailViewModelTest {

    private lateinit var gameId: UUID
    //private lateinit var replayDetailViewModel: ReplayDetailViewModel

    @Before
    fun setUp() {
        gameId = UUID.fromString("9ac44abe-b086-493e-82bf-d8135a945fda")
        //replayDetailViewModel = ReplayDetailViewModel()
    }

    @Test
    fun loadsGameAsUUID() {
        //replayDetailViewModel.loadGame(gameId)
        assertThat("9ac44abe-b086-493e-82bf-d8135a945fda", `is`(gameId.toString()))
    }
}