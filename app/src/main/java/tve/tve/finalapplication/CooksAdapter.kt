package tve.tve.finalapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CooksAdapter(private val cooksName:List<String>) :
    RecyclerView.Adapter<CooksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CooksViewHolder {
        val itemView=LayoutInflater.from(parent.context)
            .inflate(R.layout.cooks_list_item,parent,false)
        return CooksViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CooksViewHolder, position: Int) {
        val name=cooksName[position]
        holder.bing(name)
    }

    override fun getItemCount(): Int {
        return cooksName.size
    }
}