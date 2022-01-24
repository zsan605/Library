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
import com.zsan605.pay.yunGouOS.AliPay

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
                .setUserProtocolUrl("http://www.baidu.com")
                .setPrivacyPolicyUrl("http://www.baidu.com")
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
        mBind.showPayActivity.setOnClickListener {
            AliPay().pay(this, "alipay_root_cert_sn=687b59193f3f462dd5336e5abf83c5d8_02941eef3187dddf3d3b83462e1dfcf6&alipay_sdk=alipay-sdk-java-dynamicVersionNo&app_cert_sn=2d4e70d405e9941460d8e8299408b4e6&app_id=2021001181659083&biz_content=%7B%22extend_params%22%3A%7B%22sys_service_provider_id%22%3A%222088831536490489%22%7D%2C%22out_trade_no%22%3A%22Y20120446844227%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22settle_info%22%3A%7B%22settle_detail_infos%22%3A%5B%7B%22amount%22%3A%220.01%22%2C%22trans_in_type%22%3A%22defaultSettle%22%7D%5D%7D%2C%22sub_merchant%22%3A%7B%22merchant_id%22%3A%222088210525704493%22%7D%2C%22subject%22%3A%22%E6%9C%88%E4%BC%9A%E5%91%98%22%2C%22total_amount%22%3A%220.01%22%7D&charset=UTF-8&format=json&method=alipay.trade.app.pay&notify_url=https%3A%2F%2Fcallback.yungouos.com%2Fcallback%2Falipay&sign=aKnDvFW3ykV2USY1FKQaM%2B92F9bOBS%2FS6tOwQjFC4bF1H1yWP%2BkyWJsCsavho9%2BWeQWEFoipSZoFdHowu%2FbM%2FtUL9TTEPwzeqmhiALinA%2Bw2vo8hPLiPKbMTsQg8wJOwPRlaxEI6l5UkNnmf1D0h9%2Ff5ytVo7nHpn49LEi5NZhJDSPb8KLDMFRvbLOs8UWKytmmklDtc1JqJFIYdKE8Wft%2BhTAkjFNlYlryPdVKJ8xxE1OPuLUj0Fx7fE7ukjmIRYmpwjqZEBgGJmCyIKdoaJ5Q5zVtkaZRLs9zCJjjCjUzjLyZnIXfkGsTXpv%2Bezr%2By0KDWIK9mZbrpl9Wx16HxqA%3D%3D&sign_type=RSA2&timestamp=2022-01-20+20%3A12%3A04&version=1.0")
        }
    }

}