package com.rainbow.pet

import android.os.Bundle
import androidx.activity.viewModels
import com.rainbow.pet.base.baseActivity.BaseVMActivity
import com.rainbow.pet.databinding.ActivityHomeBinding
import com.rainbow.pet.viewmodel.HomeViewModel

class HomeActivity : BaseVMActivity<HomeViewModel, ActivityHomeBinding>() {


    override val mViewModel by viewModels<HomeViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initView() {

    }
    override fun initData() {

    }
    override fun startObserver() {

    }
    override fun getLayoutResId() = R.layout.activity_home
}