package com.flexath.msixteenassignment.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.flexath.msixteenassignment.R
import com.flexath.msixteenassignment.adapters.ProfileImageAdapter
import com.flexath.msixteenassignment.adapters.ProfileImageItemDecoration
import com.flexath.msixteenassignment.adapters.TaskAdapter
import com.flexath.msixteenassignment.delegates.MainItemDelegate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),MainItemDelegate {

    private lateinit var mProfileImageAdapter:ProfileImageAdapter
    private lateinit var mTaskAdapter:TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpProfileImageRecyclerView()
        setUpTaskRecyclerView()
        setUpListeners()
    }

    private fun setUpListeners() {
        btnBackMain.setOnClickListener {
            finish()
        }
    }

    private fun setUpProfileImageRecyclerView() {
        mProfileImageAdapter = ProfileImageAdapter(this)
        rvProfileImage.adapter = mProfileImageAdapter
        rvProfileImage.addItemDecoration(ProfileImageItemDecoration())
        rvProfileImage.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
    }

    private fun setUpTaskRecyclerView() {
        mTaskAdapter = TaskAdapter(this)
        rvTask.adapter = mTaskAdapter
        rvTask.layoutManager = LinearLayoutManager(this)
    }

    override fun onTapProfileImage() {
        startActivity(ProfileScreenActivity.newIntent(this))
    }

    override fun onTapTask() {
        startActivity(TaskScreenActivity.newIntent(this))
    }
}