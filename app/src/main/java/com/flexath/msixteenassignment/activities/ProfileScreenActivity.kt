package com.flexath.msixteenassignment.activities

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.flexath.msixteenassignment.R
import com.flexath.msixteenassignment.adapters.TaskAdapter
import com.flexath.msixteenassignment.delegates.MainItemDelegate
import kotlinx.android.synthetic.main.activity_profile_screen.*

class ProfileScreenActivity : AppCompatActivity(),MainItemDelegate {

    private val titleList = listOf("Project Tasks","Contacts","About You","Jobs")
    private lateinit var mTaskProfileAdapter:TaskAdapter

    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context,ProfileScreenActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_screen)

        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        window.setDimAmount(0f)

        changeStatusBar()

        ivProfile.bringToFront()
        setUpTitleTabLayout()
        setUpTaskProfileRecyclerView()
        setUpListeners()
    }

    private fun changeStatusBar() {
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(this, android.R.color.transparent)
        window.decorView.systemUiVisibility = 0
    }

    private fun setUpTitleTabLayout() {
        titleList.forEach {
            tlTitleProfile.newTab().apply {
                text = it
                tlTitleProfile.addTab(this)
            }
        }
    }

    private fun setUpListeners() {
        btnCancelProfile.setOnClickListener {
            finish()
        }
    }

    private fun setUpTaskProfileRecyclerView() {
        mTaskProfileAdapter = TaskAdapter(this)
        rvTaskProfile.adapter = mTaskProfileAdapter
        rvTaskProfile.layoutManager = LinearLayoutManager(this)
    }

    override fun onTapProfileImage() {

    }

    override fun onTapTask() {
        startActivity(TaskScreenActivity.newIntent(this))
    }
}