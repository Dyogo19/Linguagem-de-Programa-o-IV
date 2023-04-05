//package com.example.components
package com.example.module.components

import android.content.Context
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class Components

fun Context.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()

    fun Context.showSnack(
        message: String,
        duration: Int = Snackbar.LENGTH_SHORT,
        actionText: String? = null,
        action: (() -> Unit)? = null
    ) {
        val snack = Snackbar.make(this, message, duration)
        if (actionText != null && action != null) {
            snack.setAction(actionText) { action() }
        }
        snack.show()
    }
}