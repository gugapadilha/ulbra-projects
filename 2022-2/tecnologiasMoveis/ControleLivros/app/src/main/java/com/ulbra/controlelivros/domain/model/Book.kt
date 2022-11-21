package com.ulbra.controlelivros.domain.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.io.Serializable
import java.util.*

open class Book (
    @PrimaryKey
    var _id : Int? = 0,
    var descricao : String? = null,
    var title : String? = null,
    var author : String? = null,
    var isbn: String? = null,
    var dataRegiter : Date? = null,
    var totalPages: Int? = null,
    var pagesRead: Int? = null,
    var isRead: Boolean? = false
) : RealmObject(), Serializable