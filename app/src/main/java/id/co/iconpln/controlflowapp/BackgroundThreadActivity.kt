package id.co.iconpln.controlflowapp

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.View
import kotlinx.android.synthetic.main.activity_background_thread.*
import java.lang.ref.WeakReference
import java.net.URL

class BackgroundThreadActivity : AppCompatActivity(), View.OnClickListener, ContactAsyncTaskCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_background_thread)

        btnThreadWorker.setOnClickListener(this)
        btnThreadHandler.setOnClickListener(this)
        btnThreadAsyncTask.setOnClickListener(this)
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
            R.id.btnThreadAsyncTask -> {

            }
        }
    }

    private val contactHandler = Handler() { message ->
        tvThreadHandlerResult.text = message.obj as String
        true
    }

    override fun onPreExecute() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onProgressUpdate(vararg values: Int?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPostExecute(result: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class FetchContactAsyncTask(val listener: ContactAsyncTaskCallback): AsyncTask<URL, Int, String>() {

        //using WeakReference to avoid Memory Leak in AsyncTask
        private val contactListener: WeakReference<ContactAsyncTaskCallback> = WeakReference(listener)

        override fun onPreExecute() {
            super.onPreExecute()
        }

        override fun doInBackground(vararg urls: URL): String {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
        }
    }

}

interface ContactAsyncTaskCallback {
    fun onPreExecute()
    fun onProgressUpdate(vararg values: Int?)
    fun onPostExecute(result: String?)
}
