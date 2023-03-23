package com.demir.instagramclone.util

import com.demir.instagramclone.R
import com.demir.instagramclone.model.Post
import com.demir.instagramclone.model.User

object Constants {
        fun getUserList():ArrayList<User>{
            val userList=ArrayList<User>()
            val user0=User(R.drawable.einstein,"einstein",listOf(R.drawable.einstein_post_1,R.drawable.einstein_post2,R.drawable.einstein_post_3),"10 sa")
            val user1=User(R.drawable.darwin,"darwin",listOf(R.drawable.einstein_post_1,R.drawable.einstein_post2,R.drawable.einstein_post_3),"4 sa")
            val user2=User(R.drawable.tesla,"tesla",listOf(R.drawable.einstein_post_1,R.drawable.einstein_post2,R.drawable.einstein_post_3),"6sa")
            val user3=User(R.drawable.hawking,"hawking",listOf(R.drawable.einstein_post_1,R.drawable.einstein_post2,R.drawable.einstein_post_3),"8sa")
            val user4=User(R.drawable.edison,"edison",listOf(R.drawable.einstein_post_1,R.drawable.einstein_post2,R.drawable.einstein_post_3),"6sa")
            val user5=User(R.drawable.curie,"curie",listOf(R.drawable.einstein_post_1,R.drawable.einstein_post2,R.drawable.einstein_post_3),"7sa")
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
        val user1=Post(R.drawable.einstein,R.drawable.einstein_post2,"einstein","120 beğeni"
        ,":D","2 saat önce")
        val user2=Post(R.drawable.hawking,R.drawable.hawking,"hawhing","450 beğeni"
            ,"smile","6 saat önce")
        val user3=Post(R.drawable.darwin,R.drawable.darwin,"darwin","3 beğeni"
            ,"no filter","22 saat önce")
        val user4=Post(R.drawable.tesla,R.drawable.tesla,"tesla","edison beğendi"
            ,"A/C","5 saat önce")

        postList.add(user1)
        postList.add(user2)
        postList.add(user3)
        postList.add(user4)
        return postList
    }

}