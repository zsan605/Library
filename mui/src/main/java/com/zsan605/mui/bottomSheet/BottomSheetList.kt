package com.zsan605.mui.bottomSheet

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.zsan605.mui.R
import com.zsan605.mui.databinding.FragmentBottomSheetListBinding

class BottomSheetList(context: Context) : BottomSheetDialogFragment() {

    companion object {
        fun builder(context: Context): Builder {
            return lazy { Builder(context) }.value
        }
    }

    private var builder: Builder? = null
    private lateinit var mBind: FragmentBottomSheetListBinding
    private lateinit var mAdapter: BottomSheetListAdapter


    constructor(context: Context, builder: Builder) : this(context) {
        this.builder = builder
    }

    init {
        builder = builder(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.BottomSheetDialog)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBind = FragmentBottomSheetListBinding.inflate(inflater, container, false)
        init()
        return mBind.root
    }

    private fun init(){
        initAdapter()
        initData()
    }

    private fun initData(){

        builder?.let {
            mAdapter.updateData(it.mItems)
            it.mTitle?.let {
                mBind.title.text =  it
                mBind.title.visibility = View.VISIBLE
            }
        }
    }

    private fun initAdapter() {
        mAdapter = BottomSheetListAdapter {
            builder?.mOnSheetItemClickListener?.onClick(it)
        }
        mBind.list.layoutManager = LinearLayoutManager(context)
        mBind.list.adapter = mAdapter
    }


    class Builder(private var context: Context) {
        //        @JvmField
        var mTitle: String? = null
        var mItems = mutableListOf<BottomSheetListItem>()

        lateinit var mOnSheetItemClickListener: OnSheetItemClickListener

        fun addTitle(title: String): Builder {
            mTitle = title
            return this
        }

        fun addItem(textAndTag: String): Builder {
            mItems.add(BottomSheetListItem(textAndTag, textAndTag))
            return this
        }

        fun addItem(text: String, tag: String): Builder {
            mItems.add(BottomSheetListItem(text, tag))
            return this
        }



        fun setOnSheetItemClickListener(onSheetItemClickListener: OnSheetItemClickListener): Builder {
            mOnSheetItemClickListener = onSheetItemClickListener
            return this
        }

        fun build(): BottomSheetList {
            return BottomSheetList(context, this)
        }

    }

    interface OnSheetItemClickListener {
        fun onClick(item: BottomSheetListItem)
    }


}


//class BillBookBottomSheetFragment : BottomSheetDialogFragment() {
//
//    private var _binding: FragmentBillBookBottomSheetBinding? = null
//
//    // This property is only valid between onCreateView and
//    // onDestroyView.
//    private val binding get() = _binding!!
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//        _binding = FragmentBillBookBottomSheetBinding.inflate(inflater, container, false)
//        return binding.root
//
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        activity?.findViewById<RecyclerView>(R.id.list)?.layoutManager =
//            LinearLayoutManager(context)
//        activity?.findViewById<RecyclerView>(R.id.list)?.adapter =
//            arguments?.getInt(ARG_ITEM_COUNT)?.let { ItemAdapter(it) }
//    }
//
//    private inner class ViewHolder internal constructor(binding: FragmentBillBookBottomSheetItemBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//
//        internal val text: TextView = binding.text
//    }
//
//    private inner class ItemAdapter internal constructor(private val mItemCount: Int) :
//        RecyclerView.Adapter<ViewHolder>() {
//
//        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//
//            return ViewHolder(
//                FragmentBillBookBottomSheetItemBinding.inflate(
//                    LayoutInflater.from(
//                        parent.context
//                    ), parent, false
//                )
//            )
//
//        }
//
//        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//            holder.text.text = position.toString()
//        }
//
//        override fun getItemCount(): Int {
//            return mItemCount
//        }
//    }
//
//    companion object {
//
//        // TODO: Customize parameters
//        fun newInstance(itemCount: Int): BillBookBottomSheetFragment =
//            BillBookBottomSheetFragment().apply {
//                arguments = Bundle().apply {
//                    putInt(ARG_ITEM_COUNT, itemCount)
//                }
//            }
//
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
//}