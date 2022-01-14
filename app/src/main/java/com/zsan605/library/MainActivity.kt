package com.zsan605.library

import android.content.DialogInterface
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.zsan605.library.databinding.ActivityMainBinding
import com.zsan605.mui.bottomSheet.BottomSheetList
import com.zsan605.mui.bottomSheet.BottomSheetListItem
import com.zsan605.mui.dialog.PrivacyPolicyDialogBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var mBind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBind.root)

        initListener()
    }

    private fun initListener() {
        mBind.showBottomSheetList.setOnClickListener {
            BottomSheetList.builder(this)
                .addTitle("Title")
                .addItem("item1")
                .addItem("item2")
                .addItem("item3")
                .addItem("item4")
                .setOnSheetItemClickListener(
                    object : BottomSheetList.OnSheetItemClickListener {
                        override fun onClick(item: BottomSheetListItem) {
                            when (item.tag) {
                                "item1" -> {
                                    Toast.makeText(
                                        applicationContext,
                                        "click item1",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                                "item2" -> {
                                    Toast.makeText(
                                        applicationContext,
                                        "click item2",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                                "item3" -> {
                                    Toast.makeText(
                                        applicationContext,
                                        "click item3",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                                "item4" -> {
                                    Toast.makeText(
                                        applicationContext,
                                        "click item4",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        }
                    }
                )
                .build()
                .show(supportFragmentManager, "test")
        }
        mBind.showPrivacyPolicyDialog.setOnClickListener {
            PrivacyPolicyDialogBuilder.builder(this)
                .setUserProtocolUrl("www.baidu.com", Color.GREEN)
                .setPrivacyPolicyUrl("www.baidu.com")
                .setPositiveButton { dialog, which ->
//                    TODO("Not yet implemented")
                    Toast.makeText(applicationContext, "click agree", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton { dialog, which ->
                    Toast.makeText(applicationContext, "click disagree", Toast.LENGTH_SHORT).show()
                }
                .build()
                .show()

        }
    }

}