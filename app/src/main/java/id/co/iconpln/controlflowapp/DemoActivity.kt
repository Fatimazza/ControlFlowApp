package id.co.iconpln.controlflowapp

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.Menu
import android.view.View
import android.widget.SearchView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import id.co.iconpln.controlflowapp.databinding.ActivityDemoBinding

class DemoActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setButtonClickListener()
    }

    private fun setButtonClickListener() {
        binding.btnSubmit.setOnClickListener(this)
        binding.btnSnackbar.setOnClickListener(this)
        binding.btnSnackbarButton.setOnClickListener(this)
        binding.btnSnackbarCustom.setOnClickListener(this)
    }

    override fun onStart() {
        super.onStart()
        Log.d("Izza", " - - on Start")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Izza", " - - on Resume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Izza", " - - on Pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Izza", " - - on Stop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Izza", " - - on Restart")
    }

    override fun onDestroy() {
        Log.d("Izza", " - - on Destroy")
        super.onDestroy()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_demo, menu)
        setupSearchView(menu)

        return super.onCreateOptionsMenu(menu)
    }

    private fun setupSearchView(menu: Menu?) {
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu?.findItem(R.id.action_demo_search)?.actionView as SearchView

        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.queryHint = resources.getString(R.string.menu_search_hint)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                Toast.makeText(this@DemoActivity, query, Toast.LENGTH_SHORT).show()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }

    override fun onClick(view: View) {
        when(view) {
            binding.btnSubmit -> {
                val styleIntent = Intent(this, StyleActivity::class.java)
                startActivity(styleIntent)
            }
            binding.btnSnackbar -> {
                Snackbar.make(findViewById(R.id.clDemo), "This is Snackbar", Snackbar.LENGTH_SHORT).show()
            }
            binding.btnSnackbarButton -> {
                Snackbar
                    .make(findViewById(R.id.clDemo), "Message is deleted", Snackbar.LENGTH_SHORT)
                    .setAction("Undo", undoListener)
                    .show()
            }
            binding.btnSnackbarCustom -> {
                val customSnackbar = Snackbar
                    .make(findViewById(R.id.clDemo), "This is a Custom Snackbar", Snackbar.LENGTH_SHORT)
                    .setActionTextColor(ContextCompat.getColor(this, R.color.button_snackbar))
                    .setAction("Undo", undoListener)

                val snackbarView = customSnackbar.view
                val textView: TextView = snackbarView.findViewById(R.id.snackbar_text)
                textView.setTextColor(ContextCompat.getColor(this, R.color.colorAccent))
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)

                snackbarView.setBackgroundColor(
                    ContextCompat.getColor(
                        baseContext,
                        R.color.colorPrimaryDark
                    )
                )
                customSnackbar.show()
            }
        }
    }

    private val undoListener = object : View.OnClickListener {
        override fun onClick(view: View?) {
            Snackbar.make(findViewById(R.id.clDemo), "Message is restored", Snackbar.LENGTH_SHORT).show()
        }
    }
}
