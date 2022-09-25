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
import com.example.myapplication.properties.EExercise


class ExerciseActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {

    private var switchintense: SwitchCompat? = null
    private var switchmoderateeffort: SwitchCompat? = null
    private var switchintensework: SwitchCompat? = null
    private var switchmoderatework: SwitchCompat? = null
    private var switchligthwork: SwitchCompat? = null
    private var switchabsence: SwitchCompat? = null
    private var button: Button? = null

    private var lastButtonSelected: CompoundButton? = null
    private var eExercise: EExercise? = null
    private var heart: HeartRisk? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)
        getBundle()
        mapearComponetes()
        mapearAcoesComponentes()
    }

    private fun getBundle() {
        heart = intent.extras?.getSerializable("RISK") as HeartRisk?
    }

    private fun mapearComponetes() {


        switchintense = findViewById(R.id.switch_intense_effort)
        switchmoderateeffort = findViewById(R.id.switch_moderate_effort)
        switchintensework = findViewById(R.id.switch_intense_work)
        switchmoderatework = findViewById(R.id.switch_moderate_work)
        switchligthwork = findViewById(R.id.switch_ligth_work)
        switchabsence = findViewById(R.id.switch_absence)
        button = findViewById(R.id.button)
    }

    private fun mapearAcoesComponentes() {
        switchintense?.setOnCheckedChangeListener(this)
        switchmoderateeffort?.setOnCheckedChangeListener(this)
        switchintensework?.setOnCheckedChangeListener(this)
        switchmoderatework?.setOnCheckedChangeListener(this)
        switchligthwork?.setOnCheckedChangeListener(this)
        switchabsence?.setOnCheckedChangeListener(this)

        button?.setOnClickListener{
            if(eExercise != null) {
                heart!!.eExercise = eExercise

                val bundle = Bundle()
                bundle.putSerializable("RISK", heart!!)


                val intent = Intent(applicationContext, SmokerActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            } else {
                Toast.makeText(applicationContext, "Selecione uma faixa de exercício para continuar", Toast.LENGTH_LONG).show()
            }
        }

    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {

        if(isChecked) {
            lastButtonSelected = buttonView
            when (buttonView) {
                switchintense -> {
                    eExercise = EExercise.INTENSE_EFFOR
                    switchmoderateeffort?.isChecked = false
                    switchintensework?.isChecked = false
                    switchmoderatework?.isChecked = false
                    switchligthwork?.isChecked = false
                    switchabsence?.isChecked = false
                }
                switchmoderateeffort -> {
                    eExercise = EExercise.MODERATE_EFFOR
                    switchintense?.isChecked = false
                    switchintensework?.isChecked = false
                    switchmoderatework?.isChecked = false
                    switchligthwork?.isChecked = false
                    switchabsence?.isChecked = false
                }
                switchintensework -> {
                    eExercise = EExercise.INTENSE_WORK
                    switchmoderateeffort?.isChecked = false
                    switchintense?.isChecked = false
                    switchmoderatework?.isChecked = false
                    switchligthwork?.isChecked = false
                    switchabsence?.isChecked = false
                }
                switchmoderatework -> {
                    eExercise = EExercise.MODERATE_WORK
                    switchmoderateeffort?.isChecked = false
                    switchintensework?.isChecked = false
                    switchintense?.isChecked = false
                    switchligthwork?.isChecked = false
                    switchabsence?.isChecked = false
                }
                switchligthwork  -> {
                    eExercise = EExercise.LIGTH_WORK
                    switchmoderateeffort?.isChecked = false
                    switchintensework?.isChecked = false
                    switchmoderatework?.isChecked = false
                    switchintense?.isChecked = false
                    switchabsence?.isChecked = false
                }
                switchabsence -> {
                    eExercise = EExercise.ABSENCE
                    switchmoderateeffort?.isChecked = false
                    switchintensework?.isChecked = false
                    switchmoderatework?.isChecked = false
                    switchligthwork?.isChecked = false
                    switchintense?.isChecked = false
                }
            }
        } else {
            if(buttonView == lastButtonSelected && !isChecked) {
                eExercise = null
            }
        }
    }


}