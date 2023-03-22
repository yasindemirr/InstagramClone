package com.demir.instagramclone.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.demir.instagramclone.R
import com.demir.instagramclone.adapter.PostAdapter
import com.demir.instagramclone.adapter.SearchAdapter
import com.demir.instagramclone.databinding.FragmentSearchBinding
import com.demir.instagramclone.model.Post
import com.demir.instagramclone.model.User
import com.demir.instagramclone.util.Constants

class SearchFragment : Fragment() {
    private lateinit var binding:FragmentSearchBinding
    private lateinit var searchAdapter: SearchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding= FragmentSearchBinding.inflate(layoutInflater,container,false)
        requireActivity().getWindow().setStatusBarColor(requireActivity().getColor(R.color.white))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val searchPost=Constants.getUserList()
        setSearchUi(searchPost)

    }
    private fun setSearchUi(list: List<User>) {
        searchAdapter= SearchAdapter(list)
        binding.searchRec.apply {
            adapter=searchAdapter


        }
    }

}