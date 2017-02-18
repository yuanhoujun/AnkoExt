package me.foji.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_recycler_view.view.*
import me.foji.anko.QuickAdapter
import me.foji.anko.isIP
import me.foji.anko.isIdNumber
import me.foji.anko.isPhoneNumber
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ip = "256.168.1.255"
        val mobile = "19691791160"
        val idNumber = "431123198808013515"

        Log.e("@@@" , "${ip.isIP()}")
        Log.e("@@@" , "${mobile.isPhoneNumber()}")
        Log.e("@@@>>>" , "${idNumber.isIdNumber()}")
    }
}
