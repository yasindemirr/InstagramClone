package com.demir.instagramclone.util

import com.demir.instagramclone.R
import com.demir.instagramclone.model.Post
import com.demir.instagramclone.model.User

object Constants {
        fun getUserList():ArrayList<User>{
            val userList=ArrayList<User>()
            val user0=User(R.drawable.guney,"Hikayen",listOf(R.drawable.kuzey_post_1,R.drawable.kuzey_post_2,R.drawable.kuzey_post_3),"10 sa")
            val user1=User(R.drawable.kuzey,"Kuzey",listOf(R.drawable.kuzey_post_1,R.drawable.kuzey_post_2,R.drawable.kuzey_post_3),"4 sa")
            val user2=User(R.drawable.ferhat,"Ferhat",listOf(R.drawable.kuzey_post_1,R.drawable.kuzey_post_2,R.drawable.kuzey_post_3),"6sa")
            val user3=User(R.drawable.simay,"Simay",listOf(R.drawable.kuzey_post_1,R.drawable.kuzey_post_2,R.drawable.kuzey_post_3),"8sa")
            val user4=User(R.drawable.handan,"Handan",listOf(R.drawable.kuzey_post_1,R.drawable.kuzey_post_2,R.drawable.kuzey_post_3),"6sa")
            val user5=User(R.drawable.sami,"Sami",listOf(R.drawable.kuzey_post_1,R.drawable.kuzey_post_2,R.drawable.kuzey_post_3),"7sa")
            userList.add(user0)
           userList.add(user1)
            userList.add(user2)
            userList.add(user3)
            userList.add(user4)
            userList.add(user5)

            return userList
        }
    fun getPostList():ArrayList<Post>{
        val postList=ArrayList<Post>()
        val user1=Post(R.drawable.kuzey,R.drawable.kuzeyyy,"tekinoglukuzey","120 beğeni"
        ,"bitti","2 saat önce")
        val user2=Post(R.drawable.simay,R.drawable.eniste,"simayyy","450 beğeni"
            ,"tb düğün","6 saat önce")
        val user3=Post(R.drawable.ferhat,R.drawable.ferhattt,"fero","3 beğeni"
            ,"isyanlardayım","22 saat önce")
        val user4=Post(R.drawable.handan,R.drawable.handan_gozluk,"handan72","3 beğeni"
            ,"Güney in hediyesi","5 saat önce")

        postList.add(user1)
        postList.add(user2)
        postList.add(user3)
        postList.add(user4)
        return postList
    }

}