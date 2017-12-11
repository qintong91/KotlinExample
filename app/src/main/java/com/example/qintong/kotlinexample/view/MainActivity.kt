package com.example.qintong.kotlinexample.view

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.example.qintong.kotlinexample.R
import com.example.qintong.kotlinexample.createtask.CreateTaskActvity
import com.example.qintong.kotlinexample.todaytasklist.TodayTaskListFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity(), ViewPager.OnPageChangeListener {
    val fragments   = arrayOf(
        TodayTaskListFragment.newInstance(),
        ClockFragment.newInstance("21", "22"),
        SettingFragment.newInstance("31", "32"))

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav.setOnNavigationItemSelectedListener {
            viewPager.currentItem = it.order
            true
        }
        viewPager.adapter = HomeFragmentAdapter(supportFragmentManager)
        viewPager.addOnPageChangeListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_activity_actions, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        Log.d("qintong", "onOptionsItemSelected" + item.toString())
        val intent = Intent(this, CreateTaskActvity::class.java)
        startActivity(intent)
        return super.onOptionsItemSelected(item)
    }

    inner class HomeFragmentAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getCount(): Int {
            return fragments.size
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