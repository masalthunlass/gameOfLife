package com.example.masala.gameoflife.presentation.view

import android.content.Context
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.masala.gameoflife.R


class CellView(context: Context, private val position: Int, val size: Int, val color: Int) : ImageView(context) {

    private val imageSrc = R.drawable.cell;

    init {
        val cell: Drawable = context.getDrawable(imageSrc)
        cell.setColorFilter(color, PorterDuff.Mode.MULTIPLY)
        layoutParams = LinearLayout.LayoutParams(size, size)
        setImageDrawable(cell)
        id = position
    }

}