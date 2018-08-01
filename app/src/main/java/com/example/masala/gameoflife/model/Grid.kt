package com.example.masala.gameoflife.model

data class Grid(val width: Int = 0,
                val height: Int = 0,
                var cells: MutableMap<String, Cell> = mutableMapOf<String, Cell>()) {

    fun copyCells(): MutableMap<String, Cell> {
        var cellsCopy: MutableMap<String, Cell> = mutableMapOf<String, Cell>()
        cells.forEach({
            cellsCopy.put(it.key, it.value.copy())
        })
        return cellsCopy
    }


}