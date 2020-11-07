package com.example.assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.registration.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginButton.setOnClickListener {
            if (loginInput.text.isEmpty() || passwordInput.text.isEmpty()) {
                Toast.makeText(this, R.string.empty_alert, Toast.LENGTH_LONG).show()
            }
            else if(mSettings?.getString(APP_PREFERENCES_LOGIN, "") == null)
            {
                Toast.makeText(this, R.string.no_user_alert, Toast.LENGTH_LONG).show()
            }
            else if(mSettings?.getString(APP_PREFERENCES_PASSWORD, "") != passwordInput.text.toString() ||
                mSettings?.getString(APP_PREFERENCES_LOGIN, "") != loginInput.text.toString())
            {
                Toast.makeText(this, R.string.wrong_credentials, Toast.LENGTH_LONG).show()
            }
            else {
                login("login.LoginActivity")
            }
        }

        registration.setOnClickListener {
            login("registration.RegistrationActivity")
        }
    }

    private fun login(path: String) {
        val intent = Intent()
        intent.setClassName(this, "com.example.$path")
        if (path == "login.LoginActivity") {
            intent.putExtra("login", mSettings!!.getString(APP_PREFERENCES_LOGIN, ""))
            intent.putExtra("name", mSettings!!.getString(APP_PREFERENCES_NAME, ""))
            intent.putExtra("surname", mSettings!!.getString(APP_PREFERENCES_SURNAME, ""))
        }
        startActivity(intent)
        this.finish()
    }
}