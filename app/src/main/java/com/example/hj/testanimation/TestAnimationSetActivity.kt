package com.example.hj.testanimation

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.hj.testanimation.databinding.ActivityTestAnimationSetBinding

class TestAnimationSetActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityTestAnimationSetBinding;
    private lateinit var rotationAnimator:ObjectAnimator;
    private lateinit var translationAnimator:ObjectAnimator;
    private lateinit var scaleAnimator:ObjectAnimator;
    private lateinit var animatorSet:AnimatorSet
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding= ActivityTestAnimationSetBinding.inflate(layoutInflater);
        val view:View=viewBinding.root;
        setContentView(view);
        viewBinding.animatorSetBuilder.setOnClickListener { animatorSetBuilder() }
        viewBinding.playSequentially.setOnClickListener { playSequentially() }
        viewBinding.playTogether.setOnClickListener { playTogether() }
    }
    private fun playSequentially(){
        rotationAnimator=ObjectAnimator.ofFloat(viewBinding.textView2,"rotation",0f,360f,0f);
        rotationAnimator.duration=1500

        translationAnimator=ObjectAnimator.ofFloat(viewBinding.textView2,"translationY",100f,300f,100f);
        translationAnimator.duration=1500

        scaleAnimator=ObjectAnimator.ofFloat(viewBinding.textView2,"scaleX",0.5f,1.5f,1.0f);
        scaleAnimator.duration=1500

        animatorSet= AnimatorSet();
        animatorSet.playSequentially(rotationAnimator,translationAnimator,scaleAnimator);
        animatorSet.start();
    }
    private fun playTogether(){
        rotationAnimator=ObjectAnimator.ofFloat(viewBinding.textView,"rotation",0f,360f,0f);
        rotationAnimator.repeatMode=ObjectAnimator.REVERSE;
        rotationAnimator.repeatCount=ObjectAnimator.INFINITE;
        rotationAnimator.duration=1500

        translationAnimator=ObjectAnimator.ofFloat(viewBinding.textView,"translationY",100f,300f,100f);
        translationAnimator.repeatMode=ObjectAnimator.REVERSE;
        translationAnimator.repeatCount=ObjectAnimator.INFINITE;
        translationAnimator.duration=1500

        scaleAnimator=ObjectAnimator.ofFloat(viewBinding.textView,"scaleX",0.5f,1.5f,1.0f);
        scaleAnimator.repeatMode=ObjectAnimator.REVERSE;
        scaleAnimator.repeatCount=ObjectAnimator.INFINITE;
        scaleAnimator.duration=1500

         animatorSet= AnimatorSet();
        animatorSet.playTogether(rotationAnimator,translationAnimator,scaleAnimator);
        animatorSet.start();
    }
    private fun animatorSetBuilder(){//
        rotationAnimator=ObjectAnimator.ofFloat(viewBinding.textView1,"rotation",0f,360f,0f);
        rotationAnimator.duration=1500

        translationAnimator=ObjectAnimator.ofFloat(viewBinding.textView1,"translationY",100f,300f,100f);
        translationAnimator.duration=1500

        scaleAnimator=ObjectAnimator.ofFloat(viewBinding.textView1,"scaleX",0.5f,1.5f,1.0f);
        scaleAnimator.duration=1500
        animatorSet= AnimatorSet();
        animatorSet.play(translationAnimator).with(scaleAnimator).after(rotationAnimator);
        animatorSet.start();
    }
}