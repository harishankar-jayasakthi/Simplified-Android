package com.jetpackio.navigationmaster

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.jetpackio.navigationmaster.databinding.FragmentReciveBinding

/**
 * A simple [Fragment] subclass. that contains safe args by [FragmentRecive]
 *
 */

class FragmentRecive : BaseDataBindingFragment<FragmentReciveBinding>() {

    private val safeArgs: FragmentReciveArgs by navArgs()



    override fun getLayoutRes(): Int = R.layout.fragment_recive


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myArg = arguments?.getInt("myArg")
        if(myArg==0){

            val myData = safeArgs.myData
            dataBinding.txyInfo.text="Name: ${myData?.name}, value: ${myData?.value}"
        }else{

            dataBinding.txyInfo.text="From Bundle myArg $myArg"
        }



    }

}
