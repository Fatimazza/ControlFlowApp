package id.co.iconpln.controlflowapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.co.iconpln.controlflowapp.databinding.ActivityIntentMoveObjectBinding
import id.co.iconpln.controlflowapp.model.Person

class IntentMoveObjectActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntentMoveObjectBinding

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityIntentMoveObjectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showData()
    }

    private fun showData() {
        val person = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Person>(EXTRA_PERSON, Person::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Person>(EXTRA_PERSON)
        }

        if (person != null) {
            val text =
                "Name : ${person.name},\nEmail : ${person.email},\nAge : ${person.age},\nLocation : ${person.city}"
            binding.tvObjectReceived.text = text
        }
    }
}
