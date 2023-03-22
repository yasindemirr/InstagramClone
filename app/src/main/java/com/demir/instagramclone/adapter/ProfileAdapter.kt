package com.demir.instagramclone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.demir.instagramclone.databinding.SearchItemBinding
import com.demir.instagramclone.model.User

class ProfileAdapter(val list: List<User>):RecyclerView.Adapter<ProfileAdapter.ProfileHolder>() {
    class ProfileHolder(val binding: SearchItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileHolder {
        val view=SearchItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProfileHolder(view)
    }

    override fun onBindViewHolder(holder: ProfileHolder, position: Int) {
        val profilePost=list[position%list.size]
        holder.binding.searchImage.setImageResource(profilePost.kullaniciFoto)
    }

    override fun getItemCount(): Int {
        return 1
    }
}