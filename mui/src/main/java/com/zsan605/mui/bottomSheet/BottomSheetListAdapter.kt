package com.zsan605.mui.bottomSheet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zsan605.mui.databinding.FragmentBottomSheetListItemBinding

class BottomSheetListAdapter(
    private val itemClickCallback: (BottomSheetListItem) -> Unit
) :
    RecyclerView.Adapter<BottomSheetListAdapter.BillBookViewHolder>() {
    private var items = emptyList<BottomSheetListItem>()

    class BillBookViewHolder(bind: FragmentBottomSheetListItemBinding) :
        RecyclerView.ViewHolder(bind.root) {

        private val mBind: FragmentBottomSheetListItemBinding = bind

        fun getBinding(): FragmentBottomSheetListItemBinding {
            return mBind
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BillBookViewHolder {
        val bind = FragmentBottomSheetListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BillBookViewHolder(bind)
    }

    override fun onBindViewHolder(holder: BillBookViewHolder, position: Int) {
        val current = items[position]
        val bind = holder.getBinding()

        bind.text.text = current.text
        bind.text.setOnClickListener {
            itemClickCallback(current)
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    internal fun updateData(items: List<BottomSheetListItem>) {
        this.items = items
        notifyDataSetChanged()
    }

}