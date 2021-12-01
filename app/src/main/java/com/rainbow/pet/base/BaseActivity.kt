package com.rainbow.pet.base

import android.app.Activity
import android.content.res.Resources
import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.rainbow.pet.R

abstract class BaseActivity<VDB : ViewDataBinding> : AppCompatActivity() {
    private var mResources: Resources? = null
    lateinit var mBinding: VDB

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        val window = window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.navigationBarColor = getColor(R.color.background_color)
        window.statusBarColor = Color.TRANSPARENT
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        window.decorView.systemUiVisibility = window.decorView.systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        mBinding = DataBindingUtil.setContentView(this as Activity, getLayoutResId())

    }



    /**
     *  Override this method in order to u can use dataBinding
     * */
    abstract fun getLayoutResId() : Int




}