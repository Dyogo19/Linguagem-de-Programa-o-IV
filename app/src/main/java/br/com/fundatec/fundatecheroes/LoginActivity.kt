package br.com.fundatec.fundatecheroes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val btLogin = findViewById<Button>(R.id.login)
        btLogin.setOnClickListener{
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
            finish()
        }

        val meuTextView = findViewById<TextView>(R.id.novo)

        meuTextView.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}