package com.demir.instagramclone.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.demir.instagramclone.databinding.StoryItemBinding
import com.demir.instagramclone.model.User

class StoryAdapter(val list:ArrayList<User>):RecyclerView.Adapter<StoryAdapter.HistoryHolder>() {
    class HistoryHolder(val binding:StoryItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryHolder {
        val view= StoryItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return HistoryHolder(view)
    }

    override fun onBindViewHolder(holder: HistoryHolder, position: Int) {
        val user=list[position]
        holder.binding.historyImage.setImageResource(user.kullaniciFoto)
        holder.binding.historyName.text=user.kullaniciAdi
        if(position==0){
            holder.binding.hisAdd.visibility= View.VISIBLE
            holder.binding.historyImageBigger.visibility=View.INVISIBLE

        }else  {
            holder.binding.hisAdd.visibility= View.GONE
            holder.binding.historyImageBigger.visibility=View.VISIBLE
        }
        holder.itemView.setOnClickListener {
            onStoryUserClick?.invoke(user)
        }
    }
    var onStoryUserClick: ((User) -> Unit)? = null

    override fun getItemCount(): Int {
       return list.size
    }
}