package com.croworc.android.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.croworc.android.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // We'll be using View Binding in this app, so we need a variable for the binding object
    // which will get created in onCreate()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflate the layout with a static method of the binding class and assign the returned
        // binding object reference to the field
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners() // sets the OnClickListener for all the boxes and the layout itself
    }

    private fun setListeners() {
        val clickableViews: List<View> =
                listOf(binding.boxOneText, binding.boxTwoText, binding.boxThreeText,
                    binding.boxFourText, binding.boxFiveText, binding.constraintLayout,
                    binding.redButton, binding.yellowButton, binding.greenButton)

        clickableViews.forEach { view ->
            view.setOnClickListener { makeColored(view) }
        }
    }

    private fun makeColored(view: View) {
        when (view.id) {
            // Boxes using Color class colors for background:
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text  -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_text  -> view.setBackgroundResource(android.R.color.holo_blue_bright)

            // Buttons using custom colors for background
            R.id.red_button    -> view.setBackgroundResource(R.color.my_red)
            R.id.yellow_button -> view.setBackgroundResource(R.color.my_yellow)
            R.id.green_button  -> view.setBackgroundResource(R.color.my_green)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

}
