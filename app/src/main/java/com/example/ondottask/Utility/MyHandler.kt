package com.example.ondottask.Utility
import android.util.Log
import android.view.View
import android.widget.Button


class MyHandler {

    fun onClick(view: View) {
        Log.d("myhandler", "PixaBayAPI on login button clicked")
        (view as Button).setText("Clicked")
    }
}