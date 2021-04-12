package com.zsan605.common.utils

import android.content.Context
import android.content.SharedPreferences
import java.util.*

/**
 * @author: created by zsan605
 * @github：https://github.com/zsan605
 * @function: 功能描述
 * @date: 2021/4/12 20:58
 */
class SPUtil() {

    private val TAG = this.javaClass.simpleName
    private lateinit var sp: SharedPreferences

    // 初始化，使用前需要init
    fun initSP(ctx: Context, name: String, mode: Int = Context.MODE_PRIVATE) {
        sp = ctx.getSharedPreferences(name, mode)
    }

    /**
     * SP中写入String
     * @param key   键
     * *
     * @param value 值
     */
    fun put(key: String, value: String) {
        sp.edit().putString(key, value).apply()
    }

    /**
     * SP中读取String

     * @param key          键
     * *
     * @param defaultValue 默认值
     * *
     * @return 存在返回对应值，不存在返回默认值`defaultValue`
     */
    @JvmOverloads
    fun getString(key: String, defaultValue: String = ""): String {
        return sp.getString(key, defaultValue) ?: ""
    }

    /**
     * SP中写入int

     * @param key   键
     * *
     * @param value 值
     */
    fun put(key: String, value: Int) {
        sp.edit().putInt(key, value).apply()
    }

    /**
     * SP中读取int

     * @param key          键
     * *
     * @param defaultValue 默认值
     * *
     * @return 存在返回对应值，不存在返回默认值`defaultValue`
     */
    @JvmOverloads
    fun getInt(key: String, defaultValue: Int = -1): Int {
        return sp.getInt(key, defaultValue)
    }

    /**
     * SP中写入long

     * @param key   键
     * *
     * @param value 值
     */
    fun put(key: String, value: Long) {
        sp.edit().putLong(key, value).apply()
    }

    /**
     * SP中读取long

     * @param key          键
     * *
     * @param defaultValue 默认值
     * *
     * @return 存在返回对应值，不存在返回默认值`defaultValue`
     */
    @JvmOverloads
    fun getLong(key: String, defaultValue: Long = -1L): Long {
        return sp.getLong(key, defaultValue)
    }

    /**
     * SP中写入float

     * @param key   键
     * *
     * @param value 值
     */
    fun put(key: String, value: Float) {
        sp.edit().putFloat(key, value).apply()
    }

    /**
     * SP中读取float

     * @param key          键
     * *
     * @param defaultValue 默认值
     * *
     * @return 存在返回对应值，不存在返回默认值`defaultValue`
     */
    @JvmOverloads
    fun getFloat(key: String, defaultValue: Float = -1f): Float {
        return sp.getFloat(key, defaultValue)
    }

    /**
     * SP中写入boolean

     * @param key   键
     * *
     * @param value 值
     */
    fun put(key: String, value: Boolean) {
        sp.edit().putBoolean(key, value).apply()
    }

    /**
     * SP中读取boolean

     * @param key          键
     * *
     * @param defaultValue 默认值
     * *
     * @return 存在返回对应值，不存在返回默认值`defaultValue`
     */
    @JvmOverloads
    fun getBoolean(key: String, defaultValue: Boolean = false): Boolean {
        return sp.getBoolean(key, defaultValue)
    }

    /**
     * SP中写入String集合

     * @param key    键
     * *
     * @param values 值
     */
    fun put(key: String, values: Set<String>) {
        sp.edit().putStringSet(key, values).apply()
    }

    /**
     * SP中读取StringSet

     * @param key          键
     * *
     * @param defaultValue 默认值
     * *
     * @return 存在返回对应值，不存在返回默认值`defaultValue`
     */
    @JvmOverloads
    fun getStringSet(key: String, defaultValue: Set<String> = Collections.emptySet()): Set<String> {
        return sp.getStringSet(key, defaultValue) ?: setOf()
    }

    /**
     * SP中获取所有键值对

     * @return Map对象
     */
    val all: Map<String, *>
        get() = sp.all

    /**
     * SP中移除该key

     * @param key 键
     */
    fun remove(key: String) {
        sp.edit().remove(key).apply()
    }

    /**
     * SP中是否存在该key

     * @param key 键
     * *
     * @return `true`: 存在<br></br>`false`: 不存在
     */
    operator fun contains(key: String): Boolean {
        return sp.contains(key)
    }

    /**
     * SP中清除所有数据
     */
    fun clear() {
        sp.edit().clear().apply()
    }

    companion object {

        val instance: SPUtil by lazy {
            SPUtil()
        }
    }
}