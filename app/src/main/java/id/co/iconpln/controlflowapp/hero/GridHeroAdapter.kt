package id.co.iconpln.controlflowapp.hero

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.model.Hero

class GridHeroAdapter(val listHero: ArrayList<Hero>): RecyclerView.Adapter<GridHeroAdapter.GridHeroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridHeroViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_grid_hero, parent, false)
        return GridHeroViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listHero.size
    }

    override fun onBindViewHolder(holder: GridHeroViewHolder, position: Int) {
        holder.bind(listHero[position])
    }

    inner class GridHeroViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

        fun bind(hero: Hero) {

        }
    }
}
