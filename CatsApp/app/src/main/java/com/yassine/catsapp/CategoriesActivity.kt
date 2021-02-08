package com.yassine.catsapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.yassine.catsapp.repository.Repository

class CategoriesActivity : AppCompatActivity() {

    private lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)

        val categoriesMap = HashMap<String,Int>()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)


        viewModel.getCategories()
        viewModel.myResponseCategory.observe(this, { response ->

            if(response.isSuccessful) {

                response.body()?.listIterator()?.forEach { category ->

                    categoriesMap[category.name] = category.id
                }
            }
        })

        val arrayAdapter:ArrayAdapter<*>
        val categories = mutableListOf(categoriesMap.keys)
        val listView = findViewById<ListView>(R.id.listView)

        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, categories)
        listView.adapter = arrayAdapter

        listView.setOnItemClickListener { parent, _, position, _ ->

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("category", parent.getItemAtPosition(position).toString())
            startActivity(intent)
        }
    }
}