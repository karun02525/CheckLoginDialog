package com.logindialog.login

import android.app.Dialog
import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.logindialog.R


abstract class RoundedBottomSheetDialogFragment : BottomSheetDialogFragment() {
    override fun getTheme(): Int = R.style.BottomSheetDialog_Rounded

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog = BottomSheetDialog(requireContext(), theme)

}