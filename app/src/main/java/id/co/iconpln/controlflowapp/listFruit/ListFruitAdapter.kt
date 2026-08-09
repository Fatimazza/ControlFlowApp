package id.co.iconpln.controlflowapp.listFruit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.co.iconpln.controlflowapp.databinding.ItemListFruitBinding
import id.co.iconpln.controlflowapp.model.Fruit

class ListFruitAdapter(
    private val itemList: List<Fruit>
) : RecyclerView.Adapter<ListFruitAdapter.ListFruitViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListFruitViewHolder {
        val binding = ItemListFruitBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ListFruitViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ListFruitViewHolder,
        position: Int
    ) {
        val item = itemList[position]
        holder.binding.tvFruitName.text = item.name
    }

    override fun getItemCount(): Int = itemList.size

    class ListFruitViewHolder(var binding: ItemListFruitBinding) :
        RecyclerView.ViewHolder(binding.root)
}
