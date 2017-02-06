package me.foji.anko

import android.content.Context
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * QuickAdapter 简化RecyclerView设置Adapter操作，仅用于单一View类型设置
 *
 * @author Scott Smith
 */
abstract class QuickAdapter<in T>(context: Context, @LayoutRes layoutId: Int, datas: List<T>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var mDatas = datas
    private var mLayoutId = layoutId
    private var mContext = context

    fun setData(datas: List<T>) {
        mDatas = datas
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        convert(holder , mDatas[position] , position)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return object: RecyclerView.ViewHolder(LayoutInflater.from(mContext).inflate(mLayoutId , parent , false)) {}
    }

    override fun getItemCount(): Int {
        return mDatas.size
    }

    abstract fun convert(viewHolder: RecyclerView.ViewHolder , data: T , position: Int)
}