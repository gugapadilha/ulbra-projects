package com.example.myapplication.properties

import java.io.Serializable

// Seralizable serve para serializar a classe para enviar po bundle.
enum class EPressure(var note: Int, var description: String) : Serializable {

    SISTOLICA100(1, "Não fumante"),
    SISTOLICA120(2, "Charuto e/ou cachimbo"),
    SISTOLICA140(3, "10 cigarros ou menos por dia"),
    SISTOLICA160(4, "11 a 20 cigarros por dia"),
    SISTOLICA180(6, "21 a 30 cigarros por dia"),
    SISTOLICA200(8, "mais de 31 cigarros por dia");

    companion object {
        fun getEnum(aCod: Int): EPressure {
            for (lSituacao in values()) {
                if (lSituacao.note == aCod) {
                    return lSituacao
                }
            }
            return SISTOLICA100
        }

        fun getEnum(descricao: String?): EPressure {
            for (lSituacao in values()) {
                if (lSituacao.description.equals(descricao, ignoreCase = true)) {
                    return lSituacao
                }
            }
            return SISTOLICA100
        }
    }

}