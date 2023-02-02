package com.example.risingcamp2week.MAIN

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.risingcamp2week.FRAGMENT.*
import com.example.risingcamp2week.R
import com.example.risingcamp2week.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //뷰 바인딩
    private lateinit var binding : ActivityMainBinding

    //플로트 버튼 애니메이션
    private lateinit var rotate_start : Animation
    private lateinit var rotate_end : Animation
    private var clicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //뷰 바인딩으로 setContentView
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //버튼 애니메이션
        rotate_start = AnimationUtils.loadAnimation(this,R.anim.rotate_start)
        rotate_end = AnimationUtils.loadAnimation(this,R.anim.rotate_end)
        
        /*
        * 바텀 네비게이션 및 툴바의 사용은 onCreate 에서 진행
        * 화면이 전환되거나, NewActivity 로 넘어가더라도 다시 onRestart 되어 동기화 되는 것이 아님
        * */
        /*툴바 설정 */
//        val toolbar : Toolbar = findViewById(R.layout.toolbar)
//        setSupportActionBar(toolbar)

        /* 바텀네비 바인딩 */
        binding.bottomNavigationView.setOnItemSelectedListener {
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
        binding.bottomNavigationView.selectedItemId = R.id.item1 //기본 화면 홈프래그먼트

        /* 플로팅 액션 버튼 */
        binding.fab1.bringToFront()         //플로팅 액션 버튼을 스크롤뷰 앞으로 보내기
        binding.fab1.setOnClickListener {   // 클릭시 NewActicity 로 이동!
            // fab1 애니메이션, 색/아이콘 바꾸기
            if(clicked == false){
                binding.fab1.setIconResource(R.drawable.ic_action_plus_x)
                binding.fab1.setBackgroundColor(Color.WHITE)
                binding.fab1.setIconTintResource(R.color.black)
                binding.fab1.shrink()
            }else{
                binding.fab1.setIconResource(R.drawable.ic_action_plus)
                binding.fab1.setBackgroundColor(Color.parseColor("#ff8f12"))
                binding.fab1.setText("글쓰기")
                binding.fab1.setIconTintResource(R.color.white)
                binding.fab1.extend()
            }
            clicked = !clicked

            // fab2 보여지게 하기
            if(binding.fab2.visibility == View.VISIBLE){
                binding.fab2.visibility = View.INVISIBLE
            }else{
                binding.fab2.visibility = View.VISIBLE
            }
        }

        /* NewActivity로 전환되는 글쓰기 버튼 fab2 */
       binding.fab2.setOnClickListener {
            val intent = Intent(this, NewActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        // 홈 프래그먼트로 귀환시 중고거래 글쓰기가 추가되었을경우 업데이트
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    // 바텀네비 프래그먼트 교체 함수
    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameLayout, fragment)
            .commit()
    }
}