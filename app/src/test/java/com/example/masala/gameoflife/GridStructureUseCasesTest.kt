package com.example.masala.gameoflife;

import com.example.masala.gameoflife.DataFactory.Companion.aBrandNewGridForTest
import com.example.masala.gameoflife.DataFactory.Companion.aGridWithAliveCells
import com.example.masala.gameoflife.domain.GridInteractor
import com.example.masala.gameoflife.model.Cell
import com.example.masala.gameoflife.model.Grid
import org.hamcrest.core.Is.`is`
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Assert.assertThat
import org.junit.Test

public class GridStructureUseCasesTest {

    private val gridUseCases by lazy { GridInteractor() }

    @Test
    fun should_return_grid_dimensions_and_structure_correct_when_initializing() {
        //given
        val width = 5
        val height = 3

        //when
        val grid = gridUseCases.createGrid(width, height);

        //then
        val expectedKeys: Array<String> = arrayOf("11", "12", "13", "14", "15", "21", "22", "23", "24", "25", "31", "32", "33", "34", "35")
        assertThat(grid.height, `is`(equalTo(height)))
        assertThat(grid.width, `is`(equalTo(width)))
        assertThat(grid.cells.size, `is`(equalTo(width * height)))
        assertThat(grid.cells.keys.toTypedArray(), `is`(expectedKeys))
    }

    @Test(expected = IllegalArgumentException::class)
    fun should_throw_exception_when_grid_width_is_negative() {
        //given
        val width = -5
        val height = 3

        //when
        gridUseCases.createGrid(width, height);

    }


    @Test(expected = IllegalArgumentException::class)
    fun should_throw_exception_when_grid_height_is_negative() {
        //given
        val width = 5
        val height = -3

        //when
        gridUseCases.createGrid(width, height);
    }


    @Test
    fun should_return_neighbours_when_cell_is_in_the_middle_of_the_grid() {
        //given
        val grid = aBrandNewGridForTest()
        val cellCoordinates = "22"

        //when
        val neighbours = gridUseCases.getNeighbours(grid, cellCoordinates)

        //then
        val expectedNeighbours: Set<Cell> = setOf(Cell("21"), Cell("12"), Cell("23"), Cell("32"),
                Cell("11"), Cell("13"), Cell("31"), Cell("33"))
        assertThat(neighbours, `is`(expectedNeighbours))

    }

    @Test
    fun should_return_neighbours_when_cell_is_in_the_top_line_of_the_grid() {
        //given
        val grid = aBrandNewGridForTest()
        val cellCoordinates = "12"

        //when
        val neighbours = gridUseCases.getNeighbours(grid, cellCoordinates)

        //then
        val expectedNeighbours: Set<Cell> = setOf(Cell("11"), Cell("13"), Cell("23"), Cell("22"), Cell("21"))
        assertThat(neighbours, `is`(expectedNeighbours))

    }

    @Test
    fun should_return_neighbours_when_cell_is_in_the_bottom_line_of_the_grid() {
        //given
        val grid = aBrandNewGridForTest()
        val cellCoordinates = "32"

        //when
        val neighbours = gridUseCases.getNeighbours(grid, cellCoordinates)

        //then
        val expectedNeighbours: Set<Cell> = setOf(Cell("31"), Cell("33"), Cell("23"), Cell("22"), Cell("21"))
        assertThat(neighbours, `is`(expectedNeighbours))

    }

    @Test
    fun should_return_neighbours_when_cell_is_in_the_lefter_line_of_the_grid() {
        //given
        val grid = aBrandNewGridForTest()
        val cellCoordinates = "21"

        //when
        val neighbours = gridUseCases.getNeighbours(grid, cellCoordinates)

        //then
        val expectedNeighbours: Set<Cell> = setOf(Cell("11"), Cell("31"), Cell("12"), Cell("22"), Cell("32"))
        assertThat(neighbours, `is`(expectedNeighbours))

    }

    @Test
    fun should_return_neighbours_when_cell_is_in_the_righter_line_of_the_grid() {
        //given
        val grid = aBrandNewGridForTest()
        val cellCoordinates = "23"

        //when
        val neighbours = gridUseCases.getNeighbours(grid, cellCoordinates)

        //then
        val expectedNeighbours: Set<Cell> = setOf(Cell("13"), Cell("33"), Cell("12"), Cell("22"), Cell("32"))
        assertThat(neighbours, `is`(expectedNeighbours))

    }

    @Test
    fun should_return_neighbours_when_cell_is_in_a_corner_of_the_grid() {
        //given
        val grid = aBrandNewGridForTest()
        val cellCoordinates = "11"

        //when
        val neighbours = gridUseCases.getNeighbours(grid, cellCoordinates)

        //then
        val expectedNeighbours: Set<Cell> = setOf(Cell("12"), Cell("22"), Cell("21"))
        assertThat(neighbours, `is`(expectedNeighbours))

    }


    @Test(expected = IllegalArgumentException::class)
    fun should_return_exception_when_grid_is_empty() {
        //given
        val grid = Grid()
        val cellCoordinates = "11"

        //when
        gridUseCases.getNeighbours(grid, cellCoordinates)
    }

    @Test(expected = IllegalArgumentException::class)
    fun should_return_exception_when_cell_coordinates_is_over_limits() {
        //given
        val grid = aBrandNewGridForTest()
        val cellCoordinates = "56"

        //when
        gridUseCases.getNeighbours(grid, cellCoordinates)
    }

    @Test
    fun should_return_the_number_of_alive_cells_of_a_cell_when_cell_is_correct() {
        //given
        val grid = aGridWithAliveCells()
        val cellCoordinates = "32"

        //when
        val aliveNeighboursNumber = gridUseCases.getAliveNeighboursNumber(grid, cellCoordinates)

        //then
        assertThat(aliveNeighboursNumber,`is`(4))
    }

}
