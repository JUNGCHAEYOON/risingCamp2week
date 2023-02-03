package com.example.risingcamp2week.MAIN

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.risingcamp2week.R
import kotlinx.coroutines.NonDisposableHandle.parent


class HomeAdapter(private val dataSet: ArrayList<HomeItem>) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemTitle = itemView.findViewById<TextView>(R.id.itemTitle)
        val itemPrice = itemView.findViewById<TextView>(R.id.itemPrice)
        val itemInfo = itemView.findViewById<TextView>(R.id.itemInfo)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.list_item, viewGroup,false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemTitle.text = dataSet[position].title
        viewHolder.itemPrice.text = dataSet[position].price
        viewHolder.itemInfo.text = dataSet[position].info
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
