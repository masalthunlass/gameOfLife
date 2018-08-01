package com.example.masala.gameoflife.model

import com.example.masala.gameoflife.model.enums.LifeState

data class Cell(val id: String, var state: LifeState = LifeState.DEAD) {

}