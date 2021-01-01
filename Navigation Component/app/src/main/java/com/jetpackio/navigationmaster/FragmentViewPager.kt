package com.jetpackio.navigationmaster


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class ViewPagerFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
    }




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_viewpager_container, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TabLayout
        val tabLayout = view.findViewById<TabLayout>(R.id.tabLayout)
        // ViewPager2
        val viewPager = view.findViewById<ViewPager2>(R.id.viewPager)

        /*
            🔥 Set Adapter for ViewPager inside this fragment using this Fragment,
            more specifically childFragmentManager as param
         */
      /*  viewPager.adapter =
            ChildFragmentStateAdapter(childFragmentManager, viewLifecycleOwner.lifecycle)

        // Bind tabs and viewpager
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Home"
                1 -> "Dashboard"
                else -> "Notification"
            }
        }.attach()*/

        //.......................................................................

        viewPager.adapter = object : FragmentStateAdapter(this) {
            override fun createFragment(position: Int): Fragment {
                return ResourceStore.pagerFragments[position]
            }

            override fun getItemCount(): Int {
                return ResourceStore.tabList.size
            }
        }


        //renderTabLayer
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = getString(ResourceStore.tabList[position])
        }.attach()

        //.......................................................................


    }

}

interface ResourceStore {
    companion object {
        val tabList = listOf(
            R.string.page1, R.string.page2, R.string.page3
        )
        val pagerFragments = listOf(
            FragmentPage1(), FragmentPage2(), FragmentPage3()
        )
    }
}