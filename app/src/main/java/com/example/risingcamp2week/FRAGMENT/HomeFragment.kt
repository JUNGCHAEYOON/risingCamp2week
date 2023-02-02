package com.example.risingcamp2week.FRAGMENT

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.risingcamp2week.R
import com.example.risingcamp2week.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var binding : FragmentHomeBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 프래그먼트도 바인딩하여 사용!
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding!!.root
    }
    
    // onDestroy 를 통해 binding 해제
    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

}