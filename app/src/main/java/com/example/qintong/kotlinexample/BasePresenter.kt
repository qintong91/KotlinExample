package com.example.qintong.kotlinexample



interface BasePresenter<T> {
    /**
     * Binds presenter with a view when resumed. The Presenter will perform initialization here.
     *
     * @param view the view associated with this presenter
     */
    fun subscribe()

    /**
     * Drops the reference to the view when destroyed
     */
    fun unsubscribe()
}