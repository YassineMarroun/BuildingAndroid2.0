package com.yassine.kidsoperationsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var ivCharacter = findViewById<ImageView>(R.id.imageView_Character)
        var etName = findViewById<EditText>(R.id.txt_name)
        var tvBestScore = findViewById<TextView>(R.id.textView_BestScore)

        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setIcon(R.mipmap.ic_launcher)

        var randomNumber = Math.random() * 10
        var id: Int

        if (randomNumber == 0.toDouble() || randomNumber == 10.toDouble()) {
            id = resources.getIdentifier("mango", "drawable", packageName)
            ivCharacter.setImageResource(id)
        } else if (randomNumber == 1.toDouble() || randomNumber == 9.toDouble()) {
            id = resources.getIdentifier("fresa", "drawable", packageName)
            ivCharacter.setImageResource(id)
        } else if (randomNumber == 2.toDouble() || randomNumber == 8.toDouble()) {
            id = resources.getIdentifier("manzana", "drawable", packageName)
            ivCharacter.setImageResource(id)
        } else if (randomNumber == 3.toDouble() || randomNumber == 7.toDouble()) {
            id = resources.getIdentifier("sandia", "drawable", packageName)
            ivCharacter.setImageResource(id)
        } else if (randomNumber == 4.toDouble() || randomNumber == 5.toDouble() || randomNumber == 6.toDouble()) {
            id = resources.getIdentifier("mango", "drawable", packageName)
            ivCharacter.setImageResource(id)
        }
    }
}
