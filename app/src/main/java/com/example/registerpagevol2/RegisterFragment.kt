package com.example.registerpagevol2

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.registerpagevol2.MainActivity.Companion.viewPagers

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegisterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_register, container, false)

        with (view) {
            val textTermsAndConditions: TextView = findViewById(R.id.txt_terms_and_conditions)
            val textLogin: TextView = findViewById(R.id.txt_have_account)

            val spannableTextTermsAndConditions = SpannableString(
                "By clicking on Register, you agree to our Terms and Conditions"
            )
            val spannableTextLogin = SpannableString("Already have an account? Login")

            spannableTextTermsAndConditions.setSpan(ForegroundColorSpan(ContextCompat.getColor(
                requireContext(), R.color.blue)), 42, 48, 0)
            spannableTextTermsAndConditions.setSpan(ForegroundColorSpan(ContextCompat.getColor(
                requireContext(), R.color.blue)), 52, 62, 0)
            spannableTextLogin.setSpan(ForegroundColorSpan(ContextCompat.getColor(
                requireContext(), R.color.blue)), 25, 30, 0)

            textTermsAndConditions.text = spannableTextTermsAndConditions
            textLogin.text = spannableTextLogin

            textLogin.setOnClickListener {
                viewPagers.currentItem = 1
            }

            val usernameInput = view.findViewById<EditText>(R.id.edit_txt_username)
            val emailInput = view.findViewById<EditText>(R.id.edit_txt_email)
            val phoneNumberInput = view.findViewById<EditText>(R.id.edit_txt_phone)
            val passwordInput = view.findViewById<EditText>(R.id.edit_txt_password)
            val checkbox = view.findViewById<CheckBox>(R.id.checkbox)
            val btnRegister = view.findViewById<Button>(R.id.btn_register)

            btnRegister.setOnClickListener {
                val username = usernameInput.text.toString()
                val email = emailInput.text.toString()
                val phoneNumber = phoneNumberInput.text.toString()
                val password = passwordInput.text.toString()

                if(username.isEmpty() ||
                    email.isEmpty() ||
                    phoneNumber.isEmpty() ||
                    password.isEmpty()){
                    Toast.makeText(requireContext(),
                        "Please fill all the fields",
                        Toast.LENGTH_SHORT).show()
                }
                else if(!checkbox.isChecked){
                    Toast.makeText(requireContext(),
                        "You didn't agree with the terms and conditions",
                        Toast.LENGTH_SHORT).show()
                }
                else{
                    val bundle = Bundle()
                    bundle.putString("username", username)
                    bundle.putString("password", password)
                    val loginFragment = LoginFragment()
                    loginFragment.arguments = bundle
                    viewPagers.currentItem = 1
                }
            }
        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RegisterFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegisterFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}