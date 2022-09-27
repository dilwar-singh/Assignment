package com.example.application

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.application.databinding.LayoutItemBinding
import com.example.application.model.Project
import com.example.application.view.DetailActivity

class ProjectAdapter(var mContext: Context)  : RecyclerView.Adapter<MainViewHolder>() {

    var projects = mutableListOf<Project>()

    fun setProjectList(projects: List<Project>){
        this.projects = projects.toMutableList()
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        val itemBinding = DataBindingUtil.inflate<LayoutItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.layout_item, parent, false
        )

        val  holder = MainViewHolder(itemBinding)
        holder.itemView.setOnClickListener {
            val intent = Intent(mContext, DetailActivity::class.java)
            intent.putExtra("project", projects[viewType])
            // start your next activity
            mContext.startActivity(intent)
        }
        return holder

        return MainViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val project = projects[position]
        holder.binding.project = project
        Glide.with(holder.itemView.context).load(project.owner?.avatar_url).placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.binding.avatar)
    }

    override fun getItemCount(): Int {
        return projects.size
    }
}

class MainViewHolder(val binding: LayoutItemBinding) : RecyclerView.ViewHolder(binding.root) {}