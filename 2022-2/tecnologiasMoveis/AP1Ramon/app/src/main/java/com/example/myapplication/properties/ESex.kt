package com.example.myapplication.properties

import java.io.Serializable

// Seralizable serve para serializar a classe para enviar po bundle.
enum class ESex(var note: Int, var description: String) : Serializable {

    FEMALE40(1, "Feminino C/ menos de 40 anos"),
    FEMALE40_50(2, "Feminino de 40 a 50 anos"),
    FEMALE_PLUS_50(3, "Feminino C/ 50 anos"),
    MALE(4, "Masculino"),
    MALE_LOW(6, "Masculino de baixa estatura"),
    MALE_LOW_BALD(7, "Masculino de baixa estatura e calvo");

    companion object {
        fun getEnum(aCod: Int): ESex {
            for (lSituacao in values()) {
                if (lSituacao.note == aCod) {
                    return lSituacao
                }
            }
            return FEMALE40
        }

        fun getEnum(descricao: String?): ESex {
            for (lSituacao in values()) {
                if (lSituacao.description.equals(descricao, ignoreCase = true)) {
                    return lSituacao
                }
            }
            return FEMALE40
        }
    }

}