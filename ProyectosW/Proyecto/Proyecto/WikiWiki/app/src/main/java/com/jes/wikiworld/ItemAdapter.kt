import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.jes.wikiworld.Item
import com.jes.wikiworld.Item2
import com.jes.wikiworld.R

class ItemAdapter(private val items: MutableList<Item2>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    private var onDeleteClickListener: ((Item2) -> Unit)? = null
    private val favoritos: MutableSet<Item2> = mutableSetOf()

    // Método para establecer el listener del clic en el botón de eliminar
    fun setOnDeleteClickListener(listener: (Item2) -> Unit) {
        onDeleteClickListener = listener
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = items[position]
        holder.bind(currentItem, favoritos.contains(currentItem))

        // Establecer el listener del clic en el botón de eliminar
        holder.deleteButton.setOnClickListener {
            onDeleteClickListener?.invoke(currentItem)
            items.remove(currentItem) // Eliminar el elemento de la lista
            notifyDataSetChanged() // Notificar al RecyclerView que los datos han cambiado
        }

        holder.itemView.setOnClickListener {
            toggleSelection(currentItem)
        }
    }

    fun clearSelection() {
        favoritos.clear()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size

    // Método para obtener el elemento seleccionado
    fun getSelectedItems(): List<Item2> {
        return favoritos.toList()
        notifyDataSetChanged()
    }

    // Método para alternar la selección de un elemento
    private fun toggleSelection(item: Item2) {
        if (favoritos.contains(item)) {
            favoritos.remove(item)
        } else {
            favoritos.add(item)
        }
        notifyItemChanged(items.indexOf(item))
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
        val deleteButton: Button = itemView.findViewById(R.id.deleteButton)

        fun bind(item: Item2, isSelected: Boolean) {
            nameTextView.text = item.nombre
            descriptionTextView.text = item.description
            itemView.isActivated = isSelected

            // Cambiar el color de fondo si el ítem está seleccionado
            if (isSelected) {
                itemView.setBackgroundColor(Color.parseColor("#00FF00")) // Cambia el color a tu preferencia
            } else {
                // Si el ítem no está seleccionado, restaura el color de fondo predeterminado
                val defaultBackgroundColor =
                    ContextCompat.getColor(itemView.context, android.R.color.transparent)
                itemView.setBackgroundColor(defaultBackgroundColor)
            }
        }
    }
}