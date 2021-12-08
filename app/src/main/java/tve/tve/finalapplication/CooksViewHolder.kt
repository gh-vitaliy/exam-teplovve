package tve.tve.finalapplication

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CooksViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    private val cooksNameTextView: TextView = itemView.findViewById(R.id.cooks_name_text_view)

    fun bing(name: String) {
        cooksNameTextView.text = name
    }
}