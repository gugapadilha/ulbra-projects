package com.ulbra.controlelivros.presentation.ui.finished

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.ulbra.controlelivros.R
import com.ulbra.controlelivros.data.data_source.dao.BookDAO
import com.ulbra.controlelivros.databinding.FragmentFinishedBinding
import com.ulbra.controlelivros.domain.model.Book
import com.ulbra.controlelivros.domain.model.EOptions
import com.ulbra.controlelivros.utils.bottomsheet.BottomSheetOptions
import com.ulbra.controlelivros.presentation.ui.pages.ChangePageActivity
import com.ulbra.controlelivros.presentation.ui.reading.ReadingAdapter
import com.ulbra.controlelivros.presentation.ui.register.RegisterActivity

class FinishedBookFragment : Fragment(), ReadingAdapter.Listener, BottomSheetOptions.Callback {

    private var _binding: FragmentFinishedBinding? = null
    private val binding get() = _binding!!

    private var recyclerView : RecyclerView? = null
    private var mAdapter: ReadingAdapter? = null
    private var books : MutableList<Book>? = mutableListOf()
    private var textView: TextView? = null
    private var bottomSheetOptions: BottomSheetOptions? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFinishedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.rcBook
        textView = binding.textHome
    }

    fun showDisplayList() {
        recyclerView = binding.rcBook
        books = BookDAO.loadAllRead()
        mAdapter = books?.let { ReadingAdapter(this, it) }
        recyclerView?.adapter = mAdapter
        showMsm()
    }

    fun showMsm() {
        if(books!!.isEmpty()) {
            textView?.text = getString(R.string.msm_read)
        } else {
            textView?.text = ""
        }
    }

    override fun onResume() {
        super.onResume()
        showDisplayList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun updateBook(book: Book){
        val bundle = Bundle()
        bundle.putBoolean("edit", true)
        bundle.putSerializable("book", book)
        val intent = Intent(activity, RegisterActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    fun updatePageBook(book: Book){
        val bundle = Bundle()
        bundle.putSerializable("book", book)
        val intent = Intent(activity, ChangePageActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    override fun onClick(optionMenuEnum: EOptions, book: Book) {
        when (optionMenuEnum) {
            EOptions.EDIT -> {
                updateBook(book)
            }
            EOptions.DELETE -> {
                book._id?.let {
                    BookDAO.deleteById(it)
                    showDisplayList()
                }
            }
            EOptions.EDIT_PAGES -> {
                updatePageBook(book)
            }
        }
    }

    private fun showOptionList(book: Book) {
        bottomSheetOptions = BottomSheetOptions.newInstance(book)
        bottomSheetOptions?.let {
            activity?.let { it1 -> it.show(it1.supportFragmentManager, null) }
        }
        bottomSheetOptions?.setListener(this)
    }

    override fun onItemClick(aBook: Book?) {
        showOptionList(aBook!!)
    }
}