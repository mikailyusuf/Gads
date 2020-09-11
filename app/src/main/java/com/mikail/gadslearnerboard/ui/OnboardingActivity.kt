package com.mikail.gadslearnerboard.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.mikail.gadslearnerboard.R

class OnboardingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Handler().postDelayed({

            startActivity(Intent(this, LeaderBoardActivity::class.java))
        }, 2000)
        finish()
    }
}