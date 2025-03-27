package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val leftImage = findViewById<ImageView>(R.id.leftImageID)
        val rightImage = findViewById<ImageView>(R.id.rightImageID)
        val mainImage = findViewById<ImageView>(R.id.mainImageID)
        val cityText = findViewById<TextView>(R.id.CityTextID)

        cityText.text="Explore Lucknow"

//        val images= arrayOf(
//            R.drawable.college,
//            R.drawable.clock,
//            R.drawable.darwaza,
//            R.drawable.mayawati,
//            R.drawable.bada_imambara,
//        )

        val images = arrayOf(
            Pair(R.drawable.college, "Lucknow University"),
            Pair(R.drawable.clock, "Clock Tower"),
            Pair(R.drawable.darwaza, "Rumi Darwaza"),
            Pair(R.drawable.mayawati, "Ambedkar Park"),
            Pair(R.drawable.bada_imambara, "Bada Imambara"),
        )

        Glide.with(this)
            .load("https://static2.tripoto.com/media/filter/nl/img/1649149/TripDocument/1568134333_9_view_of_the_bada_imambara_complex.jpg.webp")
            .transition(DrawableTransitionOptions.withCrossFade()) // Smooth transition
            .into(mainImage) // Replace with your ImageView


        var index=0
        //mainImage.setImageResource(images[images.size/2])

        leftImage.setOnClickListener {
            index--
            if(index<0){
                index=images.size-1
            }
            mainImage.setImageResource(images[index].first)
            cityText.text=images[index].second       //Changing the textview field to the name of the image
            fadeInImage(mainImage) // Applying fade-in animation
        }

        rightImage.setOnClickListener {
            index++
            if(index==images.size){
                index=0
            }
            mainImage.setImageResource(images[index].first)
            cityText.text=images[index].second     //Changing the textview field to the name of the image
            fadeInImage(mainImage) // Applying fade-in animation
        }










        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun fadeInImage(imageView: ImageView) {
        imageView.alpha = 0f // Start with invisible
        imageView.animate()
            .alpha(1f) // Fade in to full opacity
            .setDuration(500) // Half a second
            .start()
    }

}