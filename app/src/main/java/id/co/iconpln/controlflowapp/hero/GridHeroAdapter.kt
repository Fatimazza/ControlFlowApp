package id.co.iconpln.controlflowapp.hero

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.co.iconpln.controlflowapp.databinding.ItemGridHeroBinding
import id.co.iconpln.controlflowapp.model.Hero

class GridHeroAdapter(val listHero: ArrayList<Hero>) :
    RecyclerView.Adapter<GridHeroAdapter.GridHeroViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridHeroViewHolder {
        val binding = ItemGridHeroBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return GridHeroViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listHero.size
    }

    override fun onBindViewHolder(holder: GridHeroViewHolder, position: Int) {
        val (name, description, photo) = listHero[position]
        Glide.with(holder.binding.root)
            .load(photo)
            .into(holder.binding.ivHeroGridPhoto)

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClick(listHero[holder.adapterPosition])
        }
    }

    class GridHeroViewHolder(var binding: ItemGridHeroBinding) :
        RecyclerView.ViewHolder(binding.root)

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClick(hero: Hero)
    }
}
