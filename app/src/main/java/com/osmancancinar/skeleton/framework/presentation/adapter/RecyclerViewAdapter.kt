package com.osmancancinar.skeleton.framework.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.osmancancinar.skeleton.business.domain.models.Model
import com.osmancancinar.skeleton.databinding.RecyclerRowBinding
import com.osmancancinar.skeleton.framework.presentation.view.MainFragmentDirections

class RecyclerViewAdapter() :
    RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>(),
    RecyclerViewClickListener {

    private var oldList = emptyList<Model>()

    class RecyclerViewHolder(val binding: RecyclerRowBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(
            RecyclerRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {

        holder.binding.apply {
            itemName.text = oldList[position].name
            itemGender.text = oldList[position].gender
            itemStatus.text = oldList[position].status
            itemSpecies.text = oldList[position].species
            itemOrigin.text = oldList[position].origin
            Glide.with(itemImage).load(oldList[position].image).into(itemImage)
        }

        holder.itemView.setOnClickListener {
            onClick(it, oldList[position].id)
        }
    }

    override fun getItemCount(): Int {
        return oldList.size
    }

    fun setData(newList: List<Model>) {
        val diffUtil = RecyclerViewDiffUtil(oldList, newList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        oldList = newList
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onClick(view: View, itemId: Int) {
        val action = MainFragmentDirections.actionMainFragmentToDetailFragment(itemId)
        Navigation.findNavController(view).navigate(action)
    }
}
