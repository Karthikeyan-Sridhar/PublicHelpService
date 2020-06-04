package com.developersinc.publichelpservice.Fragments


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.developersinc.publichelpservice.Activity.UpdateDetails
import com.developersinc.publichelpservice.Models.SavedIssuesModel

import com.developersinc.publichelpservice.R
import com.developersinc.publichelpservice.ViewHolder.SavedIssuesViewHolder
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SavedFragment : Fragment() {

    lateinit var recyclerView: RecyclerView

    lateinit var databaseRef:DatabaseReference

    lateinit var adapter:FirebaseRecyclerAdapter<SavedIssuesModel,SavedIssuesViewHolder>

    lateinit var options: FirebaseRecyclerOptions<SavedIssuesModel>

    lateinit var mAuth:FirebaseAuth


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view:View = inflater.inflate(R.layout.fragment_saved, container, false)

        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.setHasFixedSize(true)

        mAuth = FirebaseAuth.getInstance()

        databaseRef = FirebaseDatabase.getInstance().getReference().child("Users").child(mAuth.currentUser!!.uid)
            .child("Public_Help_Service")

        options = FirebaseRecyclerOptions.Builder<SavedIssuesModel>()
            .setQuery(databaseRef,
                SavedIssuesModel::class.java).build()

        adapter =  object: FirebaseRecyclerAdapter<SavedIssuesModel, SavedIssuesViewHolder>(options)
        {
            override fun onBindViewHolder(holder: SavedIssuesViewHolder, position: Int, model: SavedIssuesModel) {
                Log.i("position" , position.toString())
                holder!!.desc.setText(model!!.description)
                holder.add.setText(model.address)
                holder.latt.setText(model.lattitude)
                holder.long.setText(model.longitude)
                holder.slot.setText(model.category)

                holder.cardView.setOnClickListener{ val intent = Intent(context,UpdateDetails::class.java)
                intent.putExtra("position" , (position+1).toString())
                    intent.putExtra("desc" , model.description)
                    intent.putExtra("add" , model.address)
                    intent.putExtra("slot" , model.category)
                    startActivity(intent)

                }
            }


            override fun onCreateViewHolder(p0: ViewGroup, p1: Int): SavedIssuesViewHolder {
                return SavedIssuesViewHolder(LayoutInflater.from(p0.context)
                    .inflate(R.layout.issues_layout,p0,false))
            }


        }
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter.startListening()
        recyclerView.adapter=adapter


        return view
    }

    override fun onStart() {
        super.onStart()

        if (adapter!=null)
        {
            adapter.startListening()
        }
    }

    override fun onStop() {
        if (adapter!=null)
        {
            adapter.stopListening()
        }
        super.onStop()
    }

    override fun onResume() {
        super.onResume()

        if (adapter!=null)
        {
            adapter.startListening()
        }

    }


}
