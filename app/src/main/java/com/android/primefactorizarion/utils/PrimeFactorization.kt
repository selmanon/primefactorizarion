package com.android.primefactorizarion.utils

import android.util.Log
import com.android.primefactorizarion.presenter.DefaultPrimePresenter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object PrimeFactorization {

    suspend fun calculatePrimeFactorization(numberToCalculate: Int): List<Int> = withContext(Dispatchers.Default) {
        Log.v(DefaultPrimePresenter::class.java.name, "calculatePrime in progress on Thread " + Thread.currentThread().name )
        val result = mutableListOf<Int>()
        var number = numberToCalculate
        for (n in 2..number) {
            while (number % n == 0) {
                result.add(n)
                number /= n
            }
        }

        result
    }

}