package id.co.iconpln.controlflowapp.bottomSheetDialog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import id.co.iconpln.controlflowapp.databinding.FragmentBottomSheetBinding


class BottomSheetFragment : BottomSheetDialogFragment(), View.OnClickListener {

    private var _binding: FragmentBottomSheetBinding? = null
    private val binding get() = _binding!!

    private var itemClickListener: ItemClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListener()
    }

    private fun setOnClickListener() {
        binding.llBottomPreview.setOnClickListener(this)
        binding.llBottomShare.setOnClickListener(this)
        binding.llBottomEdit.setOnClickListener(this)
        binding.llBottomSearch.setOnClickListener(this)
        binding.llBottomExit.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view) {
            binding.llBottomPreview -> {
                if (itemClickListener != null) {
                    itemClickListener?.onItemClick(binding.tvBottomPreview.text.toString())
                }
            }

            binding.llBottomShare -> {
                if (itemClickListener != null) {
                    itemClickListener?.onItemClick(binding.tvBottomShare.text.toString())
                }
            }

            binding.llBottomEdit -> {
                if (itemClickListener != null) {
                    itemClickListener?.onItemClick(binding.tvBottomEdit.text.toString())
                }
            }

            binding.llBottomSearch -> {
                if (itemClickListener != null) {
                    itemClickListener?.onItemClick(binding.tvBottomSearch.text.toString())
                }
            }

            binding.llBottomExit -> {
                if (itemClickListener != null) {
                    itemClickListener?.onItemClick(binding.tvBottomExit.text.toString())
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

    // Clean up binding to prevent memory leaks
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
