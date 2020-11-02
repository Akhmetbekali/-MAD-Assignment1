package com.example.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_registration_page_one.*


class RegistrationPageOne : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_registration_page_one, container, false)
    }

    companion object {
        fun newInstance() = RegistrationPageOne()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nextStep.setOnClickListener {
            if (login.text.isEmpty() || password.text.isEmpty()) {
                Toast.makeText(activity, R.string.alert, Toast.LENGTH_LONG).show()
            } else {
                val login = login.text.toString()
                val editor = mSettings!!.edit()
                editor.putString(APP_PREFERENCES_LOGIN, login)
                editor.apply()
                goToSecondStep()
            }
        }
    }
    private fun goToSecondStep() {
        (requireActivity() as RegistrationActivity).navigateToSecondStep()
    }
}