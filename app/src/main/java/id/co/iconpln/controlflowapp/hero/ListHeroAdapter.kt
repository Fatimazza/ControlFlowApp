package id.co.iconpln.controlflowapp.hero

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.co.iconpln.controlflowapp.databinding.ItemListHeroBinding
import id.co.iconpln.controlflowapp.model.Hero

class ListHeroAdapter(val listHero: ArrayList<Hero>) :
    RecyclerView.Adapter<ListHeroAdapter.HeroViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val binding = ItemListHeroBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return HeroViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listHero.size
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        val (name, description, photo) = listHero[position]
        holder.binding.tvHeroName.text = name
        holder.binding.tvHeroDesc.text = description

        Glide.with(holder.binding.root)
            .load(photo)
            .into(holder.binding.ivHeroPhoto)

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClick(listHero[holder.adapterPosition])
        }
    }

    class HeroViewHolder(var binding: ItemListHeroBinding) : RecyclerView.ViewHolder(binding.root)

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClick(hero: Hero)
    }
}
