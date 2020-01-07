package id.co.iconpln.controlflowapp.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.co.iconpln.controlflowapp.R
import kotlinx.android.synthetic.main.activity_weather.*

class WeatherActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var adapter: WeatherAdapter

    private lateinit var weatherViewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        initViewModel()
        showListWeather()
        btnWeatherSearch.setOnClickListener(this)
    }

    private fun initViewModel() {
        weatherViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
            .get(WeatherViewModel::class.java)
    }

    private fun showListWeather() {
        adapter = WeatherAdapter()
        adapter.notifyDataSetChanged()

        rvWeatherList.layoutManager = LinearLayoutManager(this)
        rvWeatherList.adapter = adapter
    }

    override fun onClick(view: View) {
        if (view.id == R.id.btnWeatherSearch) {

        }
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            pbWeatherLoading.visibility = View.VISIBLE
        } else {
            pbWeatherLoading.visibility = View.GONE
        }
    }
}
