package com.example.myapplication.properties

import java.io.Serializable

// Seralizable serve para serializar a classe para enviar po bundle.
enum class EExercise(var note: Int, var description: String) : Serializable {

    INTENSE_EFFOR(1, "Esforço profissional e recreativo intenso"),
    MODERATE_EFFOR(2, "Esforço profissional e recreativo moderado"),
    INTENSE_WORK(3, "Trabalho sedentário e esforço recreativo intenso"),
    MODERATE_WORK(5, "Trabalho sedentário e esforço recreativo moderado"),
    LIGTH_WORK(6, "Trabalho sedentário e esforço recreativo leve"),
    ABSENCE(8, "Ausência completa de qualquer exercício");

    companion object {
        fun getEnum(aCod: Int): EExercise {
            for (lSituacao in values()) {
                if (lSituacao.note == aCod) {
                    return lSituacao
                }
            }
            return INTENSE_EFFOR
        }

        fun getEnum(descricao: String?): EExercise {
            for (lSituacao in values()) {
                if (lSituacao.description.equals(descricao, ignoreCase = true)) {
                    return lSituacao
                }
            }
            return INTENSE_EFFOR
        }
    }

}