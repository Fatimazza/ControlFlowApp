package id.co.iconpln.controlflowapp

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_demo.*

class DemoActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)

        setButtonClickListener()
    }

    private fun setButtonClickListener() {
        btnSubmit.setOnClickListener(this)
        btnSnackbar.setOnClickListener(this)
        btnSnackbarButton.setOnClickListener(this)
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
        when(view.id) {
            R.id.btnSubmit -> {
                val styleIntent = Intent(this, StyleActivity::class.java)
                startActivity(styleIntent)
            }
            R.id.btnSnackbar -> {

            }
            R.id.btnSnackbarButton -> {

            }
        }
    }
}
