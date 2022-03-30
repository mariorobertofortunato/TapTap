package com.example.taptap.fragment

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.taptap.databinding.FragmentMainBinding
import com.example.taptap.model.HighScore
import kotlin.concurrent.timer

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val viewModel by viewModels<ViewModel>()

    private lateinit var scoreView : TextView

    private var timerStart = 10000L
    private var isTimerOn = false


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        scoreView = binding.scoreLabel

        /** Listeners */
        //Main tap button listener
        binding.tapButton.setOnClickListener {
            isTimerOn = true
            startTimer()
            scaler(scoreView,0, 1.5f)
            viewModel.increaseScore()
        }
        //HighScores button Listener
        binding.highScoreButton.setOnClickListener {

            val action = MainFragmentDirections.actionMainFragmentToScoreFragment()
            findNavController().navigate(action)

            //countDownTimer?.cancel()
        }

        /** Observer */
        viewModel.currentScore.observe(viewLifecycleOwner) { observedScore ->
            binding.scoreLabel.text = "SCORE : $observedScore"
        }
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
            }
        }.start()

    }

    private fun displayTimer() {
        val timeWithDecimals = (timerStart / 100) * 0.1
        // toFloat() perchè altrimenti la visualizzazione sbarella tutta
        binding.timer.text = "TIME : ${timeWithDecimals.toFloat()}"
    }

    companion object {
        var countDownTimer : CountDownTimer ?= null

    }

    private fun scaler(view : TextView, delay : Long, scaleValue : Float) {
        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, scaleValue)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, scaleValue)
        val animator = ObjectAnimator.ofPropertyValuesHolder(
            view, scaleX, scaleY)
        animator.repeatCount = ObjectAnimator.INFINITE
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.startDelay = delay
        animator.start()
    }


}
