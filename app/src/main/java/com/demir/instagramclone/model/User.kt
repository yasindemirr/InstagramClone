package com.demir.instagramclone.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val kullaniciFoto: Int,
    val kullaniciAdi:String,
    val kullaniciPost: List<Int>,
    val paylasmaSaati:String
):Parcelable {
}
data class Post(
    val kullaniciFoto: Int,
    val kullaniciPost: Int,
    val kullaniciAdi:String,
    val postBegeni: String,
    val kullaniciPostYorumu: String,
    val paylasmaSaati:String
)



