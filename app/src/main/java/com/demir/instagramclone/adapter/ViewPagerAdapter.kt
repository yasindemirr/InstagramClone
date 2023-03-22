package com.demir.instagramclone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.demir.instagramclone.R
import com.demir.instagramclone.databinding.StoryDetailItemBinding
import com.demir.instagramclone.databinding.StoryItemBinding
import com.demir.instagramclone.model.User


class ViewPagerAdapter(val storyViewList:List<Int>):RecyclerView.Adapter<ViewPagerAdapter.ViewPagerHolder>() {
    class ViewPagerHolder(val binding: StoryDetailItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder {
            val view=StoryDetailItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
     return   ViewPagerHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
       val storyPost=storyViewList[position]
        holder.binding.imageDetails.setImageResource(storyPost)

    }


    override fun getItemCount(): Int {
      return  storyViewList.size
    }
}