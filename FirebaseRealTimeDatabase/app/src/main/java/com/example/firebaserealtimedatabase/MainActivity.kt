package com.example.firebaserealtimedatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = FirebaseDatabase.getInstance()
        val refKisiler = database.getReference("kisiler")
        val kisi = Kisiler("Zeynep",20)

        //refKisiler.push().setValue(kisi)

        //refKisiler.child("-MTAp8_6ooo_EodbS2gZ").removeValue()

        /*val updateInfo = HashMap<String,Any>()
        updateInfo["kisi_ad"] = "Medine"
        updateInfo["kisi_yas"] = 23

        refKisiler.child("-MTApNErjBabC1I7H8Ge").updateChildren(updateInfo)*/

        //val sorgu = refKisiler.orderByChild("kisi_ad").equalTo("Medine")
        //val sorgu = refKisiler.limitToFirst(1)
        //val sorgu = refKisiler.limitToLast(1)
        val sorgu = refKisiler.orderByChild("kisi_yas").startAt(30.0).endAt(50.0)

        sorgu.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                for(p in snapshot.children){
                    val kisi = p.getValue(Kisiler :: class.java)

                    if(kisi != null){
                        Log.e("******","***************")
                        Log.e("Kisi Ad", kisi.kisi_ad.toString())
                        Log.e("Kişi yaş",kisi.kisi_yas.toString())
                    }
                }

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
}