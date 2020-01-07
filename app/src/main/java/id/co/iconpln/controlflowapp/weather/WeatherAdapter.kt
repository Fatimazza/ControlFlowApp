package id.co.iconpln.controlflowapp.weather

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.co.iconpln.controlflowapp.R
import kotlinx.android.synthetic.main.item_list_weather.view.*

class WeatherAdapter : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    private val weatherData = ArrayList<Weather>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val mView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_weather, parent, false)
        return WeatherViewHolder(mView)
    }

    override fun getItemCount(): Int {
        return weatherData.size
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bind(weatherData[position])
    }

    fun setData(weatherItems: ArrayList<Weather>) {
        weatherData.clear()
        weatherData.addAll(weatherItems)
        notifyDataSetChanged()
    }

    inner class WeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind (weatherItem: Weather) {
            itemView.tvWeatherCity.text = weatherItem.name
            itemView.tvWeatherTemp.text = weatherItem.temperature
            itemView.tvWeatherDesc.text = weatherItem.description
        }
    }

}
