package com.example.android.browser

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment

class JsDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setMessage("confirm")
            .setPositiveButton("OK") { _, _ ->
                parentFragmentManager.setFragmentResult(
                    REQUEST_KEY,
                    bundleOf(RESULT_KEY to JsDialogResult.OK)
                )
            }
            .create()

    companion object {
        const val REQUEST_KEY = "dialog_request"
        const val RESULT_KEY = "dialog_result"
    }
}
