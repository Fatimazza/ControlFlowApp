package id.co.iconpln.controlflowapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import id.co.iconpln.controlflowapp.model.Person
import kotlinx.android.synthetic.main.activity_intent.*

class IntentActivity : AppCompatActivity(), View.OnClickListener {

    private val REQUEST_CODE = 110;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        btnMoveActivity.setOnClickListener(this)
        btnMoveActivityData.setOnClickListener(this)
        btnMoveActivityDataBundle.setOnClickListener(this)
        btnMoveActivityObject.setOnClickListener(this)
        btnDialNumber.setOnClickListener(this)
        btnOpenWeb.setOnClickListener(this)
        btnSendSms.setOnClickListener(this)
        btnShowMap.setOnClickListener(this)
        btnShareText.setOnClickListener(this)
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
                if (dialPhoneIntent.resolveActivity(packageManager) != null) {
                    startActivity(dialPhoneIntent)
                }
            }
            R.id.btnOpenWeb -> {
                val webpage = Uri.parse("https://www.binar.co.id/")
                val openWebIntent = Intent(Intent.ACTION_VIEW, webpage)
                if (openWebIntent.resolveActivity(packageManager) != null) {
                    startActivity(openWebIntent)
                }
            }
            R.id.btnSendSms -> {
                val phonenumber = "08123456789"
                val sendSms = Uri.parse("smsto: $phonenumber")
                val message = "Halo, Ini Izza kece"

                val sendSmsIntent = Intent(Intent.ACTION_SENDTO, sendSms)
                sendSmsIntent.putExtra("sms_body", message)

                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(sendSmsIntent)
                }
            }
            R.id.btnShowMap -> {
                val latitude = "47.6"
                val longitude = "-122.3"
                val showMap = Uri.parse("geo: $latitude, $longitude")

                val showMapIntent = Intent(Intent.ACTION_VIEW, showMap)
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(showMapIntent)
                }
            }
            R.id.btnShareText -> {
                val sharedText = "Ini Teks yang akan di share"
                val shareTextIntent = Intent(Intent.ACTION_SEND)
                shareTextIntent.putExtra(Intent.EXTRA_TEXT, sharedText)
                shareTextIntent.type = "text/plain"

                val shareIntent = Intent.createChooser(shareTextIntent, null)
                startActivity(shareIntent)
            }
            R.id.btnMoveForResult -> {
                val moveIntentForResult = Intent(this, IntentMoveResultActivity::class.java)
                startActivityForResult(moveIntentForResult, REQUEST_CODE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE) {
            if (resultCode == IntentMoveResultActivity.RESULT_CODE) {
                val selectedValue = data?.getIntExtra(IntentMoveResultActivity.EXTRA_VALUE, 0)
                tvIntentResult.text = "Hasilnya $selectedValue"
            }
        }
    }
}
