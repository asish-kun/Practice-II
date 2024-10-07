package com.example.practice_ii

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.BaseAdapter
import androidx.core.content.ContextCompat

class ItemAdapter(private val context: Context, private val items: List<ListItem>) : BaseAdapter() {
    override fun getCount(): Int = items.size
    override fun getItem(position: Int): Any = items[position]
    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val viewHolder: ViewHolder
        val view: View

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
            view.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary))
            viewHolder = ViewHolder()
            viewHolder.titleTextView = view.findViewById(R.id.itemTitle)
            viewHolder.subtitleTextView = view.findViewById(R.id.itemSubtitle)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val item = items[position]
        viewHolder.titleTextView.text = item.title
        viewHolder.subtitleTextView.text = item.subtitle

        return view
    }

    private class ViewHolder {
        lateinit var titleTextView: TextView
        lateinit var subtitleTextView: TextView
    }
}
