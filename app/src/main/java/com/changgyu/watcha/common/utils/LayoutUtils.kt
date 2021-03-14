package com.changgyu.watcha.common.utils

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle

//레이아웃관련 유틸


fun changeFragment(parent: Any, view: View, target: Fragment) {
    try {
        var fragmentManager: FragmentManager? = null
        if (parent is AppCompatActivity) fragmentManager = parent.supportFragmentManager
        else if (parent is Fragment) fragmentManager = parent.childFragmentManager

        if (target.lifecycle.currentState != Lifecycle.State.INITIALIZED) {
            return
        }
        fragmentManager!!.beginTransaction().remove(target)
        fragmentManager.beginTransaction()
            .replace(view.id, target)
            .commitNow()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}