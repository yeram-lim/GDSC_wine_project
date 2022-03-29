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
import kotlinx.android.synthetic.main.fragment_q2.*

class Q2Fragment : Fragment(), View.OnClickListener {
    var answer = "";
    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //앞 프레그먼트에서 받아온 문자열
        answer = answer.plus(arguments?.getString("answer")?:'0')
        return inflater.inflate(R.layout.fragment_q2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        //this: 이 클래스(QuestionFragment)에서 정의내린 것을 사용하겠다는 것.
        q2_option_1.setOnClickListener(this)
        q2_option_2.setOnClickListener(this)
        q2_option_3.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.q2_option_1 -> {
                answer = answer.plus('1')
                navigatingWithAnswer()
            }
            R.id.q2_option_2 -> {
                answer = answer.plus('2')
                navigatingWithAnswer()
            }
            R.id.q2_option_3 -> {
                answer = answer.plus('3')
                navigatingWithAnswer()
            }
        }
    }

    fun navigatingWithAnswer() {
        //소비자가 선택한 선택지를 리스트에 담아 다음 fragment에 넘김
        val bundle : Bundle  = bundleOf("answer" to answer)
        navController.navigate(R.id.action_q2Fragment_to_q3Fragment, bundle)
    }
}
