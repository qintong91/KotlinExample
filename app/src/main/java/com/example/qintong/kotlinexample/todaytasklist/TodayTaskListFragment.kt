package com.example.qintong.kotlinexample.todaytasklist

import android.graphics.Rect
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.qintong.kotlinexample.R
import com.example.qintong.kotlinexample.data.Task
import com.example.qintong.kotlinexample.di.PerActivity
import com.example.qintong.kotlinexample.view.BaseFragment
import kotlinx.android.synthetic.main.fragment_today_task_list.*
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [ListFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@PerActivity
class TodayTaskListFragment @Inject constructor(): BaseFragment(), TodayTaskListContract.View, TodayTaskListAdapter.OnItemClickListener, TaskDialogFragment.DialogItemsListener {
    override fun onClick(task: Task) {
        Log.d("qintong", "ddd")
        showTaskDialog(task)
    }

    private val mListAdapter = TodayTaskListAdapter(this)

    @Inject
    lateinit var mPresenter : TodayTaskListContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_today_task_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initListReyclerView()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        mPresenter.takeView(this)
        super.onResume()
    }

    override fun onDestroy() {
        mPresenter.dropView()
        super.onDestroy()
    }

    override fun showTasks(list: List<Task>) {
        mListAdapter.tasksList = list
    }

    override val isActive: Boolean
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun showEmptyTaskError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setTitle(title: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setDescription(description: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTaskStart(task: Task) {
        mPresenter
    }

    override fun onViewTaskDetail(task: Task) {
        mPresenter.openTaskDetails(task)
    }

    override fun onCompeteTask(task: Task) {
        mPresenter.completeTask(task)
    }

    fun initListReyclerView() {
        list.addItemDecoration(SpaceItemDecoration(24))
        list.layoutManager = LinearLayoutManager(activity)
        list.adapter = mListAdapter
    }

    inner class SpaceItemDecoration(private val space: Int) : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            if (parent.getChildPosition(view) != 0)
                outRect.top = space
        }
    }

    private fun showTaskDialog(task: Task) {
        TaskDialogFragment(task, this).show(fragmentManager, "6666")
    }
}// Required empty public constructor
