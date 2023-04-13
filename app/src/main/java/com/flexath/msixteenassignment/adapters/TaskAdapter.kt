package com.flexath.msixteenassignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.flexath.msixteenassignment.R
import com.flexath.msixteenassignment.delegates.MainItemDelegate
import com.flexath.msixteenassignment.views.viewholders.ProfileImageViewHolder
import com.flexath.msixteenassignment.views.viewholders.TaskViewHolder
import kotlinx.android.synthetic.main.view_holder_profile_image_list.view.*

class TaskAdapter(private val delegate: MainItemDelegate) : RecyclerView.Adapter<TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewpod_task_item, parent, false)
        return TaskViewHolder(view,delegate)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 10
    }
}