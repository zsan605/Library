package com.zsan605.common.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * @author: created by zsan605
 * @github：https://github.com/zsan605
 * @function: 功能描述
 * @date: 2021/4/12 18:54
 */
class DateUtil {

    private val TAG = this.javaClass.simpleName

    companion object {
        val instance: DateUtil by lazy {
            DateUtil()
        }
    }

    fun getCurFmtTime(): String {
        val formatter = SimpleDateFormat("YYYY-MM-dd HH:mm:ss") //设置时间格式
        formatter.timeZone = TimeZone.getTimeZone("GMT+08") //设置时区
        val curDate = Date(System.currentTimeMillis()) //获取当前时间
        return formatter.format(curDate) //格式转换
    }
}