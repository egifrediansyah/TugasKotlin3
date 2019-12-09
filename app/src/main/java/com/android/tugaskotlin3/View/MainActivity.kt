package com.android.tugaskotlin3.View

import android.content.Intent
import android.os.Bundle
import android.view.animation.*
import android.widget.ImageView
import android.widget.TextView
import android.widget.ViewFlipper
import androidx.appcompat.app.AppCompatActivity
import com.android.tugaskotlin3.Pagging.MenuListActivity
import com.android.tugaskotlin3.R
import kotlinx.android.synthetic.main.activity_main.*
import render.animations.*
class MainActivity : AppCompatActivity() {

//    lateinit var viewflipper : ViewFlipper
//
//    val images = intArrayOf(R.drawable.staea,R.drawable.stb,R.drawable.stea)




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        img_maps.setOnClickListener {
            startActivity(Intent(this, MapsActivity::class.java))
        }
        menu.setOnClickListener {
            startActivity(Intent(this, MenuListActivity::class.java))
        }
        val animfade = AnimationUtils.loadAnimation(this, R.anim.rotate)
        img_maps.startAnimation(animfade)
        menu.startAnimation(animfade)
        val animimg = AnimationUtils.loadAnimation(this, R.anim.zoom_in)
        imgbg.startAnimation(animimg)
        val animtext = AnimationUtils.loadAnimation(this,R.anim.slide_down)
        tvtext.startAnimation(animtext)
//            viewflipper = findViewById(R.id.v_flipper)

//       for (image in images){
//           flip_image(image)
//        }
    }

//    fun flip_image(i : Int) {
//        val view = ImageView(this)
//        view.setBackgroundResource(i)
//        viewflipper.addView(view)
//        viewflipper.setFlipInterval(3000)
//        viewflipper.setAutoStart(true)
//        viewflipper.setInAnimation(this , android.R.anim.slide_in_left)
//        viewflipper.setOutAnimation(this , android.R.anim.slide_out_right)
//}
}