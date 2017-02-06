package me.foji.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_recycler_view.view.*
import me.foji.anko.QuickAdapter
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val datas = ArrayList<String>()
        datas.add("aaa")
        datas.add("bbb")
        datas.add("ccc")

        recycler_view.layoutManager = LinearLayoutManager(this , LinearLayoutManager.VERTICAL , false)
        recycler_view.adapter = object: QuickAdapter<String>(this , R.layout.item_recycler_view , datas) {
            override fun convert(viewHolder: RecyclerView.ViewHolder, data: String, position: Int) {
                viewHolder.itemView.text.text = data
            }
        }

        object: Thread() {
            override fun run() {
                super.run()

                Thread.sleep(5000)

                datas.add("ddd")
                (recycler_view.adapter as QuickAdapter<String>).setData(datas = datas)
                runOnUiThread {
                    recycler_view.adapter.notifyDataSetChanged()
                }
            }
        }.start()
    }
}
