package com.example.a123.list

import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.row_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.main_listview)
        listView.adapter = MyCustomadapter()
    }

    private class MyCustomadapter(): BaseAdapter() {


        private val names = arrayListOf<String>("Trump", "Steave", "Nate", "Mark", "Obama",
                "Trump", "Steave", "Nate", "Mark", "Obama" ,
                "Trump", "Steave", "Nate", "Mark", "Obama",
                "Trump", "Steave", "Nate", "Mark", "Obama",
                "Trump", "Steave", "Nate", "Mark", "Obama")


        override fun getCount(): Int {
            return names.size
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getItem(position: Int): Any {
            return "Test String"
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            val rowMain: View

            if (convertView == null) {
                val layoutInflater = LayoutInflater.from(parent!!.context)
                rowMain = layoutInflater.inflate(R.layout.row_main, parent, false)

                val viewHolder = ViewHolder(rowMain.name_textView, rowMain.position_textView)
                rowMain.tag = viewHolder
            } else {
                rowMain = convertView
            }

            val viewHolder = rowMain.tag as ViewHolder
            viewHolder.nameTextView.text = names.get(position)
            viewHolder.positionTextView.text = "Row number: $position"

            return rowMain
        }

        private class ViewHolder(val  nameTextView: TextView, val positionTextView: TextView)
    }
}









