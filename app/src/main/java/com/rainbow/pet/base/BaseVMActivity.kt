package com.rainbow.pet.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleObserver

abstract class BaseVMActivity<VM : BaseViewModel, VBD : ViewDataBinding> : BaseActivity<VBD>(), LifecycleObserver {
    abstract var mViewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()
        initData()
        startObserver()

    }

    abstract fun initView()

    abstract fun initData()

    abstract fun startObserver()


}