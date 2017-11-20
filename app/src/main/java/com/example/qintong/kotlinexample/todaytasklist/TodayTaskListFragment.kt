package com.example.qintong.kotlinexample.todaytasklist

import android.graphics.Rect
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.qintong.kotlinexample.R
import com.example.qintong.kotlinexample.data.Task
import dagger.android.support.DaggerFragment;
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
class TodayTaskListFragment @Inject constructor(): DaggerFragment(), TodayTaskListContract.View{

    @Inject
    lateinit var mAdapter: TodayTaskListAdapter

/*    val mAdapter: TodayTaskListAdapter by lazy {
        TodayTaskListAdapter({ task ->
            Log.d(TAG, "click:" + task.title)
        },
        {
            task -> Log.d(TAG, "done click:" + task.title)
            mPresenter.completeTask(task)
        })
    }*/

    val mPresenter : TodayTaskListPresenter by lazy {
        TodayTaskListPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_today_task_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        list.addItemDecoration(SpaceItemDecoration(24))
        list.layoutManager = LinearLayoutManager(activity)
        list.adapter = mAdapter
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        mPresenter.subscribe()
        super.onResume()
    }

    override fun onDetach() {
        super.onDetach()
    }

    companion object {
        fun newInstance(): TodayTaskListFragment {
            return TodayTaskListFragment()
         }
        val TAG = "TodayTaskListFragment"
    }

    override val isActive: Boolean
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun showEmptyTaskError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showTasks(list: List<Task>) {
        mAdapter.tasksList = list
    }

    override fun setTitle(title: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setDescription(description: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    inner class SpaceItemDecoration(private val space: Int) : RecyclerView.ItemDecoration() {

        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            if (parent.getChildPosition(view) != 0)
                outRect.top = space
        }
    }

}// Required empty public constructor
