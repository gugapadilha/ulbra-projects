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
import com.example.myapplication.properties.*


class PressureActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {

    private var switchsitolica100: SwitchCompat? = null
    private var switchsitolica120: SwitchCompat? = null
    private var switchsitolica140: SwitchCompat? = null
    private var switchsitolica160: SwitchCompat? = null
    private var switchsitolica180: SwitchCompat? = null
    private var switchsitolica200: SwitchCompat? = null
    private var button: Button? = null

    private var lastButtonSelected: CompoundButton? = null
    private var ePressure: EPressure? = null
    private var heart: HeartRisk? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // não esquecer de trocar o XML
        setContentView(R.layout.activity_pressure)
        getBundle()
        mapearComponetes()
        mapearAcoesComponentes()
    }

    private fun getBundle() {
        heart = intent.extras?.getSerializable("RISK") as HeartRisk?
    }

    private fun mapearComponetes() {


        switchsitolica100 = findViewById(R.id.switch_sistolica_100)
        switchsitolica120 = findViewById(R.id.switch_sistolica_120)
        switchsitolica140 = findViewById(R.id.switch_sistolica_140)
        switchsitolica160 = findViewById(R.id.switch_sistolica_160)
        switchsitolica180 = findViewById(R.id.switch_sistolica_180)
        switchsitolica200 = findViewById(R.id.switch_sistolica_200)
        button = findViewById(R.id.button)
    }

    private fun mapearAcoesComponentes() {
        switchsitolica100?.setOnCheckedChangeListener(this)
        switchsitolica120?.setOnCheckedChangeListener(this)
        switchsitolica140?.setOnCheckedChangeListener(this)
        switchsitolica160?.setOnCheckedChangeListener(this)
        switchsitolica180?.setOnCheckedChangeListener(this)
        switchsitolica200?.setOnCheckedChangeListener(this)

        button?.setOnClickListener{
            if(ePressure != null) {
                heart!!.ePressure = ePressure

                val bundle = Bundle()
                bundle.putSerializable("RISK", heart!!)


                val intent = Intent(applicationContext, HistoricActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            } else {
                Toast.makeText(applicationContext, "Selecione uma faixa de pressão para continuar", Toast.LENGTH_LONG).show()
            }
        }

    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {

        if(isChecked) {
            lastButtonSelected = buttonView
            when (buttonView) {
                switchsitolica100 -> {
                    ePressure = EPressure.SISTOLICA100
                    switchsitolica120?.isChecked = false
                    switchsitolica140?.isChecked = false
                    switchsitolica160?.isChecked = false
                    switchsitolica180?.isChecked = false
                    switchsitolica200?.isChecked = false
                }
                switchsitolica120 -> {
                    ePressure = EPressure.SISTOLICA120
                    switchsitolica100?.isChecked = false
                    switchsitolica140?.isChecked = false
                    switchsitolica160?.isChecked = false
                    switchsitolica180?.isChecked = false
                    switchsitolica200?.isChecked = false
                }
                switchsitolica140 -> {
                    ePressure = EPressure.SISTOLICA140
                    switchsitolica120?.isChecked = false
                    switchsitolica100?.isChecked = false
                    switchsitolica160?.isChecked = false
                    switchsitolica180?.isChecked = false
                    switchsitolica200?.isChecked = false
                }
                switchsitolica160 -> {
                    ePressure = EPressure.SISTOLICA160
                    switchsitolica120?.isChecked = false
                    switchsitolica140?.isChecked = false
                    switchsitolica100?.isChecked = false
                    switchsitolica180?.isChecked = false
                    switchsitolica200?.isChecked = false
                }
                switchsitolica180  -> {
                    ePressure = EPressure.SISTOLICA180
                    switchsitolica120?.isChecked = false
                    switchsitolica140?.isChecked = false
                    switchsitolica160?.isChecked = false
                    switchsitolica100?.isChecked = false
                    switchsitolica200?.isChecked = false
                }
                switchsitolica200 -> {
                    ePressure = EPressure.SISTOLICA200
                    switchsitolica120?.isChecked = false
                    switchsitolica140?.isChecked = false
                    switchsitolica160?.isChecked = false
                    switchsitolica180?.isChecked = false
                    switchsitolica100?.isChecked = false
                }
            }
        } else {
            if(buttonView == lastButtonSelected && !isChecked) {
                ePressure = null
            }
        }
    }


}