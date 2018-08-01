package com.example.masala.gameoflife.domain

import com.example.masala.gameoflife.model.Cell
import com.example.masala.gameoflife.model.Grid

interface GridUseCases {

    fun runNextGeneration(grid: Grid): Grid;

    fun createGrid(width: Int, height: Int): Grid;
    fun getNeighbours(grid: Grid, cellCoordinates: String): Set<Cell>;
    fun getAliveNeighboursNumber(grid: Grid, cellCoordinates: String): Int;

}