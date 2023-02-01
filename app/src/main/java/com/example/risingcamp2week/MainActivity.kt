package com.example.risingcamp2week

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.risingcamp2week.FRAGMENT.*
import com.example.risingcamp2week.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //뷰 바인딩
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //뷰 바인딩으로 setContentView
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //바텀네비 바인딩
        val bottomNavigation = binding.bottomNavigationView
        bottomNavigation.setOnItemSelectedListener {
            item -> changeFragment(
                when(item.itemId){
                    R.id.item1 ->{
                        HomeFragment()
                    }
                    R.id.item2 ->{
                        DongnaeFragment()
                    }
                    R.id.item3 ->{
                        NearmeFragment()
                    }
                    R.id.item4 ->{
                        ChattingFragment()
                    }
                    else ->{
                        MycarrotFragment()
                    }
                }
            )
            true
        }
        //기본 화면 홈프래그먼트
        bottomNavigation.selectedItemId = R.id.item1
    }

    // 바텀네비 프래그먼트 교체 함수
    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameLayout, fragment)
            .commit()
    }
}