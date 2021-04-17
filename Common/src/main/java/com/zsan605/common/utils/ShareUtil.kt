package com.zsan605.common.utils

import android.content.Context
import android.content.Intent
import android.net.Uri

/**
 * @author: created by zsan605
 * @github：https://github.com/zsan605
 * @function: 功能描述
 * @date: 2021/4/17 10:16
 */
class ShareUtil {

    private val TAG = this.javaClass.simpleName

    companion object {
        val instance: ShareUtil by lazy {
            ShareUtil()
        }
    }

    fun shareText(ctx: Context, title: String, msg: String) {
        val sendIntent = Intent(Intent.ACTION_SEND)
        sendIntent.putExtra(Intent.EXTRA_TEXT, msg)
        sendIntent.type = "text/plain"
        ctx.startActivity(Intent.createChooser(sendIntent, "Share to..."))
    }

    fun shareIssuesToMyEmail(ctx: Context) {
        val contentTpl = "基本信息：\n\t\t手机厂商：" + android.os.Build.BRAND + "\n\t\t手机型号：" +
                android.os.Build.MODEL + "\n\t\tSDK版本：" + android.os.Build.VERSION.SDK_INT.toString() +
                "\n问题描述："
        val intent = Intent(Intent.ACTION_SENDTO);
        intent.data = Uri.parse("mailto:zsan605@gmail.com")
        intent.putExtra(Intent.EXTRA_SUBJECT, "模拟位置：问题反馈")
        intent.putExtra(Intent.EXTRA_TEXT, contentTpl)
        ctx.startActivity(intent)
    }

    fun shareFeatureToMyEmail(ctx: Context) {
        val intent = Intent(Intent.ACTION_SENDTO);
        intent.data = Uri.parse("mailto:zsan605@gmail.com")
        intent.putExtra(Intent.EXTRA_SUBJECT, "模拟位置：请求新增功能")
        ctx.startActivity(intent)
    }
}