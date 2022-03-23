package com.example.taptap.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.taptap.databinding.FragmentMainBinding
import com.example.taptap.model.HighScore

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val viewModel by viewModels<ViewModel>()

    private lateinit var highScore: HighScore
    private var currentScore = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(layoutInflater)




        binding.tapButton.setOnClickListener {
            /**  P S E U D O C O D E */
            startTimer()
                while (timer > 0) {
                    currentScore++
                }
        }

        binding.highScoreButton.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToScoreFragment()
            findNavController().navigate(action)
        }


        return binding.root
    }


}