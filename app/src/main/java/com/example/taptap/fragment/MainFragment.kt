package com.example.taptap.fragment

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.taptap.databinding.FragmentMainBinding
import com.example.taptap.model.HighScore

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val viewModel by viewModels<ViewModel>()

    private lateinit var countDownTimer: CountDownTimer
    private var timerStart = 10000L

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentMainBinding.inflate(layoutInflater)

        /** Listeners */
        //Main tap button listener
        binding.tapButton.setOnClickListener {
            binding.scoreLabel.isVisible = true
            viewModel.increaseScore()
            startTimer()
        }
        //HighScores button Listener
        binding.highScoreButton.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToScoreFragment()
            findNavController().navigate(action)
        }

        /** Observer */
       viewModel.currentScore.observe(viewLifecycleOwner) { observedScore ->
            binding.scoreLabel.text = observedScore.toString()
        }

        return binding.root
    }


    /** Timer */
    private fun startTimer() {

        countDownTimer = object : CountDownTimer(timerStart, 10) {

            override fun onTick(p0: Long) {
                timerStart = p0
                displayTimer()
            }

            override fun onFinish() {
                binding.tapButton.isClickable = false
                cancel()
            }
        }
        countDownTimer.start()
    }

    private fun displayTimer() {
        val timeWithDecimals = (timerStart / 100) * 0.1
        // toFloat() perchè altrimenti la visualizzazione sbarella tutta
        binding.timer.text = "${timeWithDecimals.toFloat()}"
    }


}