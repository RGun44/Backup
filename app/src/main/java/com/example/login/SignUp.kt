package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.textfield.TextInputEditText
import kotlin.time.measureTimedValue


class SignUp : AppCompatActivity() {

    private lateinit var inputUsername: TextInputLayout
    private lateinit var inputPassword: TextInputLayout
    private lateinit var inputBirthDate: TextInputLayout
    private lateinit var inputEmail: TextInputLayout
    private lateinit var inputPhoneNumber: TextInputLayout
    private lateinit var mainLayout: ConstraintLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        setTitle("User Login")
        inputUsername = findViewById(R.id.signup)
        inputPassword = findViewById(R.id.enterpassword)
        inputBirthDate = findViewById(R.id.etbirthdate)
        inputEmail = findViewById(R.id.etemail)
        inputPhoneNumber = findViewById(R.id.etphone)
        mainLayout = findViewById(R.id.mainLayout)
        val btnClear: Button = findViewById(R.id.btnClear)
        val btnSignUp: Button = findViewById(R.id.btnLogin)

        btnClear.setOnClickListener {
            inputUsername.getEditText()?.setText("")
            inputPassword.getEditText()?.setText("")
            inputBirthDate.getEditText()?.setText("")
            inputEmail.getEditText()?.setText("")
            inputPhoneNumber.getEditText()?.setText("")

            Snackbar.make(mainLayout, "Text Cleared Success", Snackbar.LENGTH_LONG).show()
        }

        btnSignUp.setOnClickListener(View.OnClickListener {
            var checkSignUp = false
            val username: String = inputUsername.getEditText()?.getText().toString()
            val password: String = inputPassword.getEditText()?.getText().toString()
            val birthdate: String = inputBirthDate.getEditText()?.getText().toString()
            val email: String = inputEmail.getEditText()?.getText().toString()
            val phoneNumber: String = inputPhoneNumber.getEditText()?.getText().toString()

            if(username.isEmpty()){
                inputUsername.setError("Username must be filled with text")
                checkSignUp = false
            }

            if(password.isEmpty()){
                inputPassword.setError("Password must be filled with text")
                checkSignUp = false
            }

            if(birthdate.isEmpty()){
                inputBirthDate.setError("Birth Date must be filled with text")
                checkSignUp = false
            }

            if(email.isEmpty()){
                inputEmail.setError("Email must be filled with text")
                checkSignUp = false
            }

            if(phoneNumber.isEmpty()){
                inputPhoneNumber.setError("Phone Number must be filled with text")
                checkSignUp = false
            }
            if(username == "admin" && password == "0557") checkSignUp = true
            if(!checkSignUp)return@OnClickListener
            val moveHome = Intent( this@SignUp, LoginActivity::class.java)
            startActivity(moveHome)

            val mBundle = Bundle()
            mBundle.putString("username" , username.toString())
            mBundle.putString("password" , password.toString())
            intent.putExtra("SIGNUP", mBundle)
        })
    }
}