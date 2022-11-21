package com.ulbra.controlelivros.domain.model

enum class EOptions(var codigo: Int, var descricao: String) {
    EDIT(0, "Editar"),
    DELETE(1, "Remover"),
    EDIT_PAGES(2, "Alterar Páginas");

    companion object {
        fun getEnun(aCod: Int): EOptions {
            for (lSituacao in values()) {
                if (lSituacao.codigo == aCod) {
                    return lSituacao
                }
            }
            return EDIT_PAGES
        }

        fun getEnun(descricao: String?): EOptions {
            for (lSituacao in values()) {
                if (lSituacao.descricao.equals(descricao, ignoreCase = true)) {
                    return lSituacao
                }
            }
            return EDIT_PAGES
        }
    }

}