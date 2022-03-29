package com.example.winetest.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.winetest.R
import kotlinx.android.synthetic.main.fragment_q1.*

class Q1Fragment : Fragment(), View.OnClickListener {
    lateinit var navController: NavController
    var answer = "";

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_q1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        //this: 이 클래스(QuestionFragment)에서 정의내린 것을 사용하겠다는 것.
        q1_option_1.setOnClickListener(this)
        q1_option_2.setOnClickListener(this)
        q1_option_3.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        //?를 붙이는 이유: null이 들어오면 null 반환
        when(v?.id) {
            R.id.q1_option_1 -> {
                answer = answer.plus('1')
                navigatingWithAnswer()
            }
            R.id.q1_option_2 -> {
                answer = answer.plus('2')
                navigatingWithAnswer()
            }
            R.id.q1_option_3 -> {
                answer = answer.plus('3')
                navigatingWithAnswer()
            }
        }
    }

    fun navigatingWithAnswer() {
        //소비자가 선택한 선택지를 리스트에 담아 다음 fragment에 넘트
        val bundle : Bundle  = bundleOf("answer" to answer)
        navController.navigate(R.id.action_q1Fragment_to_q2Fragment, bundle)
    }
}