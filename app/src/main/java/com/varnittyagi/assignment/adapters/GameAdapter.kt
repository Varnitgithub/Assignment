package com.varnittyagi.assignment.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.varnittyagi.assignment.R
import com.varnittyagi.assignment.models.GamesModel

class GameAdapter(var context: Context,var listener:Clickable) : RecyclerView.Adapter<GameAdapter.ViewHolderClass>() {

    var gameList = ArrayList<GamesModel>()

    class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var gameImage: ImageView = itemView.findViewById(R.id.gameImage)
        var playBtn: ImageView = itemView.findViewById(R.id.playBtn)
        var gameName: TextView = itemView.findViewById(R.id.gameName)
        var itemLayout:RelativeLayout = itemView.findViewById(R.id.itemLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val view = ViewHolderClass(
            LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        )

        view.itemLayout.setOnClickListener{
            listener.onCLick(gameList,view.adapterPosition)
    }

        return view
    }

    override fun getItemCount(): Int {
        return gameList.size
    }

    fun updateList(newList:ArrayList<GamesModel>){
        gameList.clear()
        gameList.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        var currentItem = gameList[position]

        holder.gameName.text = currentItem.gameName
        Glide.with(context).load(currentItem.gameImage).into(holder.gameImage)
        Glide.with(context).load(currentItem.playBtn).into(holder.playBtn)
    }

    interface Clickable{
        fun onCLick(gamelist:ArrayList<GamesModel>,position: Int)
    }
}