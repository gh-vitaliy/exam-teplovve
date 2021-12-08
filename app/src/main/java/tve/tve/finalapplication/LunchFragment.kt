package tve.tve.finalapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment

private const val LAST_ROLLED_IMAGE = "image"

class LunchFragment : Fragment() {

    lateinit var lunchImageView: ImageView
    lateinit var rollButton: Button

    private val lunchImageList: List<Int> = listOf(
        //приватный список картинок
        R.drawable.borsch1,
        R.drawable.lentil_soup1,
        R.drawable.turkmensoup1,
        R.drawable.chicken2,
        R.drawable.goulash2,
        R.drawable.meatballs2,
        R.drawable.mojito3,
        R.drawable.lemonade3,
        R.drawable.juice3,

        )

    var lastRolledImageRes = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_lunch, container, false)

        lunchImageView = view.findViewById(R.id.lunch_image_view)
        rollButton = view.findViewById(R.id.roll_button)

        if (savedInstanceState != null)
            lunchImageView.setImageResource(savedInstanceState.getInt(LAST_ROLLED_IMAGE))

        rollButton.setOnClickListener {
            lastRolledImageRes = lunchImageList.random()

            lunchImageView.setImageResource(lastRolledImageRes)

        }
        return view

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_ROLLED_IMAGE, lastRolledImageRes)
    }
}