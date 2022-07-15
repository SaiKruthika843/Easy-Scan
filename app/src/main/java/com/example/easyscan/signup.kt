package com.example.easyscan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class signup : AppCompatActivity() {

    private lateinit var editEmail: EditText
    private lateinit var editPassword: EditText

    private lateinit var btnSignUp: Button
    private lateinit var editName: EditText

    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        supportActionBar?.hide()
        editEmail = findViewById(R.id.edt_email)
        editPassword = findViewById(R.id.edt_password)
        editName = findViewById(R.id.edt_name)
        btnSignUp = findViewById(R.id.btnSignUp)

        btnSignUp.setOnClickListener {
            val email = editEmail.text.toString()
            val password = editPassword.text.toString()

            signUp(email,password)
        }
    }
    private fun signUp(email: String, password: String){
        //logic for creating user
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                  //code for jumping to home
                    val intent = Intent(this@signup,MainActivity::class.java)
                    startActivity(intent)
                } else {
                   Toast.makeText(this@signup,"Some error occurred",Toast.LENGTH_SHORT).show()
                }
            }


    }

}