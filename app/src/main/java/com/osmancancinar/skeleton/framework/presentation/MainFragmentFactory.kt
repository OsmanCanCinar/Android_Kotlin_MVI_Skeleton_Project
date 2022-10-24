package com.osmancancinar.skeleton.framework.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import javax.inject.Inject

class MainFragmentFactory @Inject constructor(
    //private val string: String
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className) {
            MainFragment::class.java.name -> {
                val fragment = MainFragment() //MainFragment(string)
                fragment
            }
            else -> super.instantiate(classLoader, className)
        }

    }
}