package com.example.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_registration_page_three.*


class RegistrationPageThree : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return  inflater.inflate(R.layout.fragment_registration_page_three, container, false)
    }

    companion object {
        fun newInstance() = RegistrationPageThree()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        name.text = mSettings!!.getString("name", "")
        surname.text = mSettings!!.getString("surname", "")
        login.text = mSettings!!.getString("login", "")
        previous.setOnClickListener { goToSecondStep() }

        confirm.setOnClickListener {
            (requireActivity() as RegistrationActivity).login()
        }
    }

    private fun goToSecondStep() {
        (requireActivity() as RegistrationActivity).navigateToSecondStep()
    }
}