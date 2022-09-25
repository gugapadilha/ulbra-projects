package com.example.myapplication.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CompoundButton
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat
import com.example.myapplication.R
import com.example.myapplication.model.HeartRisk
import com.example.myapplication.properties.ESmoker


class SmokerActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {

    private var switchnosmoker: SwitchCompat? = null
    private var switchcigar: SwitchCompat? = null
    private var switchcigarette10: SwitchCompat? = null
    private var switchcigarette11: SwitchCompat? = null
    private var switchcigarette21: SwitchCompat? = null
    private var switchcigarette31: SwitchCompat? = null
    private var button: Button? = null

    private var lastButtonSelected: CompoundButton? = null
    private var eSmoker: ESmoker? = null
    private var heart: HeartRisk? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_smoker)
        getBundle()
        mapearComponetes()
        mapearAcoesComponentes()
    }

    private fun getBundle() {
        heart = intent.extras?.getSerializable("RISK") as HeartRisk?
    }

    private fun mapearComponetes() {


        switchnosmoker = findViewById(R.id.switch_no_smoker)
        switchcigar = findViewById(R.id.switch_cigar)
        switchcigarette10 = findViewById(R.id.switch_cigarette_10)
        switchcigarette11 = findViewById(R.id.switch_cigarette_11)
        switchcigarette21 = findViewById(R.id.switch_cigarette_21)
        switchcigarette31 = findViewById(R.id.switch_cigarette_31)
        button = findViewById(R.id.button)
    }

    private fun mapearAcoesComponentes() {
        switchnosmoker?.setOnCheckedChangeListener(this)
        switchcigar?.setOnCheckedChangeListener(this)
        switchcigarette10?.setOnCheckedChangeListener(this)
        switchcigarette11?.setOnCheckedChangeListener(this)
        switchcigarette21?.setOnCheckedChangeListener(this)
        switchcigarette31?.setOnCheckedChangeListener(this)

        button?.setOnClickListener{
            if(eSmoker != null) {

                heart!!.eSmoker = eSmoker

                val bundle = Bundle()
                bundle.putSerializable("RISK", heart!!)


                val intent = Intent(applicationContext, PressureActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)

            } else {
                Toast.makeText(applicationContext, "Selecione uma faixa de fumante para continuar", Toast.LENGTH_LONG).show()
            }
        }

    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {

        if(isChecked) {
            lastButtonSelected = buttonView
            when (buttonView) {
                switchnosmoker -> {
                    eSmoker = ESmoker.SMOKER
                    switchcigar?.isChecked = false
                    switchcigarette10?.isChecked = false
                    switchcigarette11?.isChecked = false
                    switchcigarette21?.isChecked = false
                    switchcigarette31?.isChecked = false
                }
                switchcigar -> {
                    eSmoker = ESmoker.CIGAR
                    switchnosmoker?.isChecked = false
                    switchcigarette10?.isChecked = false
                    switchcigarette11?.isChecked = false
                    switchcigarette21?.isChecked = false
                    switchcigarette31?.isChecked = false
                }
                switchcigarette10 -> {
                    eSmoker = ESmoker.CIGARETTE10
                    switchcigar?.isChecked = false
                    switchnosmoker?.isChecked = false
                    switchcigarette11?.isChecked = false
                    switchcigarette21?.isChecked = false
                    switchcigarette31?.isChecked = false
                }
                switchcigarette11 -> {
                    eSmoker = ESmoker.CIGARETTE11
                    switchcigar?.isChecked = false
                    switchcigarette10?.isChecked = false
                    switchnosmoker?.isChecked = false
                    switchcigarette21?.isChecked = false
                    switchcigarette31?.isChecked = false
                }
                switchcigarette21  -> {
                    eSmoker = ESmoker.CIGARETTE21
                    switchcigar?.isChecked = false
                    switchcigarette10?.isChecked = false
                    switchcigarette11?.isChecked = false
                    switchnosmoker?.isChecked = false
                    switchcigarette31?.isChecked = false
                }
                switchcigarette31 -> {
                    eSmoker = ESmoker.CIGARETTE31
                    switchcigar?.isChecked = false
                    switchcigarette10?.isChecked = false
                    switchcigarette11?.isChecked = false
                    switchcigarette21?.isChecked = false
                    switchnosmoker?.isChecked = false
                }
            }
        } else {
            if(buttonView == lastButtonSelected && !isChecked) {
                eSmoker = null
            }
        }
    }


}