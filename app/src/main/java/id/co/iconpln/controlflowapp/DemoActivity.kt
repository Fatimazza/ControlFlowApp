package id.co.iconpln.controlflowapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import kotlinx.android.synthetic.main.activity_demo.*

class DemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)

        btnSubmit.setOnClickListener {
            val styleIntent = Intent(this, StyleActivity::class.java)
            startActivity(styleIntent)
        }
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
        return super.onCreateOptionsMenu(menu)
    }
}
