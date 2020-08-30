package com.mikail.gadslearnerboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_leader_board.*


class LeaderBoardActivity : AppCompatActivity() {


    private var tabLayout: TabLayout? = null
    private var viewPager: ViewPager2? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leader_board)


        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)
        viewPager!!.adapter = ViewpagerAdapter(
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


    }
}