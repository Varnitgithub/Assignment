package com.varnittyagi.assignment.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.varnittyagi.assignment.R
import com.varnittyagi.assignment.adapters.GameAdapter
import com.varnittyagi.assignment.models.GamesModel

class InfoScreen : ComponentActivity(), GameAdapter.Clickable {
    private lateinit var gameAdapter: GameAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_screen)

        val recyclerView:RecyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        gameAdapter = GameAdapter(this,this)
        recyclerView.adapter = gameAdapter

        val gameList = arrayListOf<GamesModel>()

        gameList.add(GamesModel(R.drawable.cap_2,"GAME NO 1",R.drawable.img_1))
        gameList.add(GamesModel(R.drawable.cards,"GAME NO 2",R.drawable.img_1))
        gameList.add(GamesModel(R.drawable.house,"GAME NO 3",R.drawable.img_1))
        gameList.add(GamesModel(R.drawable.trophy,"GAME NO 4",R.drawable.img_1))
        gameList.add(GamesModel(R.drawable.ludo,"GAME NO 5",R.drawable.img_1))

    gameAdapter.updateList(gameList)
    }

    override fun onCLick(gamelist: ArrayList<GamesModel>, position: Int) {
        Toast.makeText(this, "You clicked on ${gamelist[position].gameName}", Toast.LENGTH_SHORT).show()
    }
}