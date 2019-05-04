package com.android.primefactorizarion

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.android.primefactorizarion.presenter.DefaultPrimePresenter
import com.android.primefactorizarion.presenter.PrimePresenter
import com.android.primefactorizarion.view.PrimeView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), PrimeView {


    private lateinit var primePresenter : PrimePresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        primePresenter = DefaultPrimePresenter()
        primePresenter.setView(this)

        button.setOnClickListener { primePresenter.calculatePrime(Math.pow(10.0,20.0).toInt()) }
        button2.setOnClickListener { primePresenter.cancelCalculation() }
    }


    override fun showProgress(percent: Int) {

    }

    override fun cancel() {
        textView.setText("Operation canceled")
    }

    override fun showResult(result: List<Int>) {
        textView.setText(result.toString())
    }

}
