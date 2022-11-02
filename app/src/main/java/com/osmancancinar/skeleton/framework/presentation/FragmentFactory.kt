package com.osmancancinar.skeleton.framework.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.osmancancinar.skeleton.framework.presentation.view.DetailFragment
import com.osmancancinar.skeleton.framework.presentation.view.MainFragment
import javax.inject.Inject

//Interface used to control the instantiation of Fragment instances.
class FragmentFactory @Inject constructor(
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className) {
            MainFragment::class.java.name -> {
                val fragment = MainFragment()
                fragment
            }
            DetailFragment::class.java.name -> {
                val fragment = DetailFragment()
                fragment
            }
            else -> super.instantiate(classLoader, className)
        }
    }
}