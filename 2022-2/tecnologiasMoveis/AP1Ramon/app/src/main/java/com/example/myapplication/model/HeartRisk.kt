package com.example.myapplication.model

import com.example.myapplication.properties.*
import java.io.Serializable

class HeartRisk :  Serializable {
    var eAge : EAge? = null
    var eSex: ESex? = null
    var ePesos: EPesos? = null
    var eExercise: EExercise? = null
    var eSmoker: ESmoker? = null
    var ePressure: EPressure? = null
    var eHistoric: EHistoric? = null
    var eCholesterol: ECholesterol? = null


    fun sum() : Int {
        return eAge!!.note + eSex!!.note +ePesos!!.note + eExercise!!.note + eSmoker!!.note + ePressure!!.note + eHistoric!!.note + eCholesterol!!.note
    }
}

/*1 - Sem risco - de 6 a 11
2 - Risco abaixo da média - de 12 a 17
3 - Risco médio - de 18 a 24
4 - Risco moderado - de 25 a 31
5 - Risco alto - de 32 a 40
6 - Risco muito alto - 41 a 62*/