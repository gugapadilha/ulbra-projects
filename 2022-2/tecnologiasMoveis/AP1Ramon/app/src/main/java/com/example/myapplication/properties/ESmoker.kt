package com.example.myapplication.properties

import java.io.Serializable

// Seralizable serve para serializar a classe para enviar po bundle.
enum class ESmoker(var note: Int, var description: String) : Serializable {

    SMOKER(0, "Não fumante"),
    CIGAR(1, "Charuto e/ou cachimbo"),
    CIGARETTE10(2, "10 cigarros ou menos por dia"),
    CIGARETTE11(4, "11 a 20 cigarros por dia"),
    CIGARETTE21(6, "21 a 30 cigarros por dia"),
    CIGARETTE31(10, "mais de 31 cigarros por dia");

    companion object {
        fun getEnum(aCod: Int): ESmoker {
            for (lSituacao in values()) {
                if (lSituacao.note == aCod) {
                    return lSituacao
                }
            }
            return CIGAR
        }

        fun getEnum(descricao: String?): ESmoker {
            for (lSituacao in values()) {
                if (lSituacao.description.equals(descricao, ignoreCase = true)) {
                    return lSituacao
                }
            }
            return CIGAR
        }
    }

}