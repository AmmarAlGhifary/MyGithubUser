package com.blogspot.yourfavoritekaisar.mygithubuser

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import com.blogspot.yourfavoritekaisar.mygithubuser.model.UserDataItem
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        title = "DetailUser"
        val userDataItem = intent.getParcelableExtra<UserDataItem>(EXTRA_DATA)
        DetailActivityUI(userDataItem).setContentView(this)
    }

    class DetailActivityUI(private val userDataItem: UserDataItem?) :
        AnkoComponent<DetailActivity> {
        @Suppress("DEPRECATION")
        override fun createView(ui: AnkoContext<DetailActivity>) = with(ui) {
            verticalLayout {
                orientation = LinearLayout.VERTICAL
                padding = dip(15)

                imageView {
                    id = R.id.iv_detail_img
                    scaleType = ImageView.ScaleType.CENTER_CROP
                    adjustViewBounds = true
                    Glide.with(context).load(userDataItem?.userImage).into(this)
                }.lparams(width = matchParent, height = dip(272)) {
                    gravity = Gravity.CENTER

                }
                textView {
                    id = R.id.tv_user_name
                    text = userDataItem?.userName
                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                    textColor = resources.getColor(android.R.color.holo_blue_dark)
                    textSize = 20f //sp
                    setTypeface(typeface, Typeface.ITALIC)
                }.lparams(width = matchParent)

                textView {
                    id = R.id.tv_real_name
                    gravity = Gravity.CENTER
                    text = userDataItem?.userRealName
                    textColor = resources.getColor(android.R.color.holo_orange_dark)
                    textSize = 20f //sp
                    setTypeface(typeface, Typeface.BOLD)
                }.lparams(width = matchParent) {
                    topMargin = dip(10)
                }

                textView {
                    id = R.id.tv_location
                    text = userDataItem?.location
                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                    textColor = resources.getColor(R.color.design_default_color_secondary_variant)
                    textSize = 25f //sp
                    setTypeface(typeface, Typeface.BOLD)
                }.lparams(width = matchParent)

                textView {
                    id = R.id.tv_company
                    text = userDataItem?.company
                    textAlignment = View.TEXT_ALIGNMENT_CENTER
                    textColor = resources.getColor(R.color.design_default_color_secondary_variant)
                    setTypeface(typeface, Typeface.ITALIC)
                }.lparams(width = matchParent)

                textView {
                    id = R.id.tv_repository
                    text = resources.getString(R.string.repository)
                    textColor = resources.getColor(R.color.design_default_color_secondary)
                    setTypeface(typeface, Typeface.BOLD)
                }

                textView {
                    id = R.id.tv_jumlah_repository
                    text = resources.getString(R.string.jumlah_repository)
                    textColor = resources.getColor(R.color.design_default_color_secondary_variant)
                    textSize = 12f //sp
                }.lparams(width = matchParent) {
                    marginEnd = dip(10)
                }
                    textView {
                        id = R.id.tv_detail_follower
                        text = resources.getString(R.string.jumlah_follower)
                        textColor = resources.getColor(R.color.design_default_color_secondary)
                        textSize = 15f //sp
                    }
                    textView {
                        id = R.id.tv_detail_jumlah_follower
                        text = userDataItem?.follower
                        textColor =
                            resources.getColor(R.color.design_default_color_secondary_variant)
                        textSize = 12f //sp
                        setTypeface(typeface, Typeface.ITALIC)
                    }.lparams(width = matchParent)

                    textView {
                        id = R.id.tv_detail_following
                        text = resources.getString(R.string.jumlah_following)
                        textColor = resources.getColor(R.color.design_default_color_secondary)
                        textSize = 15f //sp

                    }
                    textView {
                        id = R.id.tv_jumlah_following
                        text = userDataItem?.following
                        textColor =
                            resources.getColor(R.color.design_default_color_secondary_variant)
                        textSize = 12f //sp
                        setTypeface(typeface, Typeface.ITALIC)
                    }.lparams(width = matchParent)
                }
            }
        }
    }
