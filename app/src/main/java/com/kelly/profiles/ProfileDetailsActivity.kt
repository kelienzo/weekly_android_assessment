package com.kelly.profiles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kelly.profiles.databinding.ActivityProfileDetailsBinding

class ProfileDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityProfileDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            profileImage.setImageResource(intent.getStringExtra("profileImage")!!.toInt())
            firstName.text = intent.getStringExtra("firstName")
            lastName.text = intent.getStringExtra("lastName")
        }
    }
}