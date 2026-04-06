package id.co.iconpln.controlflowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.co.iconpln.controlflowapp.databinding.ActivityIntentMoveObjectBinding
import id.co.iconpln.controlflowapp.model.Person

class IntentMoveObjectActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntentMoveObjectBinding

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    private lateinit var person: Person

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityIntentMoveObjectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getIntentExtras()
        showData()
    }

    private fun getIntentExtras() {
        person = intent.getParcelableExtra(EXTRA_PERSON) ?: Person()
    }

    private fun showData() {
        val text =
            "Name ${person.name}, \nAge ${person.age}, \nEmail ${person.email} \nCity ${person.city}"
        binding.tvObjectReceived.text = text
    }
}
