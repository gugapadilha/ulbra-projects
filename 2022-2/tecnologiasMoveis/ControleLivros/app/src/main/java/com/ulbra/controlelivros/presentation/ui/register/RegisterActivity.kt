package com.ulbra.controlelivros.presentation.ui.register

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ulbra.controlelivros.R
import com.ulbra.controlelivros.data.data_source.dao.BookDAO
import com.ulbra.controlelivros.databinding.ActivityRegisterBinding
import com.ulbra.controlelivros.domain.model.Book
import java.util.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private var mBook: Book? = null
    private var isEdit: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setTitle(R.string.register_book)
        mapActionComponent()
        showDiplayValues()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    private fun showDiplayValues() {
        val bundle = intent.extras
        bundle?.let {
            mBook = it.getSerializable("book") as Book?
            isEdit = it.getBoolean("edit", true)
            binding.editTextTitle.setText(mBook?.title)
            binding.editTextAuthor.setText(mBook?.author)
            binding.editTextDescription.setText(mBook?.descricao)
            binding.editTextTotalPages.setText(mBook?.totalPages.toString())
            binding.editTextPagesRead.setText(mBook?.pagesRead.toString())
            binding.editTextIsbn.setText(mBook?.isbn.toString())
            binding.register.text = getString(R.string.update)
        }
    }

    private fun mapActionComponent() {
        binding.register.setOnClickListener {
            if(validateFileds()) {
                if(!isEdit) {
                    BookDAO.save(mBook!!)
                    Toast.makeText(this, "Livro registrado com sucesso!", Toast.LENGTH_SHORT).show()
                } else {
                    BookDAO.update(mBook!!)
                    Toast.makeText(this, "Livro alterado com sucesso!", Toast.LENGTH_SHORT).show()
                }
                finish()
            }
        }
    }

    private fun validateFileds(): Boolean {
        if(binding.editTextTitle.text!!.isEmpty()) {
            Toast.makeText(this, "Informe o título", Toast.LENGTH_SHORT).show()
            return false
        }

        if(binding.editTextAuthor.text!!.isEmpty()) {
            Toast.makeText(this, "Informe o autor", Toast.LENGTH_SHORT).show()
            return false
        }

        if(binding.editTextDescription.text!!.isEmpty()) {
            Toast.makeText(this, "Informe a descrição", Toast.LENGTH_SHORT).show()
            return false
        }

        if(binding.editTextTotalPages.text!!.isEmpty()) {
            Toast.makeText(this, "Informe o total de páginas", Toast.LENGTH_SHORT).show()
            return false
        }

        if(binding.editTextTotalPages.text.toString().toInt() <= 1) {
            Toast.makeText(this, "Informe o número de páginas corretamente", Toast.LENGTH_SHORT).show()
            return false
        }

        if(binding.editTextPagesRead.text!!.isEmpty()) {
            Toast.makeText(this, "Informe as páginas lidas", Toast.LENGTH_SHORT).show()
            return false
        }

        if(binding.editTextPagesRead.text.toString().toInt() > binding.editTextTotalPages.text.toString().toInt()) {
            Toast.makeText(this, "Informe o número de páginas lidas corretamente", Toast.LENGTH_SHORT).show()
            return false
        }

        if(binding.editTextIsbn.text!!.isEmpty()) {
            Toast.makeText(this, "Informe o ISBN", Toast.LENGTH_SHORT).show()
            return false
        }

        createBook()
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun createBook() {
        if (mBook == null) {
            mBook = Book()
        }
        mBook?.descricao = binding.editTextDescription.text.toString()
        mBook?.title = binding.editTextTitle.text.toString()
        mBook?.author = binding.editTextAuthor.text.toString()
        mBook?.isbn = binding.editTextIsbn.text.toString()
        mBook?.dataRegiter = Date()
        mBook?.totalPages = binding.editTextTotalPages.text.toString().toInt()
        mBook?.pagesRead = binding.editTextPagesRead.text.toString().toInt()
        mBook?.isRead = binding.editTextTotalPages.text.toString().toInt() == binding.editTextPagesRead.text.toString().toInt()
    }

}