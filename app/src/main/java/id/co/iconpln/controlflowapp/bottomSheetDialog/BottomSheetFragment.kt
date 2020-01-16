package id.co.iconpln.controlflowapp.bottomSheetDialog


import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

import id.co.iconpln.controlflowapp.R
import kotlinx.android.synthetic.main.fragment_bottom_sheet.*

/**
 * A simple [Fragment] subclass.
 */
class BottomSheetFragment : BottomSheetDialogFragment(), View.OnClickListener {

    private var itemClickListener: ItemClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListener()
    }

    private fun setOnClickListener() {
        llBottomPreview.setOnClickListener(this)
        llBottomShare.setOnClickListener(this)
        llBottomEdit.setOnClickListener(this)
        llBottomSearch.setOnClickListener(this)
        llBottomExit.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            llBottomPreview.id -> {
                if (itemClickListener != null) {
                    itemClickListener?.onItemClick(tvBottomPreview.text.toString())
                }
            }
            llBottomShare.id -> {
                if (itemClickListener != null) {
                    itemClickListener?.onItemClick(tvBottomShare.text.toString())
                }
            }
            llBottomEdit.id -> {
                if (itemClickListener != null) {
                    itemClickListener?.onItemClick(tvBottomEdit.text.toString())
                }
            }
            llBottomSearch.id -> {
                if (itemClickListener != null) {
                    itemClickListener?.onItemClick(tvBottomSearch.text.toString())
                }
            }
            llBottomExit.id -> {
                if (itemClickListener != null) {
                    itemClickListener?.onItemClick(tvBottomExit.text.toString())
                }
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is ItemClickListener) {
            this.itemClickListener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        this.itemClickListener = null
    }

    interface ItemClickListener {
        fun onItemClick(text: String)
    }

}
