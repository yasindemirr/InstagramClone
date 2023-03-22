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
        binding.profileRec.addOnScrollListener(object: RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                // Toolbar'ın yüksekliğini al
                val toolbarHeight = binding.cons1.height
                // lin2 layout'unun ekran içindeki konumunu hesapla
                val lin2Y = binding.lin2.y - recyclerView.computeVerticalScrollOffset()
                // lin1 layout'unun yüksekliğini al
            //    val lin1Height = lin1.height
                // Eğer lin2 layout, toolbar'ın altına gelmişse, lin2 layout'u sabitle
                if (lin2Y < toolbarHeight) {
                    binding.lin2.translationY = (toolbarHeight - lin2Y).toFloat()
                } else {
                   binding.lin2.translationY = 0f
                }
            }
        })
    }
    private fun setProfileUi(list: List<User>) {
        profileAdapter= ProfileAdapter(list)
        binding.profileRec.apply {
           adapter=profileAdapter


        }
    }
}