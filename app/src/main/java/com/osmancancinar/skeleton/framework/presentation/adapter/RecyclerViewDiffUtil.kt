package com.osmancancinar.skeleton.framework.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.osmancancinar.skeleton.business.domain.models.Model

class RecyclerViewDiffUtil(
    private val oldList: List<Model>,
    private val newList: List<Model>,
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when {
            oldList[oldItemPosition].id != newList[newItemPosition].id -> false
            oldList[oldItemPosition].name != newList[newItemPosition].name -> false
            oldList[oldItemPosition].status != newList[newItemPosition].status -> false
            oldList[oldItemPosition].species != newList[newItemPosition].species -> false
            oldList[oldItemPosition].type != newList[newItemPosition].type -> false
            oldList[oldItemPosition].gender != newList[newItemPosition].gender -> false
            oldList[oldItemPosition].origin != newList[newItemPosition].origin -> false
            oldList[oldItemPosition].image != newList[newItemPosition].image -> false
            else -> true
        }
    }
}