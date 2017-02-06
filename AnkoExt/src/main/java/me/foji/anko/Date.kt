package me.foji.anko

import java.text.SimpleDateFormat
import java.util.*

/**
 * 该文件主要用于增加一些Date扩展辅助方法
 *
 * @author Scott Smith
 */
fun Date.toDateString(format: String): String? {
    val formatter = SimpleDateFormat(format , Locale.CHINA)
    try {
        return formatter.format(this)
    } catch(e: Exception) {
        return null
    }
}