package com.rainbow.pet.base.baseActivity

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleObserver
import com.rainbow.pet.base.BaseViewModel

abstract class BaseVMActivity<VM : BaseViewModel, VDB : ViewDataBinding> : BaseVDBActivity<VDB>(), LifecycleObserver {
    abstract val mViewModel: VM

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