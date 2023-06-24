package com.logindialog.login

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.logindialog.R

class LoginDialog : RoundedBottomSheetDialogFragment() {

    private var onClickListener: OnClickListener? = null

    interface OnClickListener {
        fun onClickListener(index: String)
    }
    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    private lateinit var viewModel: LoginViewModel
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.bottom_sheet_modifier, container, false)
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        val progress_circular = view.findViewById<ProgressBar>(R.id.progress_circular)
        val mobile = view.findViewById<AppCompatEditText>(R.id.mobile)
        val password = view.findViewById<AppCompatEditText>(R.id.password)


        view.findViewById<AppCompatButton>(R.id.login).setOnClickListener {

            val sharedPreference =  context?.getSharedPreferences("PREFERENCE_NAME",Context.MODE_PRIVATE)
            val editor = sharedPreference?.edit()

            if(mobile.text.toString().isEmpty()){
                Toast.makeText(view.context, "Enter valid number", Toast.LENGTH_SHORT).show()
            }else if(password.text.toString().isEmpty()){
                Toast.makeText(view.context, "Enter valid number", Toast.LENGTH_SHORT).show()
            }else{
                progress_circular.visibility=View.VISIBLE
                viewModel.login(mobile.text.toString(),password.text.toString())
            }

            viewModel.status.observe(this){
                if(it){
                    editor?.putBoolean("isLogin",true)
                    editor?.apply()
                    progress_circular.visibility=View.GONE
                    onClickListener?.onClickListener("Success")
                    dismiss()
                }else{
                    progress_circular.visibility=View.GONE
                    Toast.makeText(view.context, "Invalid username or password", Toast.LENGTH_SHORT).show()
                }
            }
        }

        return view
    }

    fun show(fragmentManager: FragmentManager) {
        super.show(fragmentManager, "Login")
    }


    companion object {
        @JvmStatic
        fun newInstance() = LoginDialog()
    }

}
 fun FragmentManager.checkLogin(callback:(String)->Unit) {
    LoginDialog.newInstance().apply {
        setOnClickListener(object : LoginDialog.OnClickListener {
            override fun onClickListener(index: String) {
                callback(index)
            }
        })}.show(this)
}

