package id.co.iconpln.controlflowapp.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.co.iconpln.controlflowapp.BuildConfig

class WeatherViewModel: ViewModel() {

    companion object {
        private const val API_KEY = BuildConfig.API_KEY
    }

    private val listWeathers = MutableLiveData<ArrayList<Weather>>()

    internal fun setWeather(city: String) {

    }

    internal fun getWeather(): LiveData<ArrayList<Weather>> {
        return listWeathers
    }

}
