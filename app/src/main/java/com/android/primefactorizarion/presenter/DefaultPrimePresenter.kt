package com.android.primefactorizarion.presenter

import android.util.Log
import com.android.primefactorizarion.view.PrimeView
import com.android.primefactorizarion.utils.PrimeFactorization
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class DefaultPrimePresenter : PrimePresenter {


    private lateinit var view : PrimeView
    private var job : Job? = null

    override fun setView(view: PrimeView) {
        this.view = view
    }

    override fun calculatePrime(number : Int) {
        job = CoroutineScope(Dispatchers.Main).launch {
            Log.v(DefaultPrimePresenter::class.java.name, "calculatePrime started")
            val result = PrimeFactorization.calculatePrimeFactorization(number)
            Log.v(DefaultPrimePresenter::class.java.name, "calculatePrime finished")
            view.showResult(result)
        }
    }

    override fun cancelCalculation() {
        Log.v(DefaultPrimePresenter::class.java.name, "cancelCalculation")
        if(!job?.isCancelled!!) {
            job?.cancel()
            view.cancel()
        }
    }

    override fun onViewDetached() {
        job?.cancel()
    }

}