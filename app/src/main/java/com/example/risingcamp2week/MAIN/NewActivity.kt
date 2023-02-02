package com.example.risingcamp2week.MAIN

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.risingcamp2week.databinding.ActivityMainBinding
import com.example.risingcamp2week.databinding.ActivityNewBinding

class NewActivity : AppCompatActivity() {

    //뷰 바인딩
    private lateinit var binding : ActivityNewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //뷰 바인딩으로 setContentView
        binding = ActivityNewBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}