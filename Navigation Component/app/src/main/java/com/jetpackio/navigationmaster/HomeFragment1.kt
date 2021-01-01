package com.jetpackio.navigationmaster

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.jetpackio.navigationmaster.databinding.FragmentHome1Binding

class HomeFragment1 : BaseDataBindingFragment<FragmentHome1Binding>() {

    override fun getLayoutRes(): Int = R.layout.fragment_home1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataBinding.btnNextPage.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment1_to_homeFragment2)
        }

    }

}
