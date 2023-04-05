package com.example.components
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class Extensions {
    fun View.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this.context, message, duration).show()
    }

    fun View.showSnack(message: String, duration: Int = Snackbar.LENGTH_SHORT) {
        Snackbar.make(this, message, duration).show()
    }
}