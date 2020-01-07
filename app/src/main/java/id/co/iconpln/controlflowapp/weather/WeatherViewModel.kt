package id.co.iconpln.controlflowapp.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import id.co.iconpln.controlflowapp.BuildConfig

class WeatherViewModel: ViewModel() {

    companion object {
        private const val API_KEY = BuildConfig.API_KEY
    }

    private val listWeathers = MutableLiveData<ArrayList<Weather>>()

    internal fun setWeather(city: String) {
        val client = AsyncHttpClient()
        val listItems = ArrayList<Weather>()
        val url =
            "https://api.openweathermap.org/data/2.5/group?id=$city&units=metric&appid=$API_KEY"

        // Request Weather API
        client.get(url, object : AsyncHttpResponseHandler(){
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>,
                responseBody: ByteArray
            ) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>,
                responseBody: ByteArray,
                error: Throwable
            ) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
    }

    internal fun getWeather(): LiveData<ArrayList<Weather>> {
        return listWeathers
    }

}
