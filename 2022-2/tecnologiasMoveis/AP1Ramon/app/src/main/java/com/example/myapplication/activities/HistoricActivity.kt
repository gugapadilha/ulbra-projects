package com.example.myapplication.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CompoundButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat
import com.example.myapplication.R
import com.example.myapplication.model.HeartRisk
import com.example.myapplication.properties.*


class  HistoricActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {

    private var switchnohistoric: SwitchCompat? = null
    private var switchhistoric1: SwitchCompat? = null
    private var switchhistoric2: SwitchCompat? = null
    private var switchlowhistoric1: SwitchCompat? = null
    private var switchlowhistoric2: SwitchCompat? = null
    private var switchlowhistoric3: SwitchCompat? = null
    private var button: Button? = null
    private var textView: TextView? = null

    private var lastButtonSelected: CompoundButton? = null
    private var eHistoric: EHistoric? = null
    private var heart: HeartRisk? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // não esquecer de trocar o XML
        setContentView(R.layout.activity_historic)
        getBundle()
        mapearComponetes()
        mapearAcoesComponentes()
    }

    private fun getBundle() {
        heart = intent.extras?.getSerializable("RISK") as HeartRisk?
    }

    private fun mapearComponetes() {

        textView = findViewById(R.id.text_result)
        switchnohistoric = findViewById(R.id.switch_no_historic)
        switchhistoric1 = findViewById(R.id.switch_1_historic_60)
        switchhistoric2 = findViewById(R.id.switch_2_historic_60)
        switchlowhistoric1 = findViewById(R.id.switch_1_low_historic)
        switchlowhistoric2 = findViewById(R.id.switch_2_low_historic)
        switchlowhistoric3 = findViewById(R.id.switch_3_low_historic)
        button = findViewById(R.id.button)
    }

    private fun mapearAcoesComponentes() {
        switchnohistoric?.setOnCheckedChangeListener(this)
        switchhistoric1?.setOnCheckedChangeListener(this)
        switchhistoric2?.setOnCheckedChangeListener(this)
        switchlowhistoric1?.setOnCheckedChangeListener(this)
        switchlowhistoric2?.setOnCheckedChangeListener(this)
        switchlowhistoric3?.setOnCheckedChangeListener(this)

        button?.setOnClickListener{
            if(eHistoric != null) {
                heart!!.eHistoric = eHistoric
                val bundle = Bundle()
                bundle.putSerializable("RISK", heart!!)

                val intent = Intent(applicationContext, CholesterolActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)

            } else {
                Toast.makeText(applicationContext, "Selecione uma faixa de Historico para continuar", Toast.LENGTH_LONG).show()
            }
        }

    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {

        if(isChecked) {
            lastButtonSelected = buttonView
            when (buttonView) {
                switchnohistoric -> {
                    eHistoric = EHistoric.NOHISTORIC
                    switchhistoric1?.isChecked = false
                    switchhistoric2?.isChecked = false
                    switchlowhistoric1?.isChecked = false
                    switchlowhistoric2?.isChecked = false
                    switchlowhistoric3?.isChecked = false
                }
                switchhistoric1 -> {
                    eHistoric = EHistoric.HISTORIC1
                    switchnohistoric?.isChecked = false
                    switchhistoric2?.isChecked = false
                    switchlowhistoric1?.isChecked = false
                    switchlowhistoric2?.isChecked = false
                    switchlowhistoric3?.isChecked = false
                }
                switchhistoric2 -> {
                    eHistoric = EHistoric.HISTORIC2
                    switchhistoric1?.isChecked = false
                    switchnohistoric?.isChecked = false
                    switchlowhistoric1?.isChecked = false
                    switchlowhistoric2?.isChecked = false
                    switchlowhistoric3?.isChecked = false
                }
                switchlowhistoric1 -> {
                    eHistoric = EHistoric.LOWHISTORIC1
                    switchhistoric1?.isChecked = false
                    switchhistoric2?.isChecked = false
                    switchnohistoric?.isChecked = false
                    switchlowhistoric2?.isChecked = false
                    switchlowhistoric3?.isChecked = false
                }
                switchlowhistoric2  -> {
                    eHistoric = EHistoric.LOWHISTORIC2
                    switchhistoric1?.isChecked = false
                    switchhistoric2?.isChecked = false
                    switchlowhistoric1?.isChecked = false
                    switchnohistoric?.isChecked = false
                    switchlowhistoric3?.isChecked = false
                }
                switchlowhistoric3 -> {
                    eHistoric = EHistoric.LOWHISTORIC3
                    switchhistoric1?.isChecked = false
                    switchhistoric2?.isChecked = false
                    switchlowhistoric1?.isChecked = false
                    switchlowhistoric2?.isChecked = false
                    switchnohistoric?.isChecked = false
                }
            }
        } else {
            if(buttonView == lastButtonSelected && !isChecked) {
                eHistoric = null
            }
        }
    }


}