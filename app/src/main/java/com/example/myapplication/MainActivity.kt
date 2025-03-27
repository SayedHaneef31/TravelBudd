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


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val leftImage = findViewById<ImageView>(R.id.leftImageID)
        val rightImage = findViewById<ImageView>(R.id.rightImageID)
        val mainImage = findViewById<ImageView>(R.id.mainImageID)
        val cityText = findViewById<TextView>(R.id.CityTextID)

        cityText.text="Lucknow"

        val images= arrayOf(
            R.drawable.college,
            R.drawable.clock,
            R.drawable.darwaza,
            R.drawable.mayawati,
            R.drawable.bada_imambara,
        )
        Glide.with(this)
            .load("https://static2.tripoto.com/media/filter/nl/img/1649149/TripDocument/1568134333_9_view_of_the_bada_imambara_complex.jpg.webp48622")
            .into(mainImage) // Replace with your ImageView


        var index=0
        //mainImage.setImageResource(images[images.size/2])

        leftImage.setOnClickListener {
            index--
            if(index<0){
                index=images.size-1
            }
            mainImage.setImageResource(images[index])
        }

        rightImage.setOnClickListener {
            index++
            if(index==images.size){
                index=0
            }
            mainImage.setImageResource(images[index])
        }










        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}