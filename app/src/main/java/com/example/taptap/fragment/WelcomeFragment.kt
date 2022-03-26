package com.example.taptap.fragment

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.taptap.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding

    //Vector Letters declaration
    private lateinit var letterT1 : ImageView
    private lateinit var letterA1 : ImageView
    private lateinit var letterP1 : ImageView
    private lateinit var letterT2 : ImageView
    private lateinit var letterA2 : ImageView
    private lateinit var letterP2 : ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = FragmentWelcomeBinding.inflate(layoutInflater)

        //Vector Letters Init
        letterT1 = binding.t1
        letterA1 = binding.a1
        letterP1 = binding.p1
        letterT2 = binding.t2
        letterA2 = binding.a2
        letterP2 = binding.p2

        //Animation (custom btn + letters)
        buttonAnimation()
        tScaler(letterT1,0)
        aScaler(letterA1,100)
        pScaler(letterP1,200)
        tScaler(letterT2,150)
        aScaler(letterA2,250)
        pScaler(letterP2,300)

        // Navigate to MainFrag
        binding.customButton.setOnClickListener {
            val action = WelcomeFragmentDirections.actionWelcomeFragmentToMainFragment()
            findNavController().navigate(action)
        }

        return binding.root

    }

    /** ANIMATION */

    private fun buttonAnimation () {
        binding.customButton.alpha = 0f
        binding.customButton.translationY = 4000f
        binding.customButton.animate().alpha(1f).translationY(-1f).duration = 1500
    }

    private fun tScaler(letter : ImageView, delay : Long) {
        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 1.5f)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 1.5f)
        val animator = ObjectAnimator.ofPropertyValuesHolder(
            letter, scaleX, scaleY)
        animator.repeatCount = ObjectAnimator.INFINITE
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.startDelay = delay
        animator.start()
    }

    private fun aScaler(letter : ImageView, delay : Long) {
        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 1.25f)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 1.25f)
        val animator = ObjectAnimator.ofPropertyValuesHolder(
            letter, scaleX, scaleY)
        animator.repeatCount = ObjectAnimator.INFINITE
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.startDelay = delay
        animator.start()
    }

    private fun pScaler(letter : ImageView, delay : Long) {
        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 1.5f)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 1.5f)
        val animator = ObjectAnimator.ofPropertyValuesHolder(
            letter, scaleX, scaleY)
        animator.repeatCount = ObjectAnimator.INFINITE
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.startDelay = delay
        animator.start()
    }






}


