package id.co.iconpln.controlflowapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import id.co.iconpln.controlflowapp.databinding.ActivityIntentBinding
import id.co.iconpln.controlflowapp.model.Person

class IntentActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityIntentBinding

    private val REQUEST_CODE = 110;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityIntentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setClickListener()
    }

    private fun setClickListener() {
        binding.btnMoveActivity.setOnClickListener(this)
        binding.btnMoveActivityData.setOnClickListener(this)
        binding.btnMoveActivityDataBundle.setOnClickListener(this)
        binding.btnMoveActivityObject.setOnClickListener(this)
        binding.btnDialNumber.setOnClickListener(this)
        binding.btnOpenWeb.setOnClickListener(this)
        binding.btnSendSms.setOnClickListener(this)
        binding.btnShowMap.setOnClickListener(this)
        binding.btnShareText.setOnClickListener(this)
        binding.btnMoveForResult.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view) {
            binding.btnMoveActivity -> {
                val moveIntent = Intent(this, StyleActivity::class.java)
                startActivity(moveIntent)
            }

            binding.btnMoveActivityData -> {
                val moveIntentWithData = Intent(this, IntentMoveDataActivity::class.java)
                moveIntentWithData.putExtra(IntentMoveDataActivity.EXTRA_NAME, "Fatimazza")
                moveIntentWithData.putExtra(IntentMoveDataActivity.EXTRA_AGE, 17)
                startActivity(moveIntentWithData)
            }

            binding.btnMoveActivityDataBundle -> {
                val moveIntentWithBundle = Intent(this, IntentMoveBundle::class.java)
                val bundle = Bundle()
                bundle.putString(IntentMoveBundle.EXTRA_BUNDLE_NAME, "Izza Kece")
                bundle.putInt(IntentMoveBundle.EXTRA_BUNDLE_AGE, 27)
                moveIntentWithBundle.putExtras(bundle)
                startActivity(moveIntentWithBundle)
            }

            binding.btnMoveActivityObject -> {
                val person = Person("Izza", 27, "mail@gmail.com", "Yogya")
                val moveIntentWithObject = Intent(this, IntentMoveObjectActivity::class.java)
                moveIntentWithObject.putExtra(IntentMoveObjectActivity.EXTRA_PERSON, person)
                startActivity(moveIntentWithObject)
            }

            binding.btnDialNumber -> {
                val phoneNumber = "081234567890"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                if (dialPhoneIntent.resolveActivity(packageManager) != null) {
                    startActivity(dialPhoneIntent)
                }
            }

            binding.btnOpenWeb -> {
                val webpage = Uri.parse("https://www.binar.co.id/")
                val openWebIntent = Intent(Intent.ACTION_VIEW, webpage)
                if (openWebIntent.resolveActivity(packageManager) != null) {
                    startActivity(openWebIntent)
                }
            }

            binding.btnSendSms -> {
                val phonenumber = "08123456789"
                val sendSms = Uri.parse("smsto: $phonenumber")
                val message = "Halo, Ini Izza kece"

                val sendSmsIntent = Intent(Intent.ACTION_SENDTO, sendSms)
                sendSmsIntent.putExtra("sms_body", message)

                if (sendSmsIntent.resolveActivity(packageManager) != null) {
                    startActivity(sendSmsIntent)
                }
            }

            binding.btnShowMap -> {
                val latitude = "47.6"
                val longitude = "-122.3"
                val showMap = Uri.parse("geo: $latitude, $longitude")

                val showMapIntent = Intent(Intent.ACTION_VIEW, showMap)
                if (showMapIntent.resolveActivity(packageManager) != null) {
                    startActivity(showMapIntent)
                }
            }

            binding.btnShareText -> {
                val sharedText = "Ini Teks yang akan di share"
                val shareTextIntent = Intent(Intent.ACTION_SEND)
                shareTextIntent.putExtra(Intent.EXTRA_TEXT, sharedText)
                shareTextIntent.type = "text/plain"

                val shareIntent = Intent.createChooser(shareTextIntent, null)
                startActivity(shareIntent)
            }

            binding.btnMoveForResult -> {
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
                binding.tvIntentResult.text = "Hasilnya $selectedValue"
            }
        }
    }
}
