package com.example.myapplication.properties

import java.io.Serializable

// Seralizable serve para serializar a classe para enviar po bundle.
enum class EHistoric(var note: Int, var description: String) : Serializable {

    NOHISTORIC(1, "Não fumante"),
    HISTORIC1(2, "Charuto e/ou cachimbo"),
    HISTORIC2(3, "10 cigarros ou menos por dia"),
    LOWHISTORIC1(4, "11 a 20 cigarros por dia"),
    LOWHISTORIC2(6, "21 a 30 cigarros por dia"),
    LOWHISTORIC3(7, "mais de 31 cigarros por dia");

    companion object {
        fun getEnum(aCod: Int): EHistoric {
            for (lSituacao in values()) {
                if (lSituacao.note == aCod) {
                    return lSituacao
                }
            }
            return HISTORIC1
        }

        fun getEnum(descricao: String?): EHistoric {
            for (lSituacao in values()) {
                if (lSituacao.description.equals(descricao, ignoreCase = true)) {
                    return lSituacao
                }
            }
            return HISTORIC1
        }
    }

}