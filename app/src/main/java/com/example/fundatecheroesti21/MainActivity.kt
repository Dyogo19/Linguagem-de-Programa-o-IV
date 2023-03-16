package com.example.fundatecheroesti21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val car = Car(
//            rodas = 4,
//            portas = 2,
//            motor = "V6"
//        )
//        car to String()
//
//        Log.e("tag" , "MainActivity")
//
//    }
//
//    sealed class Result {
//        data class Sucess(val parafuso: String) : Result()
//        object Loading : Result()
//        object Error : Result()
//    }
//
// data class Car (
//     val rodas: Int,
//     val portas: Int,
//     val motor: String
//         )

        val etName = findViewById<EditText>(R.id.maedocailan)
        val  btOk = findViewById<Button>(R.id.butaoOK)
        val btClear = findViewById<Button>(R.id.butaoLimpar)
        val tvHello = findViewById<TextView>(R.id.tv_hello)

        btOk.setOnClickListener {
            tvHello.text = getString(R.string.nome, etName.text)
            tvHello.visibility = View.VISIBLE
        }

        btClear.setOnClickListener{
            tvHello.visibility = View.GONE
            etName.text.clear()
        }
    }
}