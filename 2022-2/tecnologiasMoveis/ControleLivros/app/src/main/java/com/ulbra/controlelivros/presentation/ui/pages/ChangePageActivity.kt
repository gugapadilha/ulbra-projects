package com.ulbra.controlelivros.presentation.ui.pages

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ulbra.controlelivros.R
import com.ulbra.controlelivros.data.data_source.dao.BookDAO
import com.ulbra.controlelivros.databinding.ActivityChangePageBinding
import com.ulbra.controlelivros.domain.model.Book
import com.ulbra.controlelivros.presentation.ui.pages.viewmodel.ChangePageViewModel

class ChangePageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChangePageBinding

    private lateinit var changePageViewModel: ChangePageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangePageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setTitle(R.string.change_pages)
        changePageViewModel = ChangePageViewModel()
        mapActionComponent()
        showDiplayValues()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    private fun mapActionComponent() {
        binding.register.setOnClickListener {
            if(validateFileds()) {
                BookDAO.update(changePageViewModel.mBook!!)
                Toast.makeText(this, "Livro alterado com sucesso!", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }

    private fun showDiplayValues() {
        val bundle = intent.extras
        bundle?.let {
            changePageViewModel.mBook = it.getSerializable("book") as Book?
            binding.editTextTotalPages.setText(changePageViewModel.mBook?.totalPages.toString())
            binding.editTextPagesRead.setText(changePageViewModel.mBook?.pagesRead.toString())
            binding.register.text = "update"
        }
    }


    private fun validateFileds(): Boolean {
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

        changePageViewModel.createBook(binding.editTextTotalPages.text.toString().toInt(), binding.editTextPagesRead.text.toString().toInt())
        return true
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}