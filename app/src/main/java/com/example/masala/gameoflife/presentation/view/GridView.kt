package com.example.masala.gameoflife.presentation.view

import android.content.Context
import android.view.ViewGroup.LayoutParams
import android.widget.GridLayout

class GridView(context: Context, private val columnNb: Int, private val rowNb: Int) : GridLayout(context) {


    init {
        columnCount = columnNb
        rowCount = rowNb
        layoutParams = LayoutParams(GridLayout.LayoutParams.MATCH_PARENT, GridLayout.LayoutParams.MATCH_PARENT)

    }



}