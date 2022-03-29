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
import kotlinx.android.synthetic.main.fragment_q4.*

class Q4Fragment : Fragment(), View.OnClickListener {
    var answer = "";
    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        answer = answer.plus(arguments?.getString("answer")?:'0')
        return inflater.inflate(R.layout.fragment_q4, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        q4_option_1.setOnClickListener(this)
        q4_option_2.setOnClickListener(this)
        q4_option_3.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.q4_option_1 -> {
                answer = answer.plus('1')
                navigatingWithAnswer()
            }
            R.id.q4_option_2 -> {
                answer = answer.plus('2')
                navigatingWithAnswer()
            }
            R.id.q4_option_3 -> {
                answer = answer.plus('3')
                navigatingWithAnswer()
            }
        }
    }

    fun navigatingWithAnswer() {
        val bundle : Bundle = bundleOf("answer" to answer)
        navController.navigate(R.id.action_q4Fragment_to_q5Fragment, bundle)
    }
}