package com.example.masala.gameoflife.presentation

import android.arch.lifecycle.ViewModel
import com.example.masala.gameoflife.domain.GridInteractor
import com.example.masala.gameoflife.model.Grid
import java.lang.Integer.min

class GridViewModel(private val widthMax: Int, private val heightMax: Int) : ViewModel() {

   private val gridInteractor: GridInteractor = GridInteractor();

   var cellSize = 0;

    fun createGrid(widthCells: Int, heightCells: Int): Grid {
        this.cellSize = min(widthMax / widthCells, heightMax / heightCells)
        return gridInteractor.createGrid(widthCells, heightCells);
    }
}