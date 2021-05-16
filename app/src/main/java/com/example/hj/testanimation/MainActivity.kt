package com.example.hj.testanimation

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.hj.testanimation.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(),View.OnTouchListener {
    private lateinit var viewBinding:ActivityMainBinding;
    private lateinit var animator: ValueAnimator;
    private lateinit var objectAnimator: ObjectAnimator;
    private lateinit var gestureDetector: GestureDetector;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding= ActivityMainBinding.inflate(layoutInflater);
        val view:View=viewBinding.root;
        setContentView(view);

        gestureDetector= GestureDetector(baseContext,MySimpleGestureListener())
        viewBinding.myText.setOnTouchListener(this);
        viewBinding.myButton.setOnClickListener {
          //  doValueAnimator();\
            doObjectAnimator();
        }
        viewBinding.myText.setOnClickListener {
            Toast.makeText(baseContext,"哎呀，我被点击了",Toast.LENGTH_SHORT).show();
        }
        viewBinding.stopButton.setOnClickListener {
//            if(this::animator.isInitialized){
//                animator.cancel()
//            }
            if(this::objectAnimator.isInitialized){
                objectAnimator.cancel()
            }
        }
    }
    private fun doValueAnimator(){
        animator=ValueAnimator.ofInt(400);
        animator.addUpdateListener {
            val currentValue:Int=it.getAnimatedValue() as Int;
            viewBinding.myText.layout(viewBinding.myText.left,currentValue,viewBinding.myText.right,currentValue+viewBinding.myText.height)
        }
        animator.repeatCount=ValueAnimator.INFINITE;
        animator.repeatMode=ValueAnimator.REVERSE;
        animator.duration=2000;
        animator.start();
    }
    private fun doObjectAnimator(){
        objectAnimator= ObjectAnimator.ofFloat(viewBinding.myText,"translationY",50f,200f,0f);
        objectAnimator.duration=2000;
        objectAnimator.repeatMode=ObjectAnimator.REVERSE;
        objectAnimator.repeatCount=ObjectAnimator.INFINITE;
        objectAnimator.start();
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        return gestureDetector.onTouchEvent(event);
    }
    inner class MySimpleGestureListener: GestureDetector.SimpleOnGestureListener() {
        override fun onDown(e: MotionEvent?): Boolean {
            return super.onDown(e)
        }

        override fun onShowPress(e: MotionEvent?) {
            super.onShowPress(e)
        }

        override fun onSingleTapUp(e: MotionEvent?): Boolean {
            return super.onSingleTapUp(e)
        }

        override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
            return super.onScroll(e1, e2, distanceX, distanceY)
        }

        override fun onLongPress(e: MotionEvent?) {
            super.onLongPress(e)
        }

        override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
            return super.onFling(e1, e2, velocityX, velocityY)
        }

        override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
            return super.onSingleTapConfirmed(e)
        }

        override fun onDoubleTap(e: MotionEvent?): Boolean {
            return super.onDoubleTap(e)
        }

        override fun onDoubleTapEvent(e: MotionEvent?): Boolean {
            return super.onDoubleTapEvent(e)
        }
    }
}