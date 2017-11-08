package com.example.qintong.kotlinexample.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager

import android.util.Log
import com.example.qintong.kotlinexample.R
import com.example.qintong.kotlinexample.todaytasklist.ListFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity(), ViewPager.OnPageChangeListener {
    private var fragmentList = ArrayList<Fragment>()
    override fun onCreate(savedInstanceState: Bundle?) {
        fragmentList.add(0, ListFragment.newInstance("11", "12"))
        fragmentList.add(1, ClockFragment.newInstance("21", "22"))
        fragmentList.add(2, SettingFragment.newInstance("31", "32"))

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav.setOnNavigationItemSelectedListener {
            Log.d("qintong1", it.order.toString() + "seletd")
            viewPager.currentItem = it.order
            true
        }
        viewPager.adapter = HomeFragmentAdapter(supportFragmentManager)
        viewPager.addOnPageChangeListener(this)
    }

    inner class HomeFragmentAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }
    }

    override fun onPageScrollStateChanged(state: Int) {
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    override fun onPageSelected(position: Int) {
        nav.menu.getItem(position).isChecked = true
    }
}