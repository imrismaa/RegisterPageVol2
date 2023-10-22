package com.example.registerpagevol2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.registerpagevol2.MainActivity.Companion.viewPagers
import com.example.registerpagevol2.databinding.FragmentLoginBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentLoginBinding

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
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root

        with (binding) {
            txtRegister.setOnClickListener {
                viewPagers.currentItem = 0
            }

            btnLogin.setOnClickListener {
                val intentToHomeActivity = Intent(requireActivity(), HomeActivity::class.java)

                val usernameInput = editTxtUsername.text.toString()
                val passwordInput = editTxtPassword.text.toString()

                val registeredUsername = RegisterFragment.username
                val registeredPassword = RegisterFragment.password

                if (usernameInput.isEmpty() && passwordInput.isEmpty()) {
                    Toast.makeText(requireContext(), "Please fill all the fields",
                        Toast.LENGTH_SHORT).show()
                }
                else{
                    if (usernameInput != registeredUsername ||
                        passwordInput != registeredPassword) {
                        Toast.makeText(requireContext(), "Wrong username or password",
                            Toast.LENGTH_SHORT).show()
                    }
                    else {
                        if (checkbox.isChecked) {
                            Toast.makeText(requireContext(), "Your login info was saved",
                                Toast.LENGTH_SHORT).show()
                            startActivity(intentToHomeActivity)
                        }
                        else {
                            startActivity(intentToHomeActivity)
                        }
                    }
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
         * @return A new instance of fragment LoginFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}