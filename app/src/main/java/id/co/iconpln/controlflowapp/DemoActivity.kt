package id.co.iconpln.controlflowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class DemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)
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
}
