package com.flexath.msixteenassignment.views.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.flexath.msixteenassignment.delegates.MainItemDelegate
import kotlinx.android.synthetic.main.viewpod_task_item.view.*

class TaskViewHolder(itemView: View,private val delegate: MainItemDelegate) : RecyclerView.ViewHolder(itemView) {

    init {
        setUpListeners()
    }

    private fun setUpListeners() {
        itemView.ivProfileImageTask.setOnClickListener {
            delegate.onTapProfileImage()
        }

        itemView.setOnClickListener {
            delegate.onTapTask()
        }
    }
}