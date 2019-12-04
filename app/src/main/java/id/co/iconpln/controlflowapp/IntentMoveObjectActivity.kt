package id.co.iconpln.controlflowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.co.iconpln.controlflowapp.model.Person
import kotlinx.android.synthetic.main.activity_intent_move_object.*

class IntentMoveObjectActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    private var person = Person()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_move_object)

        getIntentExtras()
        showData()
    }

    private fun getIntentExtras() {
        // person = intent.getParcelableExtra<Person>(EXTRA_PERSON)
    }

    private fun showData() {
        val text =
            "Name ${person.name}, \nAge ${person.age}, \nEmail ${person.email} \nCity ${person.city}"
        tvObjectReceived.text = text
    }
}
