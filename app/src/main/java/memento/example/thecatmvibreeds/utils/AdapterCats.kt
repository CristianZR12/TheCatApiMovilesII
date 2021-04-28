package memento.example.thecatmvibreeds.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_cat.view.*
import memento.example.thecatmvibreeds.R
import memento.example.thecatmvibreeds.model.Cat

class AdapterCats():RecyclerView.Adapter<AdapterCats.ViewHolder>() {

    lateinit var items:ArrayList<Cat>

    fun setCats(items:List<Cat>) {
        this.items = items as ArrayList<Cat>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_cat, parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = items[position]
        holder.catName.text = model.name
        holder.catDescription.text = model.description
    }

    override fun getItemCount(): Int {
        return if(::items.isInitialized) {
            items.size
        } else {
            0
        }
    }

    class ViewHolder(view:View):RecyclerView.ViewHolder(view) {
        val catName:TextView = view.tv_name_cat
        val catDescription:TextView = view.tv_description_cat
    }
}