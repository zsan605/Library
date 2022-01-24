package com.zsan605.pay.yunGouOS

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Handler
import android.os.Message
import com.alipay.sdk.app.PayTask
import android.widget.Toast







class AliPay {

    private val mHandler: Handler = object : Handler() {
        @SuppressLint("HandlerLeak")
        override fun handleMessage(msg: Message) {
//            val result = Result<Any>(msg.obj as String)
////            Toast.makeText(
////                this@DemoActivity, result.getResult(),
////                Toast.LENGTH_LONG
////            ).show()
        }
    }

    fun pay(activity: Activity, info: String){
        val orderInfo: String = info // 订单信息

        val payRunnable = Runnable {
            val alipay = PayTask(activity)
            val result = alipay.payV2(orderInfo, true)
            val msg = Message()
//            msg.what = SDK_PAY_FLAG
            msg.what = 1
            msg.obj = result
            mHandler.sendMessage(msg)
        }
        // 必须异步调用
        // 必须异步调用
        val payThread = Thread(payRunnable)
        payThread.start()
    }
}