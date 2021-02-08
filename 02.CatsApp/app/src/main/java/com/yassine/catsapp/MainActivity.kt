@file:Suppress("DEPRECATION")
package com.yassine.catsapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import com.yassine.catsapp.repository.Repository

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : MainViewModel
    private var imageUrl = ""
    private var textFact = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.getRandomCat()
        viewModel.myResponseRandomCat.observe(this, {response ->

            val imageView = findViewById<ImageView>(R.id.imageView)
            val textView2 = findViewById<TextView>(R.id.textView2)

            if(response.isSuccessful) {

                imageUrl = response.body()?.first()?.url?:""
                Picasso.with(this).load(imageUrl).into(imageView)

                textFact = "ID: " + response.body()?.first()?.id.toString() +
                           "\nLink: " + response.body()?.first()?.url.toString() +
                           "\nBreeds: " + response.body()?.first()?.breeds.toString() +
                           "\nCategory: " + response.body()?.first()?.categories.toString()
                textView2.text = textFact
            }
        })

        clickGetNewButton()
        clickCategoriesButton()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_actionbar, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.share -> {

                val imageView = findViewById<ImageView>(R.id.imageView)
                val bitmap = imageView.drawable.toBitmap()
                val bitmapPath = MediaStore.Images.Media.insertImage(this.contentResolver, bitmap, "Cat", null)
                val uri = Uri.parse(bitmapPath)

                val intent = Intent()
                intent.type = "image/*"
                intent.putExtra(Intent.EXTRA_TEXT, textFact)
                intent.putExtra(Intent.EXTRA_STREAM, uri)

                intent.action = Intent.ACTION_SEND
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)

                val chooseIntent = Intent.createChooser(intent, "")
                startActivity(chooseIntent)
            }
            R.id.save -> {

                val imageView = findViewById<ImageView>(R.id.imageView)
                val bitmap = imageView.drawable.toBitmap()
                MediaStore.Images.Media.insertImage(this.contentResolver, bitmap, "Cat", null)

                Toast.makeText(this, "Image saved in Photo Gallery", Toast.LENGTH_LONG).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }


    //Method for Get new button
    private fun clickGetNewButton() {
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            viewModel.getRandomCat()
        }
    }

    //Method for Categoriesbutton
    private fun clickCategoriesButton() {
        val button2 = findViewById<Button>(R.id.button2)

        button2.setOnClickListener {
            val intent = Intent(this, CategoriesActivity::class.java)
            startActivity(intent)
        }

        //val category = intent.getBundleExtra("category")
        //button2.text = category.toString()
    }
}