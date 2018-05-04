package com.example.jora.test

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_name.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, LinearLayoutManager.VERTICAL))
        recyclerView.setUp(mockList(), R.layout.item_name, { item ->
            itemName.text = item
            setOnClickListener {
                Toast.makeText(it.context, "Clicked $item", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun mockList(): List<String> {
        val list = ArrayList<String>()
        while (list.size < 20) {
            list.add("Item ${list.size}")
        }
        return list
    }
}
