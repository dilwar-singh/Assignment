package com.example.application.view

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.application.R
import com.example.application.model.Project

class DetailActivity : AppCompatActivity() {

    private val nameTxt: TextView
        get() = findViewById(R.id.name)
    private val fullNameTxt: TextView
        get() = findViewById(R.id.name)
    private val typeTxt: TextView
        get() = findViewById(R.id.type)
    private val loginTxt: TextView
        get() = findViewById(R.id.login)
    private val avatarURL: ImageView
        get() = findViewById(R.id.avatar)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail);


        val bundle: Bundle? = intent.extras
        val project: Project?
        bundle?.apply {
            //Parcelable Data
            project = getParcelable("project")

            nameTxt.text = project?.name
            fullNameTxt.text = project?.full_name
            typeTxt.text = project?.owner?.type
            loginTxt.text = project?.owner?.login
            Glide.with(baseContext).load(project?.owner?.avatar_url)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(avatarURL)

        }
    }
}