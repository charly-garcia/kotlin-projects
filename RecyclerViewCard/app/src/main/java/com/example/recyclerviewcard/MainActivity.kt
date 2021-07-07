package com.example.recyclerviewcard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvList : RecyclerView = findViewById(R.id.rvList)

        val data: MutableList<DataObject> = ArrayList()
        for(i in 1..5)
            data.add(DataObject("Title $i"))

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val adapter = CustomAdapter(data)

        rvList.layoutManager = layoutManager
        rvList.setHasFixedSize(true)
        rvList.adapter = adapter

    }
}