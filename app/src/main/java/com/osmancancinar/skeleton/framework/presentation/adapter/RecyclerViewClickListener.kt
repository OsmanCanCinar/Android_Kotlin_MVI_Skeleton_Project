package com.osmancancinar.skeleton.framework.presentation.adapter

import android.view.View

// Interface class for implementing onClick functionality to recycler view.
interface RecyclerViewClickListener {
    fun onClick(view: View, itemId: Int)
}