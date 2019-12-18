package id.co.iconpln.controlflowapp.bottomSheetDialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.co.iconpln.controlflowapp.R
import kotlinx.android.synthetic.main.activity_bottom_sheet.*

class BottomSheetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_sheet)

        setupActionBar()
    }

    private fun setupActionBar() {
        setSupportActionBar(toolbar)
    }
}
