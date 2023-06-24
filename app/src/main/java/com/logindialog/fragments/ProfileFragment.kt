package com.logindialog.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import com.logindialog.R
import com.logindialog.login.checkLogin


class ProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profiles, container, false)
        val sharedPreference =
            context?.getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        val check = sharedPreference?.getBoolean("isLogin", false)

        if (check == true) {
            Toast.makeText(view.context, "Already Login", Toast.LENGTH_SHORT).show()
        } else {
            childFragmentManager.checkLogin {
                Toast.makeText(view.context, it, Toast.LENGTH_SHORT).show()
            }
        }
        view.findViewById<AppCompatButton>(R.id.profile).setOnClickListener {

        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = ProfileFragment()
    }
}