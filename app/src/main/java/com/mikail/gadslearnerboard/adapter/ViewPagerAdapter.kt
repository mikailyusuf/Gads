package com.mikail.gadslearnerboard.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mikail.gadslearnerboard.ui.LearningLeadersFragment
import com.mikail.gadslearnerboard.ui.SkillIqLeadersFragment

class ViewpagerAdapter (fm: FragmentManager?, lifecycle: Lifecycle) : FragmentStateAdapter(fm!!, lifecycle) {
    private val int_items = 2
    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment =
                LearningLeadersFragment()
            1 -> fragment =
                SkillIqLeadersFragment()

        }
        return fragment!!
    }
    override fun getItemCount(): Int {
        return int_items
    }
}