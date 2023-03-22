package com.demir.instagramclone.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.demir.instagramclone.R
import com.demir.instagramclone.adapter.StoryAdapter
import com.demir.instagramclone.adapter.PostAdapter
import com.demir.instagramclone.databinding.FragmentHomeBinding
import com.demir.instagramclone.model.Post
import com.demir.instagramclone.model.User
import com.demir.instagramclone.util.Constants

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private var userList :ArrayList<User>? = null
    private var postList :ArrayList<Post>? = null
    private lateinit var storyAdapter: StoryAdapter
    private lateinit var postAdapter: PostAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding=FragmentHomeBinding.inflate(layoutInflater,container,false)
        requireActivity().getWindow().setStatusBarColor(requireActivity().getColor(R.color.white))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userList=Constants.getUserList()
        postList=Constants.getPostList()
        setUi(userList!!)
        setPostUi(postList!!)
        storyAdapter.onStoryUserClick={user->
            val bundle=Bundle().apply {
                putParcelable("user",user)
            }
            findNavController().navigate(R.id.action_homeFragment_to_storyDetailFragment,bundle)
        }

    }

    private fun setUi(userList: ArrayList<User>) {
        storyAdapter= StoryAdapter(userList)
        binding.historyRec.apply {
            adapter=storyAdapter
        }
    }
    private fun setPostUi(postList: ArrayList<Post>) {
        postAdapter= PostAdapter(postList)
        binding.postRec.apply {
            adapter=postAdapter

        }
    }


}