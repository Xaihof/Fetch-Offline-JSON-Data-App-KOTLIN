package com.example.offlinejsondata

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class InformationAdapterClass(private val informationList: List<InformationData>) :
    RecyclerView.Adapter<InformationAdapterClass.InformationViewHolder>() {

    inner class InformationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textViewIdValue = itemView.findViewById<TextView>(R.id.textViewIdValue)
        val textViewNameValue = itemView.findViewById<TextView>(R.id.textViewNameValue)
        val textViewFatherNameValue = itemView.findViewById<TextView>(R.id.textViewFatherNameValue)
        val textViewUserNameValue = itemView.findViewById<TextView>(R.id.textViewUserNameValue)
        val textViewColorValue = itemView.findViewById<TextView>(R.id.textViewColorValue)
        val textViewPasswordValue = itemView.findViewById<TextView>(R.id.textViewPasswordValue)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InformationViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return InformationViewHolder(view)
    }

    override fun getItemCount(): Int {
        return informationList.size
    }

    override fun onBindViewHolder(holder: InformationViewHolder, position: Int) {

        val information = informationList[position]

        holder.textViewIdValue.text = information.id
        holder.textViewNameValue.text = information.name
        holder.textViewFatherNameValue.text = information.fatherName
        holder.textViewUserNameValue.text = information.userName
        holder.textViewColorValue.text = information.color
        holder.textViewPasswordValue.text = information.password

    }
}