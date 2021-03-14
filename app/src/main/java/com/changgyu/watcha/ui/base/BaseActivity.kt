package com.changgyu.watcha.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<B : ViewDataBinding>(@LayoutRes private val layoutResId: Int)
    : AppCompatActivity(){
    lateinit var binding : B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutResId)
        binding.lifecycleOwner = this
        initActivity()
    }

    abstract fun initActivity()
    abstract fun initStart()
    abstract fun initResume()
    abstract fun initPause()
    abstract fun initDestroy()

    override fun onStart() {
        super.onStart()
        initStart()
    }

    override fun onResume() {
        super.onResume()
        initResume()
    }

    override fun onPause() {
        super.onPause()
        initPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        initDestroy()
    }
}