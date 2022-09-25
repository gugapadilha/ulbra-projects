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
import com.example.myapplication.properties.EPesos


class PesoActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {

    private var inferior2: SwitchCompat? = null
    private var menos2: SwitchCompat? = null
    private var de9: SwitchCompat? = null
    private var de15: SwitchCompat? = null
    private var de22: SwitchCompat? = null
    private var de23: SwitchCompat? = null
    private var button: Button? = null

    private var lastButtonSelected: CompoundButton? = null
    private var ePesos: EPesos? = null
    private var heart: HeartRisk? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesos)
        getBundle()
        mapearComponetes()
        mapearAcoesComponentes()
    }

    private fun getBundle() {
        heart = intent.extras?.getSerializable("RISK") as HeartRisk?
    }

    private fun mapearComponetes() {


        inferior2 = findViewById(R.id.switch_peso2)
        menos2 = findViewById(R.id.switch_menos2)
        de9 = findViewById(R.id.switch_de_9)
        de15 = findViewById(R.id.switch_de_15)
        de22 = findViewById(R.id.switch_de_22)
        de23 = findViewById(R.id.switch_mais_23)
        button = findViewById(R.id.button)
    }

    private fun mapearAcoesComponentes() {
        inferior2?.setOnCheckedChangeListener(this)
        menos2?.setOnCheckedChangeListener(this)
        de9?.setOnCheckedChangeListener(this)
        de15?.setOnCheckedChangeListener(this)
        de22?.setOnCheckedChangeListener(this)
        de23?.setOnCheckedChangeListener(this)

        button?.setOnClickListener{
            if(ePesos != null) {
                heart!!.ePesos = ePesos

                val bundle = Bundle()
                bundle.putSerializable("RISK", heart!!)


                val intent = Intent(applicationContext, ExerciseActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            } else {
                Toast.makeText(applicationContext, "Selecione a faixa de peso para continuar", Toast.LENGTH_LONG).show()
            }
        }

    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {

        if(isChecked) {
            lastButtonSelected = buttonView
            when (buttonView) {
                inferior2 -> {
                    ePesos = EPesos.PESO1
                    menos2?.isChecked = false
                    de9?.isChecked = false
                    de15?.isChecked = false
                    de22?.isChecked = false
                    de23?.isChecked = false
                }
                menos2 -> {
                    ePesos = EPesos.MENO2
                    de9?.isChecked = false
                    inferior2?.isChecked = false
                    de9?.isChecked = false
                    de15?.isChecked = false
                    de22?.isChecked = false
                    de23?.isChecked = false
                }
                de9 -> {
                    ePesos = EPesos.DE9
                    menos2?.isChecked = false
                    inferior2?.isChecked = false
                    de15?.isChecked = false
                    de22?.isChecked = false
                    de23?.isChecked = false
                }
                de15 -> {
                    ePesos = EPesos.DE15
                    menos2?.isChecked = false
                    de9?.isChecked = false
                    inferior2?.isChecked = false
                    de22?.isChecked = false
                    de23?.isChecked = false
                }
                de22  -> {
                    ePesos = EPesos.DE22
                    menos2?.isChecked = false
                    de9?.isChecked = false
                    de15?.isChecked = false
                    inferior2?.isChecked = false
                    de23?.isChecked = false
                }
                de23 -> {
                    ePesos = EPesos.ACIMA25
                    menos2?.isChecked = false
                    de9?.isChecked = false
                    de15?.isChecked = false
                    de22?.isChecked = false
                    inferior2?.isChecked = false
                }
            }
        } else {
            if(buttonView == lastButtonSelected && !isChecked) {
                ePesos = null
            }
        }
    }


}