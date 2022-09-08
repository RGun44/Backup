package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    private lateinit var inputUsername : TextInputLayout
    private lateinit var inputPassword : TextInputLayout
    private lateinit var mainLayout : ConstraintLayout
    lateinit var mBundle: Bundle

    lateinit var vUsername: String
    lateinit var vPassword: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        inputUsername = findViewById(R.id.inputLayoutUsername)
        inputPassword = findViewById(R.id.inputLayoutPassword)
        mainLayout = findViewById(R.id.mainLayout)
        getBundle()

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnClear = findViewById<Button>(R.id.btnClear)

        btnClear.setOnClickListener {
            inputUsername.getEditText()?.setText("")
            inputPassword.getEditText()?.setText("")

            Snackbar.make(mainLayout, "Text Cleared Success", Snackbar.LENGTH_LONG).show()
        }

        btnLogin.setOnClickListener OnClickListener@{
            var checkLogin = false
            val username: String = inputUsername.getEditText()?.getText().toString()
            val password: String = inputPassword.getEditText()?.getText().toString()

            if(username.isEmpty()){
                inputUsername.setError("Username must be filled with text")
                checkLogin = false
            }

            if(password.isEmpty()){
                inputPassword.setError("Password must be filled with text")
                checkLogin = false
            }
            if(username == "admin" && password == "0557") checkLogin = true
            if(!checkLogin)return@OnClickListener
            val intent = Intent(this, HomePenggunaActivity::class.java)
            startActivity(intent)

            if(username == vUsername && password == vPassword)
                setText()
        }

    }

    fun getBundle(){
        mBundle = intent.getBundleExtra("SIGNUP")!!
        vUsername = mBundle.getString("username")!!
        vPassword = mBundle.getString("password")!!
    }

    fun setText(){
        inputUsername = findViewById(R.id.inputLayoutUsername)
        inputUsername.getEditText()?.setText(vUsername)
        inputPassword = findViewById(R.id.inputLayoutPassword)
        inputPassword.getEditText()?.setText(vPassword)
    }
}