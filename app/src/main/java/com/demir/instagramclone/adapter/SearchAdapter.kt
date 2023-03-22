package com.demir.instagramclone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.demir.instagramclone.databinding.SearchItemBinding
import com.demir.instagramclone.model.User

class SearchAdapter(val list:List<User>):RecyclerView.Adapter<SearchAdapter.SearchHolder>() {
    class SearchHolder(val binding:SearchItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchHolder {
        val view=SearchItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SearchHolder(view)
    }

    override fun onBindViewHolder(holder: SearchHolder, position: Int) {
        val searchPost=list[position%list.size]
        holder.binding.searchImage.setImageResource(searchPost.kullaniciFoto)
    }

    override fun getItemCount(): Int {
        return 30
    }
}