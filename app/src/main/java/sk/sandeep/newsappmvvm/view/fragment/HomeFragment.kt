package sk.sandeep.newsappmvvm.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import sk.sandeep.newsappmvvm.R
import sk.sandeep.newsappmvvm.adapter.ViewPagerAdapter
import sk.sandeep.newsappmvvm.databinding.FragmentHomeBinding
import sk.sandeep.newsappmvvm.utils.BREAKING_NEWS_INDEX
import sk.sandeep.newsappmvvm.utils.RECENT_NEWS_INDEX
import sk.sandeep.newsappmvvm.utils.SAVED_NEWS_INDEX

class HomeFragment : Fragment() {

    private lateinit var homeBinding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeBinding = FragmentHomeBinding.inflate(layoutInflater)
        val tabLayout = homeBinding.tabs
        val viewPager = homeBinding.viewPager
        viewPager.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(tabLayout,viewPager) {tab,position->
            tab.text =getTabTitle(position)
            //if ypu want add icon in tab
            //tab.setIcon =getTabIcon(position)
        }.attach()

        return homeBinding.root
    }

    //function to add title in tabs
    private fun getTabTitle(position: Int): String {
        return when (position) {
            BREAKING_NEWS_INDEX -> getString(R.string.breaking_news)
            RECENT_NEWS_INDEX -> getString(R.string.recent_news)
            SAVED_NEWS_INDEX -> getString(R.string.saved_news)
            else -> throw IndexOutOfBoundsException()
        }
    }
    /*
    * if you want to add icon with tab you can create icon in drawable and add as id here
    * private fun getTabIcon(position: Int): Int {

        return when (position) {
            MY_GARDEN_PAGE_INDEX -> R.drawable.garden_tab_selector
            PLANT_LIST_PAGE_INDEX -> R.drawable.plant_list_tab_selector
            else -> throw IndexOutOfBoundsException()
        }
    }*/
}