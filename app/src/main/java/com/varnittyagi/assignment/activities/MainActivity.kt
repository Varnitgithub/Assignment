package com.varnittyagi.assignment.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import com.varnittyagi.assignment.R
import com.varnittyagi.assignment.databinding.MainActivityBinding

class MainActivity : ComponentActivity() {
    private lateinit var binding: MainActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DataBindingUtil.setContentView(this, R.layout.main_activity)

binding.moreGames.setOnClickListener{
    startActivity(Intent(this,InfoScreen::class.java))
}
    }
}