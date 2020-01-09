package id.co.iconpln.controlflowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_background_thread.*
import java.net.URL

class BackgroundThreadActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_background_thread)

        btnThreadWorker.setOnClickListener(this)
        btnThreadHandler.setOnClickListener(this)
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
                        val urlResult = URL("https://api.androidhive.info/contacts").readText()
                        // Don't Call UI Thread in Background
                        // tvThreadWorkerResult.text = text
                        tvThreadWorkerResult.post(Runnable {
                            tvThreadWorkerResult.text = urlResult
                        })
                    }
                ).start()
            }
            R.id.btnThreadHandler -> {
                Thread(Runnable {
                    val urlResult = URL("https://api.androidhive.info/contacts").readText()
                    val msg = Message.obtain()
                    msg.obj = urlResult
                    msg.target = contactHandler
                    msg.sendToTarget()
                }).start()
            }
        }
    }

    private val contactHandler = Handler() { message ->
        tvThreadHandlerResult.text = message.obj as String
        true
    }
}
