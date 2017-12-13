package com.example.qintong.kotlinexample.view

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.view.Menu
import android.view.MenuItem
import com.example.qintong.kotlinexample.R
import com.example.qintong.kotlinexample.createtask.CreateTaskActivity
import com.example.qintong.kotlinexample.di.HasComponent
import com.example.qintong.kotlinexample.di.PerActivity
import com.example.qintong.kotlinexample.di.components.ActivityComponent
import com.example.qintong.kotlinexample.extensions.getAppComponent
import com.example.qintong.kotlinexample.todaytasklist.TodayTaskListFragment
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@PerActivity
class MainActivity : BaseActivity(), ViewPager.OnPageChangeListener, HasComponent<ActivityComponent> {

    private val mActivityComponent by lazy {
        getAppComponent().activityComponent()
    }

    @Inject
    lateinit var mTodayTaskListFragment : TodayTaskListFragment
    var mClockFragment  = ClockFragment.newInstance("21", "22")
    var mSettingFragment = SettingFragment.newInstance("31", "32")

    override fun getComponent(): ActivityComponent {
        return mActivityComponent
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityComponent.inject(this)
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
        val intent = Intent(this, CreateTaskActivity::class.java)
        startActivity(intent)
        return super.onOptionsItemSelected(item)
    }

    inner class HomeFragmentAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> mTodayTaskListFragment
                1 -> mClockFragment
                2 -> mSettingFragment
                else -> throw IllegalArgumentException("Invalid Fragment")
            }
        }

        override fun getCount(): Int {
            return 3
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