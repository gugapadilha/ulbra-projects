package com.example.myapplication.properties

import java.io.Serializable

// Seralizable serve para serializar a classe para enviar po bundle.
enum class EPesos(var note: Int, var description: String) : Serializable {

    PESO1(0, "Inferior a 2,3Kg do peso norma"),
    MENO2(1, "Menos de 2,3 a mais de 2,3Kg do peso normal"),
    DE9(2, "Menos de 2,3 a mais de 2,3Kg do peso normal"),
    DE15(3, "Menos de 2,3 a mais de 2,3Kg do peso normal"),
    DE22(5, "De 16 a 22,9Kg acima do peso normal"),
    ACIMA25(7, "Mais de 23Kg acima do peso normal");

    companion object {
        fun getEnum(aCod: Int): EPesos {
            for (lSituacao in values()) {
                if (lSituacao.note == aCod) {
                    return lSituacao
                }
            }
            return PESO1
        }

        fun getEnum(descricao: String?): EPesos {
            for (lSituacao in values()) {
                if (lSituacao.description.equals(descricao, ignoreCase = true)) {
                    return lSituacao
                }
            }
            return PESO1
        }
    }

}