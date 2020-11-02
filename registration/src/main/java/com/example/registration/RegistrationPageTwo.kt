package com.example.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_registration_page_one.*
import kotlinx.android.synthetic.main.fragment_registration_page_two.*

class RegistrationPageTwo : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_registration_page_two, container, false)
    }

    companion object {
        fun newInstance() = RegistrationPageTwo()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        previous_step.setOnClickListener { goToFirstStep() }

        finish.setOnClickListener {
            if (name.text.isEmpty() || surname.text.isEmpty()) {
                Toast.makeText(activity, R.string.alert, Toast.LENGTH_LONG).show()
            } else {
                val name = name.text.toString()
                val surname = surname.text.toString()
                val editor = mSettings!!.edit()
                editor.putString(APP_PREFERENCES_NAME, name)
                editor.putString(APP_PREFERENCES_SURNAME, surname)
                editor.apply()
                (requireActivity() as RegistrationActivity).navigateToThirdStep()
            }
        }
    }

    private fun goToFirstStep() {
        (requireActivity() as RegistrationActivity).navigateToFirstStep()
    }
}