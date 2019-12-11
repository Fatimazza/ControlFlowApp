package id.co.iconpln.controlflowapp.hero

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.co.iconpln.controlflowapp.R
import id.co.iconpln.controlflowapp.model.Hero
import kotlinx.android.synthetic.main.item_list_hero.view.*

class HeroAdapter(val listHero: ArrayList<Hero>) : RecyclerView.Adapter<HeroAdapter.HeroViewHolder>() {
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_hero, parent, false)
        return HeroViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listHero.size
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.bind(listHero[position])
    }

    inner class HeroViewHolder(private val view:View): RecyclerView.ViewHolder(view) {

        fun bind(hero: Hero) {
            view.tvHeroName.text = hero.name
            view.tvHeroDesc.text = hero.desc

            Glide.with(view.context)
                .load(hero.photo)
                .into(view.ivHeroPhoto)
        }
    }

}
