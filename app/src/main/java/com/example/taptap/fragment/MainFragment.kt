package com.example.taptap.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.taptap.databinding.FragmentMainBinding
import com.example.taptap.model.HighScore

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val viewModel by viewModels<ViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(layoutInflater)

        val currentScore = HighScore (0, "Ciccio", 1000)
        val currentScore2 = HighScore (1, "franco", 500)
        val currentScore3 = HighScore (2, "minchio", 1000)
        val currentScore4 = HighScore (3, "stronzo", 1000)

        /** questa è una prova*/
        binding.tapButton.setOnClickListener {
            viewModel.insertHighScore(currentScore)
            viewModel.insertHighScore(currentScore2)
            viewModel.insertHighScore(currentScore3)
            viewModel.insertHighScore(currentScore4)
        }

        binding.highScoreButton.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToScoreFragment()
            findNavController().navigate(action)
        }


        return binding.root
    }


}