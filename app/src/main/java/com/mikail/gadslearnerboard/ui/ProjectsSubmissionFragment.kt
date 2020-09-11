package com.mikail.gadslearnerboard.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.mikail.gadslearnerboard.R
import kotlinx.android.synthetic.main.confirm_dialog.view.*
import kotlinx.android.synthetic.main.fragment_projects_submission.view.*


class ProjectsSubmissionFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_projects_submission, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        view.submit.setOnClickListener {
            showDialog()
        }

    }

    fun showDialog() {
        //Inflate the dialog with custom view
        val mDialogView = LayoutInflater.from(activity).inflate(R.layout.confirm_dialog, null)
        //AlertDialogBuilder
        val mBuilder = activity?.let {
            AlertDialog.Builder(it)
                .setView(mDialogView)
        }

        //show dialog
        val mAlertDialog = mBuilder?.show()
        //login button click of custom layout
        mDialogView.confirm.setOnClickListener {
            //Perform nerwork operation
            //ddd

        }

        mDialogView.cancel.setOnClickListener {
            mAlertDialog?.dismiss()
        }


    }
}