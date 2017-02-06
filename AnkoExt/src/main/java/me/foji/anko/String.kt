package me.foji.anko

import java.text.SimpleDateFormat
import java.util.*

/**
 * 该文件主要用于添加一些字符串处理辅助类
 *
 * @author Scott Smith
 */
/**
 * 通过指定格式，将字符串转换为Date
 */
fun String.toDate(pattern: String): Date? {
    val formatter = SimpleDateFormat(pattern , Locale.CHINA)
    try {
        return formatter.parse(this)
    } catch (e: Exception) {
        return null
    }
}
