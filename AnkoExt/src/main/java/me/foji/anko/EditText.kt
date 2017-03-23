package me.foji.anko

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

/**
 * EditText扩展
 *
 * @author Scott Smith 2017-03-22 18:05
 */

/**
 * 对应[TextWatcher.beforeTextChanged]方法
 *
 * @param init 初始化lambda表达式
 */
fun EditText.beforeTextChanged(init: ((s: CharSequence? ,
                               start: Int ,
                               count: Int ,
                               after: Int)->Unit)? = null) {
    addTextChangedListener(object: TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            if(null != init) {
                init(s, start, count, after)
            }
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }
    })
}

/**
 * 对应[TextWatcher.afterTextChanged]方法
 *
 * @param init 初始化lambda表达式
 */
fun EditText.afterTextChanged(init: ((s: Editable?)->Unit)? = null) {
    addTextChangedListener(object: TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            if(null != init) {
                init(s)
            }
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }
    })
}

/**
 * 对应[TextWatcher.onTextChanged]方法
 *
 * @param init 初始化lambda表达式
 */
fun EditText.onTextChanged(init: ((s: CharSequence? ,
                                  start: Int ,
                                  before: Int ,
                                  count: Int)->Unit)? = null) {
    addTextChangedListener(object: TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if(null != init) {
                init(s , start , before , count)
            }
        }
    })
}

/**
 * 清除输入框数据
 */
fun EditText.clear() {
    setText("")
}