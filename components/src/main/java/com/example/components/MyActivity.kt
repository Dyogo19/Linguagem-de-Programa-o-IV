package com.example.components

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
//import com.example.module.components.showSnack
import com.example.module.components.showToast

class MyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        showToast("Olá, mundo!")
    }
}
