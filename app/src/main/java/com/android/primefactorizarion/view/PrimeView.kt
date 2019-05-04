package com.android.primefactorizarion.view

interface PrimeView {
    fun showProgress(percent : Int)
    fun cancel()
    fun showResult(result : List<Int>)
}