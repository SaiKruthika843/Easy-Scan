package com.example.easyscan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class login : AppCompatActivity() {
    private lateinit var editEmail:EditText
    private lateinit var editPassword:EditText
    private lateinit var btnLogin:Button
    private lateinit var btnSignUp:Button

    private lateinit var mAuth:FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        mAuth = FirebaseAuth.getInstance()
        supportActionBar?.hide()

        editEmail = findViewById(R.id.edt_email)
        editPassword = findViewById(R.id.edt_password)
        btnLogin = findViewById(R.id.btnLogin)
        btnSignUp = findViewById(R.id.btnSignUp)

        btnSignUp.setOnClickListener {
            val intent = Intent(this,signup::class.java)
            startActivity(intent)
        }
        btnLogin.setOnClickListener {
            val email = editEmail.text.toString()
            val password = editPassword.text.toString()

        logIn(email,password);
        }
    }
    private fun logIn(email: String, password: String){
//logic for login
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    //code for logging in user
                    val intent = Intent(this@login,MainActivity::class.java)
                    startActivity(intent)
                } else {
                    // If sign in fails, display a message to the user.
                   Toast.makeText(this@login, "User does not exist", Toast.LENGTH_SHORT).show()
                }
            }
    }
}