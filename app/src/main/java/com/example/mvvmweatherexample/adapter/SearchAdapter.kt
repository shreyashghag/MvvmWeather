package com.example.mvvmweatherexample.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmweatherexample.R
import com.example.mvvmweatherexample.model.Location
import com.example.mvvmweatherexample.view.DetailsActivity
import kotlinx.android.synthetic.main.rv_location_item.view.*

class SearchAdapter (var context: Context):RecyclerView.Adapter<SearchAdapter.SearchAdapterViewHolder>(){

    private var list:List<Location> = ArrayList()

    fun setLocation(list:List<Location>){
        this.list=list
        notifyDataSetChanged()
    }

    inner class SearchAdapterViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchAdapterViewHolder {
        val  view=LayoutInflater.from(parent.context).inflate(R.layout.rv_location_item,parent,false)
        return SearchAdapterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SearchAdapterViewHolder, position: Int) {
        val currLocation=list[position]
        holder.itemView.tv_locationName.setText(currLocation.title)
        holder.itemView.tv_latlong.setText(currLocation.latt_long)
        holder.itemView.root_view.setOnClickListener {
            val intent= Intent(context,DetailsActivity::class.java)
                intent.putExtra("Location",currLocation.woeid)
                intent.putExtra("name",currLocation.title)
            context.startActivity(intent)
        }
    }
}