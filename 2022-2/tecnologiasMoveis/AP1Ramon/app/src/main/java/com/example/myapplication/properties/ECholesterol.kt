package com.example.myapplication.properties

import java.io.Serializable

// Seralizable serve para serializar a classe para enviar po bundle.
enum class ECholesterol(var note: Int, var description: String) : Serializable {

    ABAIXO180(1, "Não fumante"),
    DE181(2, "Charuto e/ou cachimbo"),
    DE206(3, "10 cigarros ou menos por dia"),
    DE231(4, "11 a 20 cigarros por dia"),
    DE256(5, "21 a 30 cigarros por dia"),
    ACIMADE281(7, "mais de 31 cigarros por dia");

    companion object {
        fun getEnum(aCod: Int): ECholesterol {
            for (lSituacao in values()) {
                if (lSituacao.note == aCod) {
                    return lSituacao
                }
            }
            return ABAIXO180
        }

        fun getEnum(descricao: String?): ECholesterol {
            for (lSituacao in values()) {
                if (lSituacao.description.equals(descricao, ignoreCase = true)) {
                    return lSituacao
                }
            }
            return ABAIXO180
        }
    }

}