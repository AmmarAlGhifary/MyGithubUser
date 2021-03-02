package com.blogspot.yourfavoritekaisar.mygithubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.blogspot.yourfavoritekaisar.mygithubuser.adapter.AdapterUser
import com.blogspot.yourfavoritekaisar.mygithubuser.model.UserDataItem
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.indeterminateProgressDialog
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    private val userDataItem: MutableList<UserDataItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val progressDialog = indeterminateProgressDialog("Sedang Mencari Data. . . .")
        progressDialog.show()
        title = "User"
        initData()

        progressDialog.dismiss()

        rv_main.layoutManager = LinearLayoutManager(this)
        rv_main.adapter = AdapterUser(this, userDataItem) {
            toast("${it.userName}")
            startActivity<DetailActivity>(DetailActivity.EXTRA_DATA to it)
        }
    }

    private fun initData() {
        val userName = resources.getStringArray(R.array.username)
        val userFollower = resources.getStringArray(R.array.followers)
        val userFollowing = resources.getStringArray(R.array.following)
        val userRealName = resources.getStringArray(R.array.name)
        val location = resources.getStringArray(R.array.location)
        val company = resources.getStringArray(R.array.company)
        val repository = resources.getStringArray(R.array.repository)
        val userImage = resources.obtainTypedArray(R.array.avatar)

        userDataItem.clear()

        for (i in userName.indices)
            userDataItem.add(
                UserDataItem(
                    userName[i],
                    userImage.getResourceId(i, 0),
                    userFollower[i],
                    userFollowing[i],
                    userRealName[i],
                    location[i],
                    company[i],
                    repository[i]
                )
            )
        userImage.recycle()
    }


}
