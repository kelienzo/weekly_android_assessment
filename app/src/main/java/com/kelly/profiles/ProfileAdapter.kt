package com.kelly.profiles

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.kelly.profiles.databinding.ProfileListBinding

class ProfileAdapter(val profiles: List<ProfileModels>, var clickListener: OnProfileClickListener) :
    RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>() {

    inner class ProfileViewHolder(private val binding: ProfileListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(profile: ProfileModels) {
            binding.profileImage.setImageResource(profile.pImage)
            binding.firstName.text = profile.fName
            binding.lastName.text = profile.lName
        }

        fun initialize(profile: ProfileModels, action: OnProfileClickListener) {
            binding.profileImage.setImageResource(profile.pImage)
            binding.firstName.text = profile.fName
            binding.lastName.text = profile.lName

            binding.root.setOnClickListener {
                action.onProfileClick(profile, adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val binding: ProfileListBinding =
            ProfileListBinding.inflate(LayoutInflater.from(parent.context))
        return ProfileViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        val profile = profiles[position]
        holder.bind(profile)
        holder.initialize(profiles[position], clickListener)
    }

    override fun getItemCount(): Int {
        return profiles.size
    }
}

interface OnProfileClickListener {
    fun onProfileClick(profile: ProfileModels, position: Int)
}