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


class GridActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        val mViewModel = ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {

                val displayMetrics = DisplayMetrics()
                windowManager.defaultDisplay.getMetrics(displayMetrics)
                val maxWidth = displayMetrics.widthPixels
                val maxHeight = displayMetrics.heightPixels

                @Suppress("UNCHECKED_CAST")
                return GridViewModel(maxWidth, maxHeight) as T
            }
        })[GridViewModel::class.java];

        val columns = intent.extras.getInt("columns")
        val rows = intent.extras.getInt("rows")
        displayGrid(mViewModel, rows, columns)

    }

    private fun displayGrid(mViewModel: GridViewModel, rows: Int, columns: Int) {

        setContentView(R.layout.grid_layout)

        val gridLayout: LinearLayout = findViewById(R.id.gridContainer) as LinearLayout
        val gridView = GridView(this, rows, columns)
        gridLayout.addView(gridView)

        mViewModel.createGrid(rows, columns).cells.forEach({
            gridView.addView(
                    CellView(this,
                            it.key.toInt(),
                            mViewModel.cellSize,
                            if (it.value.state.equals(LifeState.ALIVE)) getColor(R.color.alive) else getColor(R.color.dead)
                    ))
        })
    }
}