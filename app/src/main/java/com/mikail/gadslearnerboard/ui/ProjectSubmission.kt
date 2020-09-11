package com.mikail.gadslearnerboard.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mikail.gadslearnerboard.R
import com.mikail.gadslearnerboard.Status
import com.mikail.gadslearnerboard.adapter.HoursAdapter
import com.mikail.gadslearnerboard.api.ApiHelper
import com.mikail.gadslearnerboard.api.RetrofitBuilder
import com.mikail.gadslearnerboard.api.google.GoogleApiHelper
import com.mikail.gadslearnerboard.api.google.GoogleFormsRetrofitBuilder
import com.mikail.gadslearnerboard.model.HoursModel
import com.mikail.gadslearnerboard.viewmodel.GoogleViewModel
import com.mikail.gadslearnerboard.viewmodel.GoogleViewModelFactory
import com.mikail.gadslearnerboard.viewmodel.MainViewMOdelFactory
import com.mikail.gadslearnerboard.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_project_submission.*
import kotlinx.android.synthetic.main.confirm_dialog.view.*

class ProjectSubmission : AppCompatActivity() {
    private lateinit var viewModel: GoogleViewModel
    private lateinit var viewModelFactory: GoogleViewModelFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project_submission)
        // Inflate the layout for this fragment


        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val actionbar = supportActionBar
        actionbar?.setDisplayHomeAsUpEnabled(true)


        viewModelFactory = GoogleViewModelFactory(
            GoogleApiHelper(
                GoogleFormsRetrofitBuilder.apiService
            )
        )
        viewModel = ViewModelProvider(this, viewModelFactory).get(GoogleViewModel::class.java)


        submit.setOnClickListener {

            val fname = firstname.text.toString()
            val lname = lastname.text.toString()
            val email = email.text.toString()
            val link = link.text.toString()

            if (fname.isEmpty() && lname.isEmpty() && email.isEmpty() && link.isEmpty()) {
                Toast.makeText(this, "All fields must be filled", Toast.LENGTH_SHORT).show()
            } else {
                showDialog(email, fname, lname, link)
            }
        }
    }

    fun showDialog(email: String, name: String, lastname: String, link: String) {
        //Inflate the dialog with custom view
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.confirm_dialog, null)
        //AlertDialogBuilder
        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)

        //show dialog
        val mAlertDialog = mBuilder.show()
        //login button click of custom layout
        mDialogView.confirm.setOnClickListener {
            viewModel.submitform(email, name, lastname, link).observe(this, Observer { result ->
                when (result.status) {

                    Status.SUCCESS -> {
                        mAlertDialog.dismiss()
                        successDialog()

                    }
                    Status.ERROR -> {
                        mAlertDialog.dismiss()
                        Toast.makeText(this,result.message,Toast.LENGTH_SHORT).show()
                        Log.d("result",result.message.toString())
                        errorDialog()

                    }
                }

            })

        }

        mDialogView.cancel.setOnClickListener {
            mAlertDialog?.dismiss()
        }

    }

    fun successDialog() {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.success_layout, null)
        //AlertDialogBuilder
        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)

        //show dialog
        val mAlertDialog = mBuilder.show()
    }


    fun errorDialog() {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.failure_layout, null)
        //AlertDialogBuilder
        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)

        //show dialog
        val mAlertDialog = mBuilder.show()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
