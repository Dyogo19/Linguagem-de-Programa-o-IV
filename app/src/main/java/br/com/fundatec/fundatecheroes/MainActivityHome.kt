package br.com.fundatec.fundatecheroes

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.fundatec.fundatecheroes.R.string


class MainActivityHome: AppCompatActivity() {
    @SuppressLint("StringFormatInvalid")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val viewModel = MainViewModel()

        val etName = findViewById<EditText>(R.id.et_name)
        val btOk = findViewById<Button>(R.id.ok_button)
        val btClear = findViewById<Button>(R.id.clear_button)
        val tvHello = findViewById<TextView>(R.id.tv_hello)

        btOk.setOnClickListener {
            viewModel.validateName(etName.text)

        }

        btClear.setOnClickListener {
            viewModel.clear()
        }

        viewModel.publicName.observe(this) { name ->
            tvHello.text = getString(string.Qual_nome, name)
            //etName.setText(name)
        }

        viewModel.visibility.observe(this) { visibility ->
            tvHello.visibility = visibility
        }

        viewModel.showToast.observe(this) {
            Toast.makeText(this, "Preencha os campos!!!", Toast.LENGTH_LONG).show()
        }

//        viewModel.delet.observe(this){
//            tvHello.
//
//        }

    }
}