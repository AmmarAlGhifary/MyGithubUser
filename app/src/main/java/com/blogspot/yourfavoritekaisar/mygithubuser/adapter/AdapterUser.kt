package com.blogspot.yourfavoritekaisar.mygithubuser.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.blogspot.yourfavoritekaisar.mygithubuser.R
import com.blogspot.yourfavoritekaisar.mygithubuser.model.UserDataItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.user_list.view.*

class AdapterUser(
    private val context: Context,
    private val userDataItem: List<UserDataItem>,
    private val listener: (UserDataItem) -> Unit
) : RecyclerView.Adapter<AdapterUser.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.user_list, parent, false))
    }

    override fun getItemCount() = userDataItem.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(userDataItem[position], listener)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val userName: TextView = view.findViewById(R.id.tv_user_name)
        val userFollower: TextView = view.findViewById(R.id.tv_follower)
        val userFollowing: TextView = view.findViewById(R.id.tv_following)

        fun bindItem(userDataItem: UserDataItem, listener: (UserDataItem) -> Unit) {
            itemView.tv_user_name.text = userDataItem.userName
            itemView.tv_follower.text = userDataItem.follower
            itemView.tv_following.text = userDataItem.following

            Glide.with(itemView.context)
                .load(userDataItem.userImage)
                .into(itemView.iv_img_user)
            itemView.setOnClickListener {
                listener(userDataItem)
            }
        }
    }
}
