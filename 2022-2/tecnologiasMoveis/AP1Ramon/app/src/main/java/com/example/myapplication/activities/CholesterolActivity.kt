package com.example.myapplication.activities

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


class  CholesterolActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {

    private var switchde180: SwitchCompat? = null
    private var switchde181: SwitchCompat? = null
    private var switchde206: SwitchCompat? = null
    private var switch231: SwitchCompat? = null
    private var switchde256: SwitchCompat? = null
    private var switchacima281: SwitchCompat? = null
    private var button: Button? = null
    private var textView: TextView? = null
    private var number: TextView? = null

    private var lastButtonSelected: CompoundButton? = null
    private var eCholesterol: ECholesterol? = null
    private var heart: HeartRisk? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cholesterol)
        getBundle()
        mapearComponetes()
        mapearAcoesComponentes()
    }

    private fun getBundle() {
        heart = intent.extras?.getSerializable("RISK") as HeartRisk?
    }

    private fun mapearComponetes() {

        number = findViewById(R.id.number)
        textView = findViewById(R.id.text_result)
        switchde180 = findViewById(R.id.switch_abaixo_180)
        switchde181 = findViewById(R.id.switch_de_181)
        switchde206 = findViewById(R.id.switch_de_206)
        switch231 = findViewById(R.id.switch_de_231)
        switchde256 = findViewById(R.id.switch_256)
        switchacima281 = findViewById(R.id.switch_acima_281)
        button = findViewById(R.id.button)
    }

    private fun mapearAcoesComponentes() {
        switchde180?.setOnCheckedChangeListener(this)
        switchde181?.setOnCheckedChangeListener(this)
        switchde206?.setOnCheckedChangeListener(this)
        switch231?.setOnCheckedChangeListener(this)
        switchde256?.setOnCheckedChangeListener(this)
        switchacima281?.setOnCheckedChangeListener(this)

        button?.setOnClickListener{
            if(eCholesterol != null) {
                heart!!.eCholesterol = eCholesterol
                val bundle = Bundle()
                bundle.putSerializable("RISK", heart!!)
                var soma = heart?.sum()
                if (soma != null) {
                    if ((soma >= 6) && (soma <= 11)) {
                        number?.text = "Sua pontuação é $soma"
                        textView?.text = "Sem risco - de 6 a 11"
                    } else if((soma > 12) && (soma < 17) ){
                        number?.text = "Sua pontuação é $soma"
                        textView?.text = "Risco abaixo da média - de 12 a 17"
                    }else if((soma > 18) && (soma < 24) ){
                        number?.text = "Sua pontuação é $soma"
                        textView?.text = "Risco médio - de 18 a 24"
                    }else if((soma > 25) && (soma < 31) ){
                        number?.text = "Sua pontuação é $soma"
                        textView?.text = " Risco moderado - de 25 a 31"
                    }else if((soma > 32) && (soma < 40) ){
                        number?.text = "Sua pontuação é $soma"
                        textView?.text = "Risco alto - de 32 a 40"
                    }else if ((soma > 41) && (soma < 62) ){
                        number?.text = "Sua pontuação é $soma"
                        textView?.text = "Risco muito alto - 41 a 62"
                    }
                }
            } else {
                Toast.makeText(applicationContext, "Selecione uma faixa de Colesterol para calcular", Toast.LENGTH_LONG).show()
            }
        }

    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {

        if(isChecked) {
            lastButtonSelected = buttonView
            when (buttonView) {
                switchde180 -> {
                    eCholesterol = ECholesterol.ABAIXO180
                    switchde181?.isChecked = false
                    switchde206?.isChecked = false
                    switch231?.isChecked = false
                    switchde256?.isChecked = false
                    switchacima281?.isChecked = false
                }
                switchde181 -> {
                    eCholesterol = ECholesterol.DE181
                    switchde180?.isChecked = false
                    switchde206?.isChecked = false
                    switch231?.isChecked = false
                    switchde256?.isChecked = false
                    switchacima281?.isChecked = false
                }
                switchde206 -> {
                    eCholesterol = ECholesterol. DE206
                    switchde181?.isChecked = false
                    switchde180?.isChecked = false
                    switch231?.isChecked = false
                    switchde256?.isChecked = false
                    switchacima281?.isChecked = false
                }
                switch231 -> {
                    eCholesterol = ECholesterol. DE231
                    switchde181?.isChecked = false
                    switchde206?.isChecked = false
                    switchde180?.isChecked = false
                    switchde256?.isChecked = false
                    switchacima281?.isChecked = false
                }
                switchde256  -> {
                    eCholesterol = ECholesterol.DE256
                    switchde181?.isChecked = false
                    switchde206?.isChecked = false
                    switch231?.isChecked = false
                    switchde180?.isChecked = false
                    switchacima281?.isChecked = false
                }
                switchacima281 -> {
                    eCholesterol = ECholesterol.ACIMADE281
                    switchde181?.isChecked = false
                    switchde206?.isChecked = false
                    switch231?.isChecked = false
                    switchde256?.isChecked = false
                    switchde180?.isChecked = false
                }
            }
        } else {
            if(buttonView == lastButtonSelected && !isChecked) {
                eCholesterol = null
            }
        }
    }


}