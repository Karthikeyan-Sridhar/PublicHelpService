package com.developersinc.publichelpservice.ViewHolder

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.developersinc.publichelpservice.R
import kotlinx.android.synthetic.main.issues_layout.view.*

class SavedIssuesViewHolder: RecyclerView.ViewHolder {

    lateinit var desc:TextView

    lateinit var add:TextView

    lateinit var latt:TextView

    lateinit var long:TextView

    lateinit var slot:TextView

    lateinit var cardView: CardView


    constructor(itemView: View) : super(
        itemView
    ) {

        desc = itemView.findViewById(R.id.desc_txt_view)
        add = itemView.findViewById(R.id.address_txt_view)

        latt = itemView.findViewById(R.id.latt_txt_view)
        long = itemView.findViewById(R.id.long_txt_view)
        slot = itemView.findViewById(R.id.slots_txt_view)
        cardView = itemView.findViewById(R.id.cardView)

    }
}