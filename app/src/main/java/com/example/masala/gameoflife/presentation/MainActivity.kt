package com.example.masala.gameoflife.presentation


import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.DisplayMetrics
import android.widget.LinearLayout
import com.example.masala.gameoflife.R
import com.example.masala.gameoflife.model.enums.LifeState
import com.example.masala.gameoflife.presentation.view.CellView
import com.example.masala.gameoflife.presentation.view.GridView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mViewModel = ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {

                val displayMetrics = DisplayMetrics()
                windowManager.defaultDisplay.getMetrics(displayMetrics)
                val maxWidth = displayMetrics.widthPixels - 16
                val maxHeight = displayMetrics.heightPixels - 16

                @Suppress("UNCHECKED_CAST")
                return GridViewModel(maxWidth, maxHeight) as T
            }
        })[GridViewModel::class.java];
        displayGrid(mViewModel)
    }

    private fun displayGrid(mViewModel: GridViewModel) {
        val grid = mViewModel.createGrid(5, 8)
        setContentView(R.layout.grid_layout)
        val gridContainer: LinearLayout = findViewById(R.id.gridContainer)
        var gridView = GridView(this, 5, 8)
        gridContainer.addView(gridView)

        grid.cells.forEach({
            gridView.addView(
                    CellView(this,
                            it.key.toInt(),
                            mViewModel.cellSize,
                            if (it.value.state.equals(LifeState.ALIVE)) getColor(R.color.alive) else getColor(R.color.dead)
                    )
            )
        })


    }
}