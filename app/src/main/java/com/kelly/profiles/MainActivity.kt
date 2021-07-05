package com.kelly.profiles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kelly.profiles.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnProfileClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var profileAdapter: ProfileAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val profiles: List<ProfileModels> = listOf(
            ProfileModels(
                R.drawable.ic_prof_1, "Gareth", "Johnson"
            ),
            ProfileModels(
                R.drawable.ic_prof_2, "Captain", "Sparks"
            ),
            ProfileModels(
                R.drawable.ic_prof_3, "Colver", "David"
            ),
            ProfileModels(
                R.drawable.ic_prof_4, "Sandler", "Hover"
            ),
            ProfileModels(
                R.drawable.ic_prof_5, "South", "North"
            ),
            ProfileModels(
                R.drawable.ic_prof_6, "Calvert", "Lewin"
            ),
            ProfileModels(
                R.drawable.ic_prof_7, "Woodsy", "Buckley"
            ),
            ProfileModels(
                R.drawable.ic_prof_8, "Finley", "Pickle"
            ),
            ProfileModels(
                R.drawable.ic_prof_9, "Adam", "Mighty"
            ),
            ProfileModels(
                R.drawable.ic_prof_10, "Joe", "Young"
            ),
            ProfileModels(
                R.drawable.ic_prof_11, "Ashley", "Young"
            ),
            ProfileModels(
                R.drawable.ic_prof_12, "Path", "Deeper"
            ),
            ProfileModels(
                R.drawable.ic_prof_13, "Depth", "Carley"
            ),
            ProfileModels(
                R.drawable.ic_prof_14, "Cooper", "Curtly"
            ),
            ProfileModels(
                R.drawable.ic_prof_15, "Sasuke", "Uchiha"
            ),
            ProfileModels(
                R.drawable.ic_prof_16, "Harry", "Hackery"
            ),
            ProfileModels(
                R.drawable.ic_prof_17, "Kath", "Hickory"
            ),
            ProfileModels(
                R.drawable.ic_prof_18, "Kain", "Cubers"
            ),
            ProfileModels(
                R.drawable.ic_prof_19, "Kelvin", "Tapered"
            ),
            ProfileModels(
                R.drawable.ic_prof_20, "Flash", "Holding"
            )
        )
        profileAdapter = ProfileAdapter(profiles, this)
        binding.profileRecycler.adapter = profileAdapter
    }

    override fun onProfileClick(profile: ProfileModels, position: Int) {
        //Toast.makeText(this, profile.fName, Toast.LENGTH_SHORT).show()
        val intent: Intent = Intent(this, ProfileDetailsActivity::class.java)
        intent.putExtra("profileImage", profile.pImage.toString())
        intent.putExtra("firstName", profile.fName)
        intent.putExtra("lastName", profile.lName)
        startActivity(intent)
    }
}