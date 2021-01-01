package com.jetpackio.navigationmaster


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions


class MainFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //..........................................................................................
        val btnDestA1 = view.findViewById<Button>(R.id.btnDestA1)
        // Navigation to Destinations which are specified with app:destination in <action/> tag
        //btnDestA1?.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_mainFragment_to_desiFragment, null))

        // Alternative 1 Only works this way not with LAMBDA
        btnDestA1?.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.dest_frag, null))

        //...........................................................................................
        val btnDestA2 = view.findViewById<Button>(R.id.btnDestA2)
        btnDestA2?.setOnClickListener {
            // Alternative 3
             Navigation.findNavController(view).navigate(R.id.dest_frag)
        }

        //...........................................................................................
        val btnDestA3 = view.findViewById<Button>(R.id.btnDestA3)
        btnDestA3?.setOnClickListener {
            // 🔥 Alternative 3
            Navigation.findNavController(view).navigate(R.id.dest_frag)
        }


        //...........................................................................................
        //...........................................................................................
        val btnDest1 = view.findViewById<Button>(R.id.btn_dest1)
        // 🔥 Alternative 2
        btnDest1?.setOnClickListener {

            val options = navOptions {
                anim {
                    enter = R.anim.slide_in_right
                    exit = R.anim.slide_out_left
                    popEnter = R.anim.slide_in_left
                    popExit = R.anim.slide_out_right
                }
            }
            findNavController().navigate(R.id.dest_frag_1, null, options)
        }
        //...........................................................................................


        // Home Nav Graph - nested
        val buttonHomeNavGraph = view.findViewById<Button>(R.id.btnNavGraphHome)
        buttonHomeNavGraph?.setOnClickListener(
                Navigation.createNavigateOnClickListener(
                        R.id.action_main_dest_to_nav_graph_home,
                        null
                )
        )
        //...........................................................................................

        // Pass data
        val btnPassData = view.findViewById<Button>(R.id.btnPassData)
        btnPassData?.setOnClickListener {

            Navigation.findNavController(view).navigate(R.id.fragmentSend)
        }
        //...........................................................................................

        // Navigation view & bottom navigation
        val navigationView = view.findViewById<Button>(R.id.navigationView)
        navigationView?.setOnClickListener {

            val intent = Intent(requireContext(), Eg2Navigation::class.java)
            startActivity(intent)
        }
        //...........................................................................................

        // View Pager fragment
        val viewPager = view.findViewById<Button>(R.id.viewPager)
        viewPager?.setOnClickListener {

            Navigation.findNavController(view).navigate(R.id.action_main_frag_to_viewPagerFragment)
        }
        //...........................................................................................

    }


}
