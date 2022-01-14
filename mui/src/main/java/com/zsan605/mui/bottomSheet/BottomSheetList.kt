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
