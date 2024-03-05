import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jes.wikiworld.Item2
import com.jes.wikiworld.R

class ItemAdapter2(private val items: MutableList<Item2>) : RecyclerView.Adapter<ItemAdapter2.ItemViewHolder>() {

    private val selectedItems: MutableSet<Item2> = mutableSetOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemlayout2, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = items[position]
        holder.bind(currentItem, selectedItems.contains(currentItem))
        holder.itemView.setOnClickListener {
            toggleSelection(currentItem)
        }
    }

    override fun getItemCount(): Int = items.size

    // Método para obtener el elemento seleccionado
    fun getSelectedItems(): List<Item2> {
        return selectedItems.toList()
    }

    // Método para alternar la selección de un elemento
    private fun toggleSelection(item: Item2) {
        if (selectedItems.contains(item)) {
            selectedItems.remove(item)
        } else {
            selectedItems.add(item)
        }
        notifyItemChanged(items.indexOf(item))
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)

        fun bind(item: Item2, isSelected: Boolean) {
            nameTextView.text = item.nombre
            descriptionTextView.text = item.description
            itemView.isActivated = isSelected
        }
    }
}
