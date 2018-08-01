package com.example.masala.gameoflife

import com.example.masala.gameoflife.model.Cell
import com.example.masala.gameoflife.model.Grid
import com.example.masala.gameoflife.model.enums.LifeState

class DataFactory {

    companion object {
        fun aBrandNewGridForTest(): Grid {
            val grid = Grid(3, 3)
            grid.cells.putAll(
                    mapOf(
                            Pair("11", Cell("11")),
                            Pair("12", Cell("12")),
                            Pair("13", Cell("13")),
                            Pair("21", Cell("21")),
                            Pair("22", Cell("22")),
                            Pair("23", Cell("23")),
                            Pair("31", Cell("31")),
                            Pair("32", Cell("32")),
                            Pair("33", Cell("33"))
                    )
            )
            return grid;
        }

        fun aGridWithAliveCells(): Grid {
            val grid = Grid(3, 3)
            grid.cells.putAll(
                    mapOf(
                            Pair("11", Cell("11", LifeState.ALIVE)),
                            Pair("12", Cell("12")),
                            Pair("13", Cell("13", LifeState.ALIVE)),
                            Pair("21", Cell("21", LifeState.ALIVE)),
                            Pair("22", Cell("22", LifeState.ALIVE)),
                            Pair("23", Cell("23")),
                            Pair("31", Cell("31",LifeState.ALIVE)),
                            Pair("32", Cell("32")),
                            Pair("33", Cell("33", LifeState.ALIVE))
                    )
            )
            return grid;
        }
    }
}