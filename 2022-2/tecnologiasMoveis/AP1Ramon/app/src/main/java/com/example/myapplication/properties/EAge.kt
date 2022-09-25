package com.example.myapplication.properties

import java.io.Serializable

// Seralizable serve para serializar a classe para enviar po bundle.
enum class EAge(var note: Int, var description: String) : Serializable {

    TEN_TO_TWENTY(1, "10 a 20 anos"),
    TWENTY_ONE_TO_THIRTY(2, "21 a 30 anos"),
    THIRTY_ONE_TO_FORTY(3, "31 a 40 anos"),
    FORTY_ONE_TO_FIFTY(4, "41 a 50 anos"),
    FIFTY_ONE_TO_SIXTY(6, "51 a 60 anos"),
    ABOVE_SIXTY(8, "Acima de 60");

    companion object {
        fun getEnum(aCod: Int): EAge {
            for (lSituacao in values()) {
                if (lSituacao.note == aCod) {
                    return lSituacao
                }
            }
            return TEN_TO_TWENTY
        }

        fun getEnum(descricao: String?): EAge {
            for (lSituacao in values()) {
                if (lSituacao.description.equals(descricao, ignoreCase = true)) {
                    return lSituacao
                }
            }
            return TEN_TO_TWENTY
        }
    }

}