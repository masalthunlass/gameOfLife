package com.example.masala.gameoflife.presentation

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.EditText
import com.example.masala.gameoflife.R


class CreateGridDialog : DialogFragment() {
    var TAG = "FullScreenDialog"
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        val dialogContent = activity.layoutInflater.inflate(R.layout.create_grid_dialog_layout, null)
        return AlertDialog.Builder(activity)
                .setTitle(R.string.dimensions_de_la_grille)
                .setView(dialogContent)
                .setCancelable(false)
                .setPositiveButton(R.string.create_grid, { _, _ ->
                    run {
                        handlePositive(dialogContent)
                    }
                }).create()
    }

    private fun handlePositive(dialogContent: View) {
        val extras = Bundle()
        val intent = Intent(activity, GridActivity::class.java)
        val heightInput: EditText = dialogContent.findViewById(R.id.height_input) as EditText
        val widthInput: EditText = dialogContent.findViewById(R.id.width_input) as EditText
        extras.putInt("columns", Integer.valueOf(heightInput.text.toString().trim()))
        extras.putInt("rows", Integer.valueOf(widthInput.text.toString().trim()))
        intent.putExtras(extras)
        activity.startActivity(intent)
    }

}