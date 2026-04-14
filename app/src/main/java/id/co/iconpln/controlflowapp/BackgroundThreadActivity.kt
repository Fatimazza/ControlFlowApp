package id.co.iconpln.controlflowapp

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.View
import id.co.iconpln.controlflowapp.databinding.ActivityBackgroundThreadBinding
import kotlinx.coroutines.*
import java.lang.Runnable
import java.lang.ref.WeakReference
import java.net.URL

class BackgroundThreadActivity : AppCompatActivity(), View.OnClickListener,
    ContactAsyncTaskCallback {

    private lateinit var binding: ActivityBackgroundThreadBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBackgroundThreadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnThreadWorker.setOnClickListener(this)
        binding.btnThreadHandler.setOnClickListener(this)
        binding.btnThreadAsyncTask.setOnClickListener(this)
        binding.btnThreadCoroutine.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view) {
            binding.btnThreadWorker -> {
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
                        binding.tvThreadWorkerResult.post(Runnable {
                            binding.tvThreadWorkerResult.text = urlResult
                        })
                    }
                ).start()
            }

            binding.btnThreadHandler -> {
                Thread(Runnable {
                    val urlResult = URL("https://api.androidhive.info/contacts").readText()
                    val msg = Message.obtain()
                    msg.obj = urlResult
                    msg.target = contactHandler
                    msg.sendToTarget()
                }).start()
            }

            binding.btnThreadAsyncTask -> {
                val urlResult = URL("https://api.androidhive.info/contacts")
                FetchContactAsyncTask(this).execute(urlResult)
            }

            binding.btnThreadCoroutine -> {
                /*runBlocking {
                    launch {
                        delay(1000)
                        tvThreadCoroutineResult.text = "Coroutine!"
                    }
                }*/
                runBlocking {
                    val first = async { getContact() }
                    val result = first.await()
                    binding.tvThreadCoroutineResult.text = result.toString()
                }
            }
        }
    }

    suspend fun getNumber(): Int {
        delay(1000)
        return 3 * 2
    }

    suspend fun getContact(): String {
        return withContext(Dispatchers.IO) {
            URL("https://api.androidhive.info/contacts").readText()
        }
    }

    private val contactHandler = Handler() { message ->
        binding.tvThreadHandlerResult.text = message.obj as String
        true
    }

    override fun onPreExecute() {
        binding.tvThreadAsyncResult.visibility = View.GONE
        binding.pbThreadAsyncProgress.visibility = View.VISIBLE
    }

    override fun onProgressUpdate(vararg values: Int?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPostExecute(result: String?) {
        binding.tvThreadAsyncResult.visibility = View.VISIBLE
        binding.pbThreadAsyncProgress.visibility = View.GONE
        binding.tvThreadAsyncResult.text = result
    }

    class FetchContactAsyncTask(val listener: ContactAsyncTaskCallback) :
        AsyncTask<URL, Int, String>() {

        //using WeakReference to avoid Memory Leak in AsyncTask
        private val contactListener: WeakReference<ContactAsyncTaskCallback> =
            WeakReference(listener)

        override fun onPreExecute() {
            super.onPreExecute()

            val myListener = contactListener.get()
            myListener?.onPreExecute()
        }

        override fun doInBackground(vararg urls: URL): String {
            val urlResult = urls[0].readText()
            return urlResult
        }

        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)

            val myListener = contactListener.get()
            myListener?.onProgressUpdate(*values)
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)

            val myListener = contactListener.get()
            myListener?.onPostExecute(result)
        }
    }

}

interface ContactAsyncTaskCallback {
    fun onPreExecute()
    fun onProgressUpdate(vararg values: Int?)
    fun onPostExecute(result: String?)
}
