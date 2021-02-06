package com.yassine.catsapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import com.yassine.catsapp.repository.Repository

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getCategories()
        viewModel.myResponseCategory.observe(this, { response ->

            if(response.isSuccessful) {
                Log.d("Response", response.body().toString())
                //id.toString())
                //Log.d("Response", response.body()?.name.toString())
                //textView.text = response.body()?.name!!
            } else {
                Log.d("Response", response.errorBody().toString())
                textView.text = response.code().toString()
            }
        })

        viewModel.getRandomCat()
        viewModel.myResponseRandomCat.observe(this, {response ->

            val imageView = findViewById<ImageView>(R.id.imageView)

            if(response.isSuccessful) {

                val imageUrl = response.body()?.first()?.url
                Picasso.with(this).load(imageUrl).into(imageView)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_actionbar, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.share -> {
                val sendIntent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, "Share this funny kitten with someone to make him laugh!")
                }

                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}