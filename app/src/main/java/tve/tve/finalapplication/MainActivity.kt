package tve.tve.finalapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val LAST_SELECTED_ITEM = "item"
private val LUNCH_FRAGMENT = LunchFragment().javaClass.name
private val SECOND_FRAGMENT = SecondFragment().javaClass.name

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener { item ->

            var fragment: Fragment? = null
            when (item.itemId) {

                R.id.roll_lunch -> {
                    fragment = if (savedInstanceState != null) supportFragmentManager.getFragment(
                        savedInstanceState,
                        LUNCH_FRAGMENT
                    ) else LunchFragment()

                }
                R.id.food_info -> {
                    fragment = if (savedInstanceState != null) supportFragmentManager.getFragment(
                        savedInstanceState,
                        SECOND_FRAGMENT
                    ) else SecondFragment()
                }

            }

            replaceFragment(fragment!!)

            true
        }

        bottomNavigationView.selectedItemId =
            savedInstanceState?.getInt(LAST_SELECTED_ITEM) ?: R.id.roll_lunch

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_SELECTED_ITEM, bottomNavigationView.selectedItemId)

        val currentFragment = supportFragmentManager.fragments.last()
        supportFragmentManager.putFragment(
            outState,
            currentFragment.javaClass.name,
            currentFragment
        )

    }

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

}
