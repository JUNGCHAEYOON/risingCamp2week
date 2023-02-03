package com.example.risingcamp2week.FRAGMENT

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.risingcamp2week.R
import com.example.risingcamp2week.databinding.FragmentMycarrotBinding

class MycarrotFragment : Fragment() {
    private var binding : FragmentMycarrotBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mycarrot, container, false)
    }
}