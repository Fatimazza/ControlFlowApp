package id.co.iconpln.controlflowapp.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
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

        })
    }

    internal fun getWeather(): LiveData<ArrayList<Weather>> {
        return listWeathers
    }

}
