package com.android.primefactorizarion.presenter

import com.android.primefactorizarion.view.PrimeView

interface PrimePresenter {
    fun setView(view : PrimeView)
    fun calculatePrime(number : Int)
    fun cancelCalculation()
    fun onViewDetached()
}