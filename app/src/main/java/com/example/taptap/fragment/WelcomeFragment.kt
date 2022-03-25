package com.example.taptap.fragment

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.compose.animation.core.infiniteRepeatable
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.taptap.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding

    //Vector Letters declaration
    lateinit var letterT : ImageView
    lateinit var letterA : ImageView
    lateinit var letterP : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentWelcomeBinding.inflate(layoutInflater)

        //Vector Letters Init
        letterT = binding.t
        letterA = binding.a
        letterP = binding.p

        //Button anim
        buttonAnimation()
        tScaler()
        aScaler()
        pScaler()

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

    private fun tScaler() {
        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 1.5f)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 1.5f)
        val animator = ObjectAnimator.ofPropertyValuesHolder(
            letterT, scaleX, scaleY)
        animator.repeatCount = ObjectAnimator.INFINITE
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.start()
    }

    private fun aScaler() {
        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 1.25f)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 1.25f)
        val animator = ObjectAnimator.ofPropertyValuesHolder(
            letterA, scaleX, scaleY)
        animator.repeatCount = ObjectAnimator.INFINITE
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.startDelay = 100
        animator.start()
    }

    private fun pScaler() {
        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 1.5f)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 1.5f)
        val animator = ObjectAnimator.ofPropertyValuesHolder(
            letterP, scaleX, scaleY)
        animator.repeatCount = ObjectAnimator.INFINITE
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.startDelay = 200
        animator.start()
    }


}


