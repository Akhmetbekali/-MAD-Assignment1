package com.example.registration

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import kotlinx.android.synthetic.main.fragment_registration_page_three.*


const val APP_PREFERENCES = "mysettings"
const val APP_PREFERENCES_LOGIN = "login"
const val APP_PREFERENCES_PASSWORD = "password"
const val APP_PREFERENCES_NAME = "name"
const val APP_PREFERENCES_SURNAME = "surname"


var mSettings: SharedPreferences? = null

class RegistrationActivity : FragmentActivity() {
    private lateinit var pageOne: RegistrationPageOne
    private lateinit var pageTwo: RegistrationPageTwo
    private lateinit var pageThree: RegistrationPageThree

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        setContentView(
            R.layout.activity_registration
        )
        pageOne = RegistrationPageOne.newInstance()
        pageTwo = RegistrationPageTwo.newInstance()
        pageThree = RegistrationPageThree.newInstance()
        navigateTo(pageOne)
    }

    fun navigateToFirstStep() {
        navigateTo(pageOne, true)
    }

    fun navigateToSecondStep() {
        navigateTo(pageTwo, true)
    }

    fun navigateToThirdStep() {
        navigateTo(pageThree, true)
    }

    private fun navigateTo(fragment: Fragment, withBackStack: Boolean = false) {
        with(supportFragmentManager.beginTransaction())
        {
            replace(R.id.fragment_container, fragment)
            if (withBackStack) addToBackStack(null)
            commit()
        }
    }

    fun login() {
        val intent = Intent()
        intent.setClassName(this, "com.example.assignment.MainActivity")
        startActivity(intent)
        this.finish()
    }
}
