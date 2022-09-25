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
import com.example.myapplication.properties.ESex


class SexActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {

    private var switchFemale40: SwitchCompat? = null
    private var switchfemale4050: SwitchCompat? = null
    private var switchfemale50: SwitchCompat? = null
    private var switchMele: SwitchCompat? = null
    private var switchMaleLow: SwitchCompat? = null
    private var switchMaleLowBald: SwitchCompat? = null
    private var button: Button? = null

    private var lastButtonSelected: CompoundButton? = null
    private var eSex: ESex? = null
    private var heart: HeartRisk? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sex)
        getBundle()
        mapearComponetes()
        mapearAcoesComponentes()
    }

    private fun getBundle() {
        heart = intent.extras?.getSerializable("RISK") as HeartRisk?
    }

    private fun mapearComponetes() {


        switchFemale40 = findViewById(R.id.switch_female_40)
        switchfemale4050 = findViewById(R.id.switch_female_40_50)
        switchfemale50 = findViewById(R.id.switch_female_50)
        switchMele = findViewById(R.id.switch_male)
        switchMaleLow = findViewById(R.id.switch_male_low)
        switchMaleLowBald = findViewById(R.id.switch_male_low_bald)
        button = findViewById(R.id.button)
    }

    private fun mapearAcoesComponentes() {
        switchFemale40?.setOnCheckedChangeListener(this)
        switchfemale4050?.setOnCheckedChangeListener(this)
        switchfemale50?.setOnCheckedChangeListener(this)
        switchMele?.setOnCheckedChangeListener(this)
        switchMaleLow?.setOnCheckedChangeListener(this)
        switchMaleLowBald?.setOnCheckedChangeListener(this)

        button?.setOnClickListener{
            if(eSex != null) {
                heart!!.eSex = eSex

                val bundle = Bundle()
                bundle.putSerializable("RISK", heart!!)


                val intent = Intent(applicationContext, PesoActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            } else {
                Toast.makeText(applicationContext, "Selecione a faixa de sexo para continuar", Toast.LENGTH_LONG).show()
            }
        }

    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {

        if(isChecked) {
            lastButtonSelected = buttonView
            when (buttonView) {
                switchFemale40 -> {
                    eSex = ESex.FEMALE40
                    switchfemale4050?.isChecked = false
                    switchfemale50?.isChecked = false
                    switchMele?.isChecked = false
                    switchMaleLow?.isChecked = false
                    switchMaleLowBald?.isChecked = false
                }
                switchfemale4050 -> {
                    eSex = ESex.FEMALE40_50
                    switchFemale40?.isChecked = false
                    switchfemale50?.isChecked = false
                    switchMele?.isChecked = false
                    switchMaleLow?.isChecked = false
                    switchMaleLowBald?.isChecked = false
                }
                switchfemale50 -> {
                    eSex = ESex.FEMALE_PLUS_50
                    switchfemale4050?.isChecked = false
                    switchFemale40?.isChecked = false
                    switchMele?.isChecked = false
                    switchMaleLow?.isChecked = false
                    switchMaleLowBald?.isChecked = false
                }
                switchMele -> {
                    eSex = ESex.MALE
                    switchfemale4050?.isChecked = false
                    switchfemale50?.isChecked = false
                    switchFemale40?.isChecked = false
                    switchMaleLow?.isChecked = false
                    switchMaleLowBald?.isChecked = false
                }
                switchMaleLow  -> {
                    eSex = ESex.MALE_LOW
                    switchfemale4050?.isChecked = false
                    switchfemale50?.isChecked = false
                    switchMele?.isChecked = false
                    switchFemale40?.isChecked = false
                    switchMaleLowBald?.isChecked = false
                }
                switchMaleLowBald -> {
                    eSex = ESex.MALE_LOW_BALD
                    switchfemale4050?.isChecked = false
                    switchfemale50?.isChecked = false
                    switchMele?.isChecked = false
                    switchMaleLow?.isChecked = false
                    switchFemale40?.isChecked = false
                }
            }
        } else {
            if(buttonView == lastButtonSelected && !isChecked) {
                eSex = null
            }
        }
    }


}