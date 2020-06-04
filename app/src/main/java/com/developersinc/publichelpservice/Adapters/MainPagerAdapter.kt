package com.developersinc.publichelpservice.Adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.developersinc.publichelpservice.Fragments.HomeFragment
import com.developersinc.publichelpservice.Fragments.SavedFragment

class MainPagerAdapter(fragmentManager: FragmentManager):FragmentPagerAdapter(fragmentManager) {
    override fun getItem(p0: Int): Fragment {

        return when (p0) {
            0 -> {
                HomeFragment()
            }
            else -> SavedFragment()
        }

    }

    override fun getCount(): Int {

        return 2

    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position)
        {
            0->"Home"
            else ->"Saved Issues"
        }
    }
}