package com.example.challengeweek2


import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.view.WindowManager
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.challengeweek2.databinding.ActivityMainBinding
import eightbitlab.com.blurview.RenderScriptBlur
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        intentIg()
        animation()
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            dialogIg()
        }, 10000)
//        glassmorphism()
    }

//    private fun glassmorphism(){
//
//        val viewGroup = findViewById<ViewGroup>(R.id.glass)
//        binding.blurView.setupWith(viewGroup,RenderScriptBlur(this))
//            .setBlurRadius(20f).setBlurEnabled(true).setBlurAutoUpdate(true)
//
//        binding.blurView.setOutlineProvider(ViewOutlineProvider.BACKGROUND)
//        binding.blurView.setClipToOutline(true)
//    }

    private fun dialogIg() {
        val dialog = Dialog(this)
        // set view
        dialog.setContentView(R.layout.instruction)

        // set layout
        dialog.window!!.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT
        )
        // Set background
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        // show dialog
        dialog.show()
    }

    private fun animation(){
        val ttb = AnimationUtils.loadAnimation(this,R.anim.ttb)
        val btt = AnimationUtils.loadAnimation(this,R.anim.btt)
        val rtl = AnimationUtils.loadAnimation(this,R.anim.rtl)
        val ltr = AnimationUtils.loadAnimation(this,R.anim.ltr)
        val fadein = AnimationUtils.loadAnimation(this,R.anim.fadein)

        binding.etInputLayout.startAnimation(ttb)
        binding.radioGroup.startAnimation(ltr)
        binding.switches.startAnimation(rtl)
        binding.btnCalc.startAnimation(btt)
        binding.tvAmount.startAnimation(btt)
        binding.image.startAnimation(fadein)
        binding.blurView.startAnimation(fadein)
        binding.glass.startAnimation(fadein)
    }

    private fun intentIg(){
       binding.btnCalc.setOnClickListener {
           val intent = Intent().apply{
               action = Intent.ACTION_VIEW
               setData(Uri.parse("https://www.instagram.com/faizalfalakh/"))
           }
           startActivity(intent)
       }

    }
}