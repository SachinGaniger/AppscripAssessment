package com.sachin.appscripassessment.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sachin.appscripassessment.databinding.IndividualUserLayoutBinding
import com.sachin.appscripassessment.db.Summary

class HistoryAdapter(
    private var summaryList: ArrayList<Summary>,
): RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    inner class ViewHolder(private val holderBinding: IndividualUserLayoutBinding): RecyclerView.ViewHolder(holderBinding.root) {

        ////bind function for referencing and populate all views with data
        fun bind(summary: Summary){
            holderBinding.apply {
                tvHistoryName.text = "Name: ${summary.name}"
                game.text = "Game: ${summary.id}"
                tvHistoryCricketerAns.text = summary.singleChoice
                tvHistoryNationalFlagAns.text = summary.multipleChoice
                date.text = "Date: ${summary.date}"
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = IndividualUserLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val summary = summaryList[position]
        holder.bind(summary)
    }

    override fun getItemCount(): Int {
        return summaryList.size
    }

}