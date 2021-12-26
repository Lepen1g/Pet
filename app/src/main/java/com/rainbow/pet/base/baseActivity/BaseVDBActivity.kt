package com.rainbow.pet.base.baseActivity

import android.content.res.Resources
import androidx.databinding.ViewDataBinding

abstract class BaseVDBActivity<VDB : ViewDataBinding> : BaseActivity() {
    private var mResources: Resources? = null
    lateinit var mBinding: VDB

    /**
     *  Override this method in order to u can use dataBinding
     * */
    abstract fun getLayoutResId() : Int




}