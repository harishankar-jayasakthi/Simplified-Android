package com.jetpackio.navigationmaster


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.jetpackio.navigationmaster.R

/**
 * A simple [Fragment] subclass.
 *
 */
class FragmentDestination1 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
    }




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_destination_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Go Next
        view.findViewById<Button>(R.id.btn_destB_go_next).setOnClickListener {
            findNavController().navigate(R.id.action_desi1_to_desi2)
        }

        // Go Back
        view.findViewById<Button>(R.id.btn_destB_go_back).setOnClickListener {
            findNavController().popBackStack()
        }

    }


}
