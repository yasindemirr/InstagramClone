package com.demir.instagramclone.ui

import android.content.res.Resources
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import com.demir.instagramclone.R
import com.demir.instagramclone.adapter.ViewPagerAdapter
import com.demir.instagramclone.databinding.FragmentStoryDetailBinding
import com.demir.instagramclone.model.User
import java.util.*
import kotlin.collections.ArrayList


class StoryDetailFragment : Fragment() {
    private lateinit var binding: FragmentStoryDetailBinding
    private val arg by navArgs<StoryDetailFragmentArgs>()
    private lateinit var storyViewAdapter: ViewPagerAdapter
    private lateinit var indicatorList: ArrayList<ImageView>
    private var currentPosition = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentStoryDetailBinding.inflate(layoutInflater, container, false)
        requireActivity().getWindow().setStatusBarColor(requireActivity().getColor(R.color.black))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val user = arg.user
        setDetailStory(user)
        indicatorList = ArrayList()
        setUi(user.kullaniciPost)
        createIndicator(storyViewAdapter.itemCount)
        binding.storyViewPagerRec.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                updateIndicators(position)
            }
        })
        binding.storyViewPagerRec.isUserInputEnabled = false
        TouchEvent()
    }

    private fun setDetailStory(user: User) {
        binding.kullaniciFoto.setImageResource(user.kullaniciFoto)
        binding.zaman.text="4 sa"
        binding.storyKullaniciAdi.text=user.kullaniciAdi


    }

    private fun createIndicator(size: Int) {
        val screenWidth = Resources.getSystem().displayMetrics.widthPixels
        val indicatorWidth = screenWidth / size
        for (i in 0 until size) {
            val indicator = View(requireContext())
            indicator.setBackgroundResource(R.drawable.indicator_inactive)
            val params = LinearLayout.LayoutParams(
                indicatorWidth,
                resources.getDimensionPixelSize(R.dimen.indicator_height)
            )
            params.setMargins(
                resources.getDimensionPixelSize(R.dimen.indicator_margin),
                0,
                resources.getDimensionPixelSize(R.dimen.indicator_margin),
                0
            )
            indicator.layoutParams = params
            binding.incatorLineer.addView(indicator)
        }
    }
    private fun TouchEvent(){
        binding.viewRight.setOnClickListener {
            goToNext()
        }
        binding.viewLeft.setOnClickListener {
            goToPrevious()
        }
    }

    private fun updateIndicators(position: Int) {
        for (i in 0 until binding.incatorLineer.childCount) {
            val indicator = binding.incatorLineer.getChildAt(i)
            if (i == position) {
                indicator.alpha = 1.0f
            } else {
                indicator.alpha = 0.5f
            }
        }
    }
    private fun setUi(storyViewPagerList: List<Int>) {
        storyViewAdapter = ViewPagerAdapter(storyViewPagerList)
        binding.storyViewPagerRec.apply {
            adapter = storyViewAdapter
            orientation = ViewPager2.ORIENTATION_HORIZONTAL

        }

    }
    private fun goToNext() {
        if (currentPosition < storyViewAdapter.itemCount - 1) {
            currentPosition++
            binding.storyViewPagerRec.setCurrentItem(currentPosition, true)
        }
    }

    private fun goToPrevious() {
        if (currentPosition > 0) {
            currentPosition--
            binding.storyViewPagerRec.setCurrentItem(currentPosition, true)
        }
    }

}