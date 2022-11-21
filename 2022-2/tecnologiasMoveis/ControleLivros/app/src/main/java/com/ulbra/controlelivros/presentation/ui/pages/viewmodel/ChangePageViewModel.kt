package com.ulbra.controlelivros.presentation.ui.pages.viewmodel

import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.ulbra.controlelivros.data.data_source.dao.BookDAO
import com.ulbra.controlelivros.databinding.ActivityChangePageBinding
import com.ulbra.controlelivros.domain.model.Book
import com.ulbra.controlelivros.presentation.ui.pages.ChangePageActivity
import java.util.*

class ChangePageViewModel() : ViewModel() {

    private lateinit var binding: ActivityChangePageBinding
    var mBook: Book? = null
    var isEdit: Boolean = false


    fun createBook(totalPages : Int, pagesRead: Int) {
        mBook?.dataRegiter = Date()
        mBook?.totalPages = totalPages
        mBook?.pagesRead = pagesRead
        mBook?.isRead = totalPages == pagesRead
    }
}