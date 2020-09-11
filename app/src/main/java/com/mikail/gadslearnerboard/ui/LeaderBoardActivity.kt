package com.mikail.gadslearnerboard.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.mikail.gadslearnerboard.R
import com.mikail.gadslearnerboard.adapter.ViewpagerAdapter
import com.mikail.gadslearnerboard.databinding.ActivityLeaderBoardBinding


class LeaderBoardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLeaderBoardBinding
    private var tabLayout: TabLayout? = null
    private var viewPager: ViewPager2? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLeaderBoardBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val mActionBar: android.app.ActionBar? = actionBar
        if (mActionBar != null) {
            mActionBar.setDisplayShowHomeEnabled(false)
            mActionBar.setDisplayShowTitleEnabled(false)
        }


        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)
        viewPager!!.adapter =
            ViewpagerAdapter(
                supportFragmentManager,
                lifecycle
            )

        TabLayoutMediator(
            tabLayout!!,
            viewPager!!,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                when (position) {
                    0 -> tab.text = "Learning Leaders"
                    1 -> tab.text = "SkillIQ Leaders"
                }
            }).attach()


        binding.submit.setOnClickListener {

            val intent = Intent(this,ProjectSubmission::class.java)
            startActivity(intent)
        }



    }

}