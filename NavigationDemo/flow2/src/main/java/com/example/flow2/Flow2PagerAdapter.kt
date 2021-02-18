package com.example.flow2

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class Flow2PagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> Flow2Fragment1.newInstance()
            1 -> Flow2Fragment2.newInstance()
            2 -> Flow2Fragment3.newInstance()
            else -> throw IndexOutOfBoundsException()
        }
    }

    fun getTabText(position: Int): String {
        return when (position) {
            0 -> "Fragment 1"
            1 -> "Fragment 2"
            2 -> "Fragment 3"
            else -> throw IndexOutOfBoundsException()
        }
    }
}