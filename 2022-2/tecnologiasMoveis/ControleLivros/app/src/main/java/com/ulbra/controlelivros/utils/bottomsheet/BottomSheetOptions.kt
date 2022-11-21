package com.ulbra.controlelivros.utils.bottomsheet

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.buffalo.controlefinancas.util.MapElement
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.ulbra.controlelivros.R
import com.ulbra.controlelivros.domain.model.Book
import com.ulbra.controlelivros.domain.model.EOptions

class BottomSheetOptions(var book: Book) : BottomSheetDialogFragment(), MapElement {

    private var mEdit: View? = null
    private var mDelete: View? = null
    private var mEditPages: View? = null
    private var mCallback: Callback? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val lContextThemeWrapper: Context = androidx.appcompat.view.ContextThemeWrapper(
            activity, R.style.Theme_ControleLivros
        )
        return inflater.cloneInContext(lContextThemeWrapper)
            .inflate(R.layout.botton_sheet_options, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mapComponents()
        mapActionComponents()
        super.onViewCreated(view, savedInstanceState)
    }

    override fun mapActionComponents() {
        mEditPages?.setOnClickListener {
            mCallback?.onClick(EOptions.EDIT_PAGES, book)
            dismissAllowingStateLoss()
        }
        mEdit?.setOnClickListener {
            mCallback?.onClick(EOptions.EDIT, book)
            dismissAllowingStateLoss()
        }
        mDelete?.setOnClickListener {
            mCallback?.onClick(EOptions.DELETE, book)
            dismissAllowingStateLoss()
        }
    }

    override fun mapComponents() {
        mEdit = requireView().findViewById(R.id.tv_edit)
        mDelete = requireView().findViewById(R.id.tv_delete)
        mEditPages = requireView().findViewById(R.id.tv_edit_pages)
    }

    fun setListener(aListener: Callback) {
        mCallback = aListener
    }

    interface Callback {
        fun onClick(optionMenuEnum: EOptions, book : Book)
    }

    companion object {
        fun newInstance(expense : Book): BottomSheetOptions {
            return BottomSheetOptions(expense)
        }
    }
}
