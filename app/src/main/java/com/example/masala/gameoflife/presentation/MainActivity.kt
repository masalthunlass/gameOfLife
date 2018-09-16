package com.example.masala.gameoflife.presentation


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.masala.gameoflife.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout)
        CreateGridDialog().show(supportFragmentManager, "CREATE_GRID_DIALOG")
    }

}