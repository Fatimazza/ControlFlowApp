package id.co.iconpln.controlflowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_backhround_thread.*
import java.net.URL

class BackhroundThreadActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_backhround_thread)

        btnThreadWorker.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btnThreadWorker -> {
                /*
                Don't : Call Network in Main Thread
                val text = URL("https://api.androidhive.info/contacts").readText()
                tvThreadWorkerResult.text = text
                */

                Thread(
                    Runnable {
                        val text = URL("https://api.androidhive.info/contacts").readText()
                        // Don't Call UI Thread in Background
                        // tvThreadWorkerResult.text = text
                    }
                ).start()
            }
        }
    }
}
