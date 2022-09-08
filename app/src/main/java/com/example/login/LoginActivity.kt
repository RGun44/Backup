package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    private lateinit var username : TextInputLayout
    private lateinit var password : TextInputLayout
    lateinit var mBundle: Bundle

    lateinit var vUsername: String
    lateinit var vPassword: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        getBundle()
        setText()

        val btnSubmit = findViewById<Button>(R.id.btnLogin)

        btnSubmit.setOnClickListener{
            val intent = Intent(this, HomePenggunaActivity::class.java)
            startActivity(intent)
        }

    }

    fun getBundle(){
        mBundle = intent.getBundleExtra("register")!!
        vUsername = mBundle.getString("nama")!!
        vPassword = mBundle.getString("nim")!!
    }

    fun setText(){
        username = findViewById(R.id.inputLayoutUsername)
        username.getEditText()?.setText(vUsername)
        password = findViewById(R.id.inputLayoutPassword)
        password.getEditText()?.setText(vPassword)
    }
}