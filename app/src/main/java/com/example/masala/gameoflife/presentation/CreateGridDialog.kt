package com.example.masala.gameoflife.presentation

import android.app.Dialog

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import android.widget.EditText
import com.example.masala.gameoflife.R


class CreateGridDialog : DialogFragment() {


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        super.onCreateDialog(savedInstanceState);

        val dialogContent = activity.layoutInflater.inflate(R.layout.grid_dialog_layout, null)

        return AlertDialog.Builder(activity)
                .setTitle(R.string.dimensions_de_la_grille)
                .setView(dialogContent)
                .setCancelable(false)
                .setPositiveButton(R.string.create_grid, { _, _ ->
                    run {
                        val extras = Bundle()
                        val intent = Intent(activity, GridActivity::class.java)

                        val heightInput = dialogContent.findViewById<EditText>(R.id.height_input)
                        val widthInput = dialogContent.findViewById<EditText>(R.id.width_input)

                        extras.putInt("columns", Integer.valueOf(heightInput.text.toString().trim()))
                        extras.putInt("rows", Integer.valueOf(widthInput.text.toString().trim()))
                        intent.putExtras(extras)

                        activity.startActivity(intent)
                    }
                }).create()
    }


}