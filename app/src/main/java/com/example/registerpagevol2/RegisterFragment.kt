package com.example.registerpagevol2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.registerpagevol2.MainActivity.Companion.viewPagers
import com.example.registerpagevol2.databinding.FragmentRegisterBinding

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

    private lateinit var binding: FragmentRegisterBinding

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

        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        val view = binding.root

        with (binding) {
            txtLogin.setOnClickListener {
                viewPagers.currentItem = 1
            }

            btnRegister.setOnClickListener {
                val registeredUsername = editTxtUsername.text.toString()
                val email = editTxtEmail.text.toString()
                val phoneNumber = editTxtPhone.text.toString()
                val registeredPassword = editTxtPassword.text.toString()

                if(registeredUsername.isEmpty() ||
                    email.isEmpty() ||
                    phoneNumber.isEmpty() ||
                    registeredPassword.isEmpty()){
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
                    username = registeredUsername
                    password = registeredPassword
                    viewPagers.currentItem = 1
                }
            }
        }
        return view
    }

    companion object {
        var username: String? = null
        var password: String? = null
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