package com.example.mvvmweatherexample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.GeneratedAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmweatherexample.R
import com.example.mvvmweatherexample.adapter.SearchAdapter
import com.example.mvvmweatherexample.model.Location
import com.example.mvvmweatherexample.viewmodel.SearchActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel:SearchActivityViewModel

    private lateinit var adapter: SearchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel= ViewModelProvider(this).get(SearchActivityViewModel::class.java)

        ivSearch.setOnClickListener {
          viewModel.searchLocation(etSearch.text.toString())
            //Toast.makeText(this,"Clicked",Toast.LENGTH_SHORT).show()
        }

        viewModel.showProgress.observe(this, Observer {
            if(it){
                pgSearch.visibility= View.VISIBLE
            }
            else{
                pgSearch.visibility= View.GONE
            }
        })

        viewModel.locationList.observe(this, Observer {
          adapter.setLocation(it)
        })
        adapter=SearchAdapter(this)
        rvSearch.adapter=adapter


    }
}
