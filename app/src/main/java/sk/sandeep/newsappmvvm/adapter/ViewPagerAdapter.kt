package sk.sandeep.newsappmvvm.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import sk.sandeep.newsappmvvm.utils.BREAKING_NEWS_INDEX
import sk.sandeep.newsappmvvm.utils.RECENT_NEWS_INDEX
import sk.sandeep.newsappmvvm.utils.SAVED_NEWS_INDEX
import sk.sandeep.newsappmvvm.view.fragment.BreakingNewsFragment
import sk.sandeep.newsappmvvm.view.fragment.RecentNewsFragment
import sk.sandeep.newsappmvvm.view.fragment.SavedNewsFragment

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    //get size of map
    override fun getItemCount(): Int = tabPageAssign.size
    //invoke the fragment
    override fun createFragment(position: Int): Fragment {
        return tabPageAssign[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
    //create a function that map position and fragment
    private val tabPageAssign: Map<Int, () -> Fragment> = mapOf(
        BREAKING_NEWS_INDEX to { BreakingNewsFragment() },
        RECENT_NEWS_INDEX to { RecentNewsFragment() },
        SAVED_NEWS_INDEX to { SavedNewsFragment() }
    )
}