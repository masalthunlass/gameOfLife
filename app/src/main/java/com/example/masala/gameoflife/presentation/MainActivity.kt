package com.example.masala.gameoflife.presentation


import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.example.masala.gameoflife.R
import com.example.masala.gameoflife.presentation.view.CustomBottomNavigationView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout)

        displayBottomMenu()

    }

    private fun displayBottomMenu() {
        val bottomNavigationView = findViewById(R.id.bottom_navigation) as BottomNavigationView
        CustomBottomNavigationView.removeShiftMode(bottomNavigationView)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.create_grid_btn -> {
                    CreateGridDialog().show(supportFragmentManager, "CREATE_GRID_DIALOG")
                    true
                }
                R.id.select_points_btn -> {
                    true
                }
                else -> true
            }

        }
    }

}