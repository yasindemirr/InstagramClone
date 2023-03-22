package com.demir.instagramclone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.demir.instagramclone.databinding.PostItemBinding
import com.demir.instagramclone.model.Post

class PostAdapter(val postList: ArrayList<Post>):RecyclerView.Adapter<PostAdapter.PostHolder>() {
    class PostHolder(val binding:PostItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val view=PostItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PostHolder(view)
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        val post=postList[position]
        holder.binding.postImage.setImageResource(post.kullaniciPost)
        holder.binding.postCircleImage.setImageResource(post.kullaniciFoto)
        holder.binding.begeni.text=post.postBegeni
        holder.binding.kullaniciAdi.text=post.kullaniciAdi
        holder.binding.kullaniciYorum.text="${post.kullaniciAdi} ${post.kullaniciPostYorumu}"
        holder.binding.zaman.text=post.paylasmaSaati

    }

    override fun getItemCount(): Int {
        return postList.size
    }
}