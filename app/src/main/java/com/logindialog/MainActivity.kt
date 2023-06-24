package com.logindialog

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.logindialog.databinding.ActivityMainBinding
import com.logindialog.fragments.ProfileFragment
import com.logindialog.fragments.SettingFragment
import com.logindialog.login.LoginDialog
import com.logindialog.login.checkLogin

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.settings.setOnClickListener {
            setFragments(SettingFragment.newInstance())
        }
        binding.profile.setOnClickListener {
            setFragments(ProfileFragment.newInstance())
        }
    }

    private fun setFragments(fragmentClass: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, fragmentClass)
            .commit()
    }

}