package com.aa.we201820367

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aa.we201820367.databinding.FragmentBtn1Binding

class  Btn1Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var binding : FragmentBtn1Binding




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBtn1Binding.inflate(inflater, container, false)

        return binding.root

    }



}