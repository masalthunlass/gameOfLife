package com.example.masala.gameoflife

import com.example.masala.gameoflife.DataFactory.Companion.aGridWithAliveCells
import com.example.masala.gameoflife.domain.GridInteractor
import com.example.masala.gameoflife.model.enums.LifeState
import org.hamcrest.core.Is.`is`
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Assert.assertThat
import org.junit.Test

class GridNextGenUseCasesTest {

    private val gridUseCases by lazy { GridInteractor() }

    @Test
    fun should_alive_cell_with_less_than_2_alive_neighbours_die() {
        //given
        val firstGeneration = aGridWithAliveCells()
        assertThat(firstGeneration.cells["33"]?.state, `is`(equalTo(LifeState.ALIVE)))

        //when
        val nextGeneration = gridUseCases.runNextGeneration(firstGeneration)

        //then
        assertThat(nextGeneration.height, `is`(equalTo(firstGeneration.height)))
        assertThat(nextGeneration.width, `is`(equalTo(firstGeneration.width)))
        assertThat(nextGeneration.cells["33"]?.state, `is`(equalTo(LifeState.DEAD)))

    }

    @Test
    fun should_alive_cell_with_more_than_3_alive_neighbours_die() {
        //given
        val firstGeneration = aGridWithAliveCells()
        assertThat(firstGeneration.cells["22"]?.state, `is`(equalTo(LifeState.ALIVE)))

        //when
        val nextGeneration = gridUseCases.runNextGeneration(firstGeneration)

        //then
        assertThat(nextGeneration.height, `is`(equalTo(firstGeneration.height)))
        assertThat(nextGeneration.width, `is`(equalTo(firstGeneration.width)))
        assertThat(nextGeneration.cells["22"]?.state, `is`(equalTo(LifeState.DEAD)))
    }

    @Test
    fun should_alive_cell_with_2_alive_neighbours_stay_alive() {
        //given
        val firstGeneration = aGridWithAliveCells()
        assertThat(firstGeneration.cells["31"]?.state, `is`(equalTo(LifeState.ALIVE)))

        //when
        val nextGeneration = gridUseCases.runNextGeneration(firstGeneration)

        //then
        assertThat(nextGeneration.height, `is`(equalTo(firstGeneration.height)))
        assertThat(nextGeneration.width, `is`(equalTo(firstGeneration.width)))
        assertThat(nextGeneration.cells["31"]?.state, `is`(equalTo(LifeState.ALIVE)))

    }

    @Test
    fun should_alive_cell_with_3_alive_neighbours_stay_alive() {

        //given
        val firstGeneration = aGridWithAliveCells()
        assertThat(firstGeneration.cells["11"]?.state, `is`(equalTo(LifeState.ALIVE)))

        //when
        val nextGeneration = gridUseCases.runNextGeneration(firstGeneration)

        //then
        assertThat(nextGeneration.height, `is`(equalTo(firstGeneration.height)))
        assertThat(nextGeneration.width, `is`(equalTo(firstGeneration.width)))
        assertThat(nextGeneration.cells["11"]?.state, `is`(equalTo(LifeState.ALIVE)))
    }

    @Test
    fun should_dead_cell_with_3_alive_neighbours_relives() {
        //given
        val firstGeneration = aGridWithAliveCells()
        assertThat(firstGeneration.cells["23"]?.state, `is`(equalTo(LifeState.DEAD)))

        //when
        val nextGeneration = gridUseCases.runNextGeneration(firstGeneration)

        //then
        assertThat(nextGeneration.height, `is`(equalTo(firstGeneration.height)))
        assertThat(nextGeneration.width, `is`(equalTo(firstGeneration.width)))
        assertThat(nextGeneration.cells["23"]?.state, `is`(equalTo(LifeState.ALIVE)))
    }
}