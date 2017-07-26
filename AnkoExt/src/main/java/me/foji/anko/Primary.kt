package me.foji.anko

import android.content.Context
import java.text.SimpleDateFormat
import java.util.*

/**
 * 基本数据类型扩展，主要针对Android数据转换
 *
 * @author Scott Smith
 */
/**
 * dp,sp转换为dp
 */
fun Int.toPx(context: Context): Float {
    return context.resources.displayMetrics.density * this
}

/**
 * px转换为dp
 */
fun Int.toDp(context: Context): Float {
    return (this * 1.0f) / context.resources.displayMetrics.density
}

/**
 * dp,sp转换为dp
 */
fun Float.toPx(context: Context): Float {
    return context.resources.displayMetrics.density * this
}

/**
 * px转换为dp
 */
fun Float.toDp(context: Context): Float {
    return (this * 1.0f) / context.resources.displayMetrics.density
}

/**
 * 时间戳转换为指定格式日期字符串
 */
fun Long.toDateString(pattern: String): String? {
    val formatter = SimpleDateFormat(pattern , Locale.CHINA)
    val date = Date(this)
    try {
        return formatter.format(date)
    } catch (e: Exception) {
        return null
    }
}