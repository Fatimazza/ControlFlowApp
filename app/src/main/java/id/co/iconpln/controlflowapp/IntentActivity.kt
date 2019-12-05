package id.co.iconpln.controlflowapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import id.co.iconpln.controlflowapp.model.Person
import kotlinx.android.synthetic.main.activity_intent.*

class IntentActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        btnMoveActivity.setOnClickListener(this)
        btnMoveActivityData.setOnClickListener(this)
        btnMoveActivityDataBundle.setOnClickListener(this)
        btnMoveActivityObject.setOnClickListener(this)
        btnDialNumber.setOnClickListener(this)
        btnMoveForResult.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        when(view.id) {
            R.id.btnMoveActivity -> {
                val moveIntent = Intent(this, StyleActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.btnMoveActivityData -> {
                val moveIntentWithData = Intent(this, IntentMoveDataActivity::class.java)
                moveIntentWithData.putExtra(IntentMoveDataActivity.EXTRA_NAME, "Fatimazza")
                moveIntentWithData.putExtra(IntentMoveDataActivity.EXTRA_AGE, 17)
                startActivity(moveIntentWithData)
            }
            R.id.btnMoveActivityDataBundle -> {
                val moveIntentWithBundle = Intent(this, IntentMoveBundle::class.java)
                val bundle = Bundle()
                bundle.putString(IntentMoveBundle.EXTRA_BUNDLE_NAME, "Izza Kece")
                bundle.putInt(IntentMoveBundle.EXTRA_BUNDLE_AGE, 27)
                moveIntentWithBundle.putExtras(bundle)
                startActivity(moveIntentWithBundle)
            }
            R.id.btnMoveActivityObject -> {
                val person = Person("Izza", 27, "mail@gmail.com", "Yogya")
                val moveIntentWithObject = Intent(this, IntentMoveObjectActivity::class.java)
                moveIntentWithObject.putExtra(IntentMoveObjectActivity.EXTRA_PERSON, person)
                startActivity(moveIntentWithObject)
            }
            R.id.btnDialNumber -> {
                val phoneNumber = "081234567890"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
            R.id.btnMoveForResult -> {

            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        
    }
}
