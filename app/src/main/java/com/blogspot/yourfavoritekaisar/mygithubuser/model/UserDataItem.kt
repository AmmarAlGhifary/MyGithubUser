package com.blogspot.yourfavoritekaisar.mygithubuser.model
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class UserDataItem(
    val userName: String,
    val userImage: Int,
    val follower: String,
    val following: String,
    val userRealName: String,
    val location: String,
    val repository: String,
    val company: String

) : Parcelable