package com.example.risingcamp2week.FRAGMENT

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.risingcamp2week.MAIN.HomeAdapter
import com.example.risingcamp2week.MAIN.HomeItem
import com.example.risingcamp2week.R
import com.example.risingcamp2week.SHARED.App

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /* 프래그먼트 에서 리사이클러뷰 사용하기 */
        // 리사이클러뷰 불러오기
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

        // 데이터 생성 sharedpreference로 교체 예정
        val homeItemList = ArrayList<HomeItem>()
        homeItemList.add(HomeItem("킥보드","30000","싸게 팝니다."))
        homeItemList.add(HomeItem("자전거","100000","비싸게 팝니다."))
        
        // sharedpreference로 추가한 부분
        homeItemList.add(HomeItem(App.prefs.title.toString(),App.prefs.price.toString(),App.prefs.info.toString()))

        // 어댑터 생성
        val homeAdapter = HomeAdapter(homeItemList)
        homeAdapter.notifyDataSetChanged()

        // 데이터를 어댑터 안에 넣기, fragment라서 getContext() 넣음 맞는지는 모르겠음
        recyclerView.adapter = homeAdapter
        recyclerView.layoutManager = LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false)
        // recyclerview 의 어댑터로 설정

    }
}