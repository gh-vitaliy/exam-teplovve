package tve.tve.finalapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SecondFragment : Fragment() {

    lateinit var cooksRecyclerView: RecyclerView
    lateinit var showWebSiteButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view= inflater.inflate(R.layout.fragment_second, container, false)
        val cooksNames:List<String> = listOf("Русская кухня","Азиатская кухня")

        showWebSiteButton=view.findViewById(R.id.show_web_site_button)

        cooksRecyclerView=view.findViewById(R.id.cooks_recycler_view)
        cooksRecyclerView.layoutManager=LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        cooksRecyclerView.adapter=CooksAdapter(cooksNames)

        showWebSiteButton.setOnClickListener {
            val link = Uri.parse("https:/yandex.ru")
            val intent=Intent(Intent.ACTION_VIEW, link)
            context?.startActivity(intent)
        }



        return view
   }
}