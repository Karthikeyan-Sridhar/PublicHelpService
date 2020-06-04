package com.developersinc.publichelpservice.Activity

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.developersinc.publichelpservice.R
import com.developersinc.publichelpservice.databinding.ActivityUpdateDetailsBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class UpdateDetails : AppCompatActivity() {

    lateinit var binding:ActivityUpdateDetailsBinding

    lateinit var position:String

    lateinit var desc:String

    lateinit var add:String

    lateinit var slot:String

    lateinit var mAuth:FirebaseAuth

    lateinit var databaseRef:DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_update_details)

        mAuth= FirebaseAuth.getInstance()

        databaseRef = FirebaseDatabase.getInstance().getReference().child("Users")

        position = intent.getStringExtra("position")
        desc = intent.getStringExtra("desc")
        add = intent.getStringExtra("add")
        slot = intent.getStringExtra("slot")

        //Log.i("data" , position+desc+add+slot)

        //********Setting the data into the edit text**********************

        binding.addEditText.setText(add)
        binding.desEditText.setText(desc)
        binding.slotEditText.setText(slot)

        //*******************updating the database*************
        binding.btn.setOnClickListener {

            databaseRef.child(mAuth.currentUser!!.uid).child("Public_Help_Service").child(position)
                .child("description").setValue(binding.desEditText.text.toString())

            databaseRef.child(mAuth.currentUser!!.uid).child("Public_Help_Service").child(position)
                .child("address").setValue(binding.addEditText.text.toString())

            databaseRef.child(mAuth.currentUser!!.uid).child("Public_Help_Service").child(position)
                .child("category").setValue(binding.slotEditText.text.toString())

            Toast.makeText(this@UpdateDetails,"Details updated" , Toast.LENGTH_SHORT).show()
            onBackPressed()


        }





    }
}
