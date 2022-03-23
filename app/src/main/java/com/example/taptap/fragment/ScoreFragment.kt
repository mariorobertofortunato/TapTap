package com.example.taptap.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.taptap.databinding.FragmentScoreBinding

class ScoreFragment : Fragment() {

    private lateinit var binding: FragmentScoreBinding
    private val viewModel by viewModels<ViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        binding = FragmentScoreBinding.inflate(layoutInflater)

        viewModel.getHighScores()

        val adapter = Adapter()
        binding.recycler.adapter = adapter
        viewModel.highScoreList.observe(viewLifecycleOwner) { highScoresList ->
            adapter.submitList(highScoresList)
        }

        return binding.root
    }


}