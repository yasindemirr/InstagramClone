package com.demir.instagramclone.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.demir.instagramclone.R
import com.demir.instagramclone.adapter.ProfileAdapter
import com.demir.instagramclone.adapter.SearchAdapter
import com.demir.instagramclone.databinding.FragmentProfileBinding
import com.demir.instagramclone.databinding.SearchItemBinding
import com.demir.instagramclone.model.User
import com.demir.instagramclone.util.Constants

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var profileAdapter: ProfileAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding=FragmentProfileBinding.inflate(layoutInflater,container,false)
        requireActivity().getWindow().setStatusBarColor(requireActivity().getColor(R.color.white))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val searchPost= Constants.getUserList()
        setProfileUi(searchPost)
    }
    private fun setProfileUi(list: List<User>) {
        profileAdapter= ProfileAdapter(list)
        binding.profileRec.apply {
           adapter=profileAdapter


        }
    }
}