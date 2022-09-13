package com.guga.coinApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.guga.coinApp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        converter()
    }

    private fun converter(){

        binding.btnCalculate.setOnClickListener{
            if (!tv_real.text.isNullOrBlank()){
                val real = (tv_real.text.toString())
                val valueReal = real.toDouble() * 5.0

                tv_value_real.text = getString(R.string.title_real, valueReal.toString())
            }
            if (!tv_dolar.text.isNullOrBlank()) {

                val dolar = (tv_dolar.text.toString())
                val valueDolar = dolar.toDouble() * 0.2

                tv_value_dolar.text = getString(R.string.title_dolar, valueDolar.toString())
            }
        }
    }
}
