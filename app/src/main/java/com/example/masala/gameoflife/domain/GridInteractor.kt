package com.example.masala.gameoflife.domain

import com.example.masala.gameoflife.model.Cell
import com.example.masala.gameoflife.model.Grid
import com.example.masala.gameoflife.model.enums.LifeState
import java.lang.IllegalArgumentException

class GridInteractor : GridUseCases {

    override fun runNextGeneration(grid: Grid): Grid {
        var nextGen = grid.copyCells()
        nextGen.forEach({
            val aliveNeighboursNumber = getAliveNeighboursNumber(grid, it.key)
            if (it.value.state == LifeState.ALIVE && aliveNeighboursNumber !in 2..3) {
                it.value.state = LifeState.DEAD
            } else if (aliveNeighboursNumber == 3) {
                it.value.state = LifeState.ALIVE
            }
        })
        grid.cells = nextGen
        return grid
    }


    override fun createGrid(width: Int, height: Int): Grid {
        if (width < 0 || height < 0) throw IllegalArgumentException()
        val grid = Grid(width, height)
        for (wi in 1..height) {
            for (hi in 1..width) {
                grid.cells.put("$wi$hi", Cell("$wi$hi"))
            }
        }

        return grid
    }

    override fun getAliveNeighboursNumber(grid: Grid, cellCoordinates: String): Int {
        return getNeighbours(grid, cellCoordinates)
                .filter { cell -> cell.state.equals(LifeState.ALIVE) }
                .size
    }

    override fun getNeighbours(grid: Grid, cellCoordinates: String): Set<Cell> {
        if (grid.cells.isEmpty()) throw IllegalArgumentException()
        val maxIndex = (grid.width * 10) + grid.height
        if (cellCoordinates.toInt() !in 0..maxIndex) throw IllegalArgumentException()

        val west = cellCoordinates.toInt().minus(1)
        val east = cellCoordinates.toInt().plus(1)
        val north = cellCoordinates.toInt().minus(10)
        val south = cellCoordinates.toInt().plus(10)
        val northEast = north.plus(1)
        val northWest = north.minus(1)
        val southWest = south.minus(1)
        val southEast = south.plus(1)

        return grid.cells.filterKeys { k ->
            (k.equals(west.toString()))
                    || (k.equals(east.toString()))
                    || (k.equals(north.toString()))
                    || (k.equals(south.toString()))
                    || (k.equals(southEast.toString()))
                    || (k.equals(southWest.toString()))
                    || (k.equals(northEast.toString()))
                    || (k.equals(northWest.toString()))
        }
                .values
                .toSet()
    }


}