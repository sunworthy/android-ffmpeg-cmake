package com.joshkryo.ffmpeg.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.joshkryo.ffmpeg.R

class FuncListAdapter(
    private val mContext: Context?,
    private val mData: List<FuncHolderItem>,
    private val itemClickListener: OnItemClickListener
) :
    RecyclerView.Adapter<FuncListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_img, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val funName = mData[position].funName
        holder.btn.text = funName
        holder.btn.setOnClickListener {
            itemClickListener.onItemClick(null, holder.btn, position, 0)
        }
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val btn: Button

        init {
            btn = itemView.findViewById(R.id.item_btn)
        }
    }
}