package com.example.login

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        login.text = "Hello, " + intent.getStringExtra("login") + "!"
        name.text = "Name:  " + intent.getStringExtra("name")
        surname.text = "Surname:  " + intent.getStringExtra("surname")

        button.setOnClickListener {
            login()
        }
    }
    private fun login() {
        val intent = Intent()
        intent.setClassName(this, "com.example.assignment.MainActivity")
        startActivity(intent)
        this.finish()
    }

}