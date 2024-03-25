package com.example.offlinejsondata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView;
    var informationList = arrayListOf<InformationData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.adapter = InformationAdapterClass(informationList)


        val jsonData = applicationContext.resources.openRawResource(
            applicationContext.resources.getIdentifier(
                "information",
                "raw",
                applicationContext.packageName
            )
        ).bufferedReader().use { it.readText() }

        val outputJsonString = JSONObject(jsonData)

        val informationArray = outputJsonString.getJSONArray("information") as JSONArray

        for (i in 0 until informationArray.length()) {

            val id = informationArray.getJSONObject(i).getString("id")
            val name = informationArray.getJSONObject(i).getString("name")
            val fatherName = informationArray.getJSONObject(i).getString("fatherName")
            val userName = informationArray.getJSONObject(i).getString("userName")
            val color = informationArray.getJSONObject(i).getString("color")
            val password = informationArray.getJSONObject(i).getString("password")

            informationList.add(InformationData(id, name, fatherName, userName, color, password))
        }


    }
}