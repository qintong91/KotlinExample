package com.example.qintong.kotlinexample.di

interface HasComponent<C> {
    fun getComponent() : C
}