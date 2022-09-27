package com.example.application

import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.application.databinding.ActivityMainBinding
import com.example.application.db.ProjectDB
import com.example.application.viewmodel.MainViewModel
import com.example.application.viewmodel.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
    internal var loadBar: ProgressBar? = null

    @Inject
    lateinit var fakerDB1: ProjectDB

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory


    //initialize the Custom adataper
    val adapter = ProjectAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_main);

        ///initialize the Components
        (application as MainApplication).applicationComponent.inject(this)

        //get mainViewModel instance using MainViewModelFactory
        mainViewModel = ViewModelProvider(this, mainViewModelFactory).get(MainViewModel::class.java)

        // bind RecyclerView
        val recyclerView = binding?.recyclerview
        loadBar = binding!!.loadBar
        recyclerView!!.setLayoutManager(LinearLayoutManager(this))

        //set recyclerview adapter
        binding.recyclerview.adapter = adapter

        mainViewModel.projectsLiveData.observe(this, Observer {
            // set Project list in adapter
            adapter.setProjectList(it)
        })

//        })
    }

}