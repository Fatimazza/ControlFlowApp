package id.co.iconpln.controlflowapp.bottomSheetDialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import id.co.iconpln.controlflowapp.databinding.ActivityBottomSheetBinding
import id.co.iconpln.controlflowapp.databinding.FragmentBottomSheetBinding


class BottomSheetActivity :
    AppCompatActivity(), View.OnClickListener, BottomSheetFragment.ItemClickListener {

    private lateinit var binding: ActivityBottomSheetBinding

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<View>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomSheetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupActionBar()
        setButtonClickListener()
        setupBottomSheetBehavior()
    }

    private fun setupBottomSheetBehavior() {
        bottomSheetBehavior = BottomSheetBehavior
            .from(binding.llBottomSheet.llBottomSheet)
        bottomSheetBehavior.setBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(view: View, slideOffset: Float) {

            }

            override fun onStateChanged(view: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        binding.llMain.btnBottomSheet.text = "Expand Bottom Sheet"
                    }

                    BottomSheetBehavior.STATE_DRAGGING -> {}
                    BottomSheetBehavior.STATE_EXPANDED -> {
                        binding.llMain.btnBottomSheet.text = "Close Bottom Sheet"
                    }

                    BottomSheetBehavior.STATE_HALF_EXPANDED -> {}
                    BottomSheetBehavior.STATE_HIDDEN -> {}
                    BottomSheetBehavior.STATE_SETTLING -> {}
                }
            }
        })
    }

    private fun setupActionBar() {
        setSupportActionBar(binding.toolbar)
    }

    private fun setButtonClickListener() {
        binding.llMain.btnBottomSheet.setOnClickListener(this)
        binding.llMain.btnBottomSheetDialog.setOnClickListener(this)
        binding.llMain.btnBottomSheetDialogFragment.setOnClickListener(this)
        binding.llBottomSheet.btnBottomSheetPayment.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view) {
            binding.llMain.btnBottomSheet -> {
                if (bottomSheetBehavior.state != BottomSheetBehavior.STATE_EXPANDED) {
                    bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED;
                    binding.llMain.btnBottomSheet.text = "Close Bottom Sheet";
                } else {
                    bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED;
                    binding.llMain.btnBottomSheet.text = "Expand Bottom Sheet";
                }

            }

            binding.llMain.btnBottomSheetDialog -> {
                val dialogBinding = FragmentBottomSheetBinding.inflate(layoutInflater)
                val bottomSheetDialog = BottomSheetDialog(this)

                bottomSheetDialog.setContentView(dialogBinding.root)
                bottomSheetDialog.show()
                setDialogClickListener(dialogBinding)
            }

            binding.llMain.btnBottomSheetDialogFragment -> {
                val bottomSheetFragment = BottomSheetFragment()
                bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
            }

            binding.llBottomSheet.btnBottomSheetPayment -> {
                binding.llMain.tvBottomActivity.text = "Order is Paid"
            }
        }
    }

    private fun setDialogClickListener(binding: FragmentBottomSheetBinding) {
        binding.llBottomPreview.setOnClickListener {
            onItemClick("Dialog - ${binding.tvBottomPreview.text}")
        }
        binding.llBottomShare.setOnClickListener {
            onItemClick("Dialog - ${binding.tvBottomShare.text}")
        }
        binding.llBottomEdit.setOnClickListener {
            onItemClick("Dialog - ${binding.tvBottomEdit.text}")
        }
        binding.llBottomSearch.setOnClickListener {
            onItemClick("Dialog - ${binding.tvBottomSearch.text}")
        }
        binding.llBottomExit.setOnClickListener {
            onItemClick("Dialog - ${binding.tvBottomExit.text}")
        }
    }

    override fun onItemClick(text: String) {
        binding.llMain.tvBottomActivity.text = text
    }
}
