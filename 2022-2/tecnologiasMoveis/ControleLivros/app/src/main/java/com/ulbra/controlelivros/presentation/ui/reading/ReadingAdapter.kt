package com.ulbra.controlelivros.presentation.ui.reading

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ulbra.controlelivros.R
import com.ulbra.controlelivros.domain.model.Book
import com.ulbra.controlelivros.utils.DateUtil


class ReadingAdapter(var listener: Listener, aBooks: MutableList<Book>) :
    RecyclerView.Adapter<ReadingAdapter.ViewHolder>() {

    private val mData: MutableList<Book>
    private var mContext: Context? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val lViewInflated: View = LayoutInflater.from(parent.context).inflate(R.layout.row_book, parent, false)
        return ViewHolder(lViewInflated)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val lBook: Book = mData[position]
        bindData(holder, lBook, position)
        holder.itemView.tag = lBook
        holder.itemView.setOnClickListener {
            listener.onItemClick(lBook)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun bindData(aHolder: ViewHolder, aBook: Book, position: Int) {
        aHolder.mType.text = aBook.title
        aHolder.mDescricao.text = aBook.descricao
        aHolder.mHoraWhy.text = DateUtil.dataFormat("HH:mm", aBook.dataRegiter!!)
        aHolder.mDataHoraFim.text = DateUtil.dataFormat("dd/MM/yyyy", aBook.dataRegiter!!)
        aHolder.mTextPages.text = "${aBook.pagesRead}/${aBook.totalPages}"
    }

    interface Listener {
        fun onItemClick(aBook: Book?)
    }

    inner class ViewHolder(aItemView: View) : RecyclerView.ViewHolder(aItemView) {
        var mType: TextView
        var mHoraWhy: TextView
        var mDescricao: TextView
        var mDataHoraFim: TextView
        var imageLineUp: View
        var imageLineDown: View
        var imageViewCircle : ImageView
        var mTextPages: TextView

        init {
            mType = aItemView.findViewById(R.id.label_txt_title)
            mHoraWhy = aItemView.findViewById(R.id.txt_hora_why)
            mDescricao = aItemView.findViewById(R.id.txt_descricao)
            mDataHoraFim = aItemView.findViewById(R.id.txt_data_hora_fim)
            imageLineUp  = aItemView.findViewById(R.id.view_linha_up)
            imageLineDown  = aItemView.findViewById(R.id.view_linha_down)
            imageViewCircle = aItemView.findViewById(R.id.img_circulo)
            mTextPages = aItemView.findViewById(R.id.txt_pages)
        }
    }

    init {
        mData = aBooks
    }
}