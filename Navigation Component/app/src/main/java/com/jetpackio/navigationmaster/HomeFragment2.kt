package com.jetpackio.navigationmaster

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.jetpackio.navigationmaster.databinding.FragmentHome2Binding

class HomeFragment2 : BaseDataBindingFragment<FragmentHome2Binding>() {
    override fun getLayoutRes(): Int = R.layout.fragment_home2

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataBinding.btnGoToStart.setOnClickListener {
            findNavController().navigate(R.id.action_global_start)
        }
    }

}
