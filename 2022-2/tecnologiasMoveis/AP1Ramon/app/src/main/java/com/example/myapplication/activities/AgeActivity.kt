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
import com.example.myapplication.properties.EAge


class AgeActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {

    private var switch10To20: SwitchCompat? = null
    private var switch21To30: SwitchCompat? = null
    private var switch31To40: SwitchCompat? = null
    private var switch41To50: SwitchCompat? = null
    private var switch51To60: SwitchCompat? = null
    private var switchAbove60: SwitchCompat? = null
    private var button: Button? = null

    private var lastButtonSelected: CompoundButton? = null
    private var eAge: EAge? = null
    private var heart: HeartRisk? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_age)
        heart = HeartRisk()
        mapearComponetes()
        mapearAcoesComponentes()
    }

    private fun mapearComponetes() {
        switch10To20 = findViewById(R.id.switch_10_20)
        switch21To30 = findViewById(R.id.switch_21_30)
        switch31To40 = findViewById(R.id.switch_31_40)
        switch41To50 = findViewById(R.id.switch_41_50)
        switch51To60 = findViewById(R.id.switch_51_60)
        switchAbove60 = findViewById(R.id.switch_above_60)
        button = findViewById(R.id.button)
    }

    private fun mapearAcoesComponentes() {
        switch10To20?.setOnCheckedChangeListener(this)
        switch21To30?.setOnCheckedChangeListener(this)
        switch31To40?.setOnCheckedChangeListener(this)
        switch41To50?.setOnCheckedChangeListener(this)
        switch51To60?.setOnCheckedChangeListener(this)
        switchAbove60?.setOnCheckedChangeListener(this)

        button?.setOnClickListener{
            if(eAge != null) {
                heart!!.eAge = eAge

                val bundle = Bundle()
                bundle.putSerializable("RISK", heart!!)


                val intent = Intent(applicationContext, SexActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            } else {
                Toast.makeText(applicationContext, "Selecione uma faixa de idade para continuar", Toast.LENGTH_LONG).show()
            }
        }

    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {

        if(isChecked) {
            lastButtonSelected = buttonView
            when (buttonView) {
                switch10To20 -> {
                    eAge = EAge.TEN_TO_TWENTY
                    switch21To30?.isChecked = false
                    switch31To40?.isChecked = false
                    switch41To50?.isChecked = false
                    switch51To60?.isChecked = false
                    switchAbove60?.isChecked = false
                }
                switch21To30 -> {
                    eAge = EAge.TWENTY_ONE_TO_THIRTY
                    switch10To20?.isChecked = false
                    switch31To40?.isChecked = false
                    switch41To50?.isChecked = false
                    switch51To60?.isChecked = false
                    switchAbove60?.isChecked = false
                }
                switch31To40 -> {
                    eAge = EAge.THIRTY_ONE_TO_FORTY
                    switch21To30?.isChecked = false
                    switch10To20?.isChecked = false
                    switch41To50?.isChecked = false
                    switch51To60?.isChecked = false
                    switchAbove60?.isChecked = false
                }
                switch41To50 -> {
                    eAge = EAge.FORTY_ONE_TO_FIFTY
                    switch21To30?.isChecked = false
                    switch31To40?.isChecked = false
                    switch10To20?.isChecked = false
                    switch51To60?.isChecked = false
                    switchAbove60?.isChecked = false
                }
                switch51To60 -> {
                    eAge = EAge.FIFTY_ONE_TO_SIXTY
                    switch21To30?.isChecked = false
                    switch31To40?.isChecked = false
                    switch41To50?.isChecked = false
                    switch10To20?.isChecked = false
                    switchAbove60?.isChecked = false
                }
                switchAbove60 -> {
                    eAge = EAge.ABOVE_SIXTY
                    switch21To30?.isChecked = false
                    switch31To40?.isChecked = false
                    switch41To50?.isChecked = false
                    switch51To60?.isChecked = false
                    switch10To20?.isChecked = false
                }
            }
        } else {
            if(buttonView == lastButtonSelected && !isChecked) {
                eAge = null
            }
        }
    }


}