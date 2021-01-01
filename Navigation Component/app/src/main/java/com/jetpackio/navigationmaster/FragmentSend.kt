package com.jetpackio.navigationmaster

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.jetpackio.navigationmaster.databinding.FragmentSendBinding


class FragmentSend : BaseDataBindingFragment<FragmentSendBinding>() {

    override fun getLayoutRes(): Int = R.layout.fragment_send

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataBinding.btnPass1.setOnClickListener {

            val bundle = bundleOf("myArg" to 100)
            // 🔥 Alternative 2
            findNavController().navigate(R.id.action_fragmentSend_to_fragmentReceiver, bundle)
        }

        dataBinding.btnPass2.setOnClickListener {

            // 🔥 Alternative 3
            val myDataArg = Data("test", 200)
            val action =
                    FragmentSendDirections.actionFragmentSendToFragmentReceiver(
                            0, myDataArg
                    )
            findNavController().navigate(action)

        }



    }

}
