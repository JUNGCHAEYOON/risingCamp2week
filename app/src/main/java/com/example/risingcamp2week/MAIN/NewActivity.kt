package com.example.risingcamp2week.MAIN

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.risingcamp2week.databinding.ActivityNewBinding

class NewActivity : AppCompatActivity() {
    //뷰 바인딩
    private lateinit var binding : ActivityNewBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /* 뷰 바인딩으로 setContentView */
        binding = ActivityNewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /* shared preferences 로 글제목, 글내용, 이미지 저장 */


        /* 툴바 설정 */
        var toolbar : Toolbar = binding.newtoolbar
        setSupportActionBar(toolbar)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)

        /* 이미지 불러오기 */
        val getAction = registerForActivityResult(
            ActivityResultContracts.GetContent(),
            ActivityResultCallback { uri ->
                //이미지 선택 완료시 화면에 맞게 크기 조절!
                binding.imageView.setImageURI(uri)
                binding.imageView.layoutParams.width= 1020
                binding.imageView.layoutParams.height= 1020
            }
        )
        binding.imageView.setOnClickListener{
            getAction.launch("image/*")
        }

        /* 작성글 homefragment 로 전달 shared preferences */

        /* 툴바 내부 완료 버튼 클릭으로 글쓰기 */
        binding.finishButton.setOnClickListener{
            Toast.makeText(this, "작성 완료!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
        // 글을 쓰다가 뒤로 갔을때, 완료버튼 미클릭 시
        // 해당 작성 내용이 그대로 유지됨
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}