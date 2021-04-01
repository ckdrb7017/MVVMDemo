package com.jakchang.mvvm.ui.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.annotation.LayoutRes
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<B : ViewDataBinding, A: Activity>(@LayoutRes private val layoutResId: Int): Fragment(){
    lateinit var binding : B

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, layoutResId, null, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFragment()
    }

    abstract fun initFragment()
    abstract fun initStart()
    abstract fun initResume()
    abstract fun initPause()
    abstract fun initDestroy()

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

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
        //mActivity = null
    }

}