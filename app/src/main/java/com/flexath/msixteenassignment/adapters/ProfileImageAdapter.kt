package com.flexath.msixteenassignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.flexath.msixteenassignment.R
import com.flexath.msixteenassignment.delegates.MainItemDelegate
import com.flexath.msixteenassignment.views.viewholders.ProfileImageViewHolder
import kotlinx.android.synthetic.main.view_holder_profile_image_list.view.*

class ProfileImageAdapter(private val delegate: MainItemDelegate) : RecyclerView.Adapter<ProfileImageViewHolder>() {

    private val profileImageList = listOf(
        R.drawable.aungthiha,
        R.drawable.ath2,
        R.drawable.ath3,
        R.drawable.plus
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileImageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_profile_image_list, parent, false)
        return ProfileImageViewHolder(view,delegate)
    }

    override fun onBindViewHolder(holder: ProfileImageViewHolder, position: Int) {
        val profileImage = profileImageList[position]
        holder.itemView.ivProfileImage.setImageResource(profileImage)

        holder.itemView.setOnClickListener {
            if(holder.adapterPosition == profileImageList.lastIndex) {
                delegate.onTapTask()
            } else {
                delegate.onTapProfileImage()
            }
        }
    }

    override fun getItemCount(): Int {
        return profileImageList.size
    }
}