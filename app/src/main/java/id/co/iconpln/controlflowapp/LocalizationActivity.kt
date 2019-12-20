package id.co.iconpln.controlflowapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem

class LocalizationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_localization)

        displayLocalizedTexts()
    }

    private fun displayLocalizedTexts() {
        val pokeCount = 3
        val hello =
            resources.getString(R.string.locale_count_hello, "Iconplus Squads", pokeCount, "Izza")
        tvLocaleHallo.text = hello

        val songCount = 5
        val pluralText =
            resources.getQuantityString(R.plurals.locale_count_plural_songs, songCount, songCount)
        tvLocalePlural.text = pluralText
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_localization, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_language) {
            val intent = Intent(Settings.ACTION_LOCALE_SETTINGS)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}
