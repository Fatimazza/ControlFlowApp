package id.co.iconpln.controlflowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import kotlinx.android.synthetic.main.activity_localization.*

class LocalizationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_localization)

        displayLocalizedTexts()
    }

    private fun displayLocalizedTexts() {
        val pokeCount = 3
        val hello =
            resources.getString(R.string.hello_world, "Iconplus Squads", pokeCount, "Izza")
        tvLocaleHallo.text = hello

        val songCount = 5
        val pluralText =
            resources.getQuantityString(R.plurals.numberOfSongsAvailable, songCount, songCount)
        tvLocalePlural.text = pluralText
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_localization, menu)
        return super.onCreateOptionsMenu(menu)
    }
}
