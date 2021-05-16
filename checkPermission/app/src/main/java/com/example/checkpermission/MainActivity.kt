package com.example.checkpermission

import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.util.jar.Manifest

class MainActivity : AppCompatActivity(), LocationListener {
    private var controlPermission = 0;
    private lateinit var locationManager : LocationManager
    private val locationProvider = "gps"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager

        buttonKonumAl.setOnClickListener {
            controlPermission = ContextCompat.checkSelfPermission( this@MainActivity, android.Manifest.permission.ACCESS_FINE_LOCATION)
            if(controlPermission != PackageManager.PERMISSION_GRANTED){

                ActivityCompat.requestPermissions(this@MainActivity, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),100)

            }else{
                val location = locationManager.getLastKnownLocation(locationProvider)
                if(location != null){

                    onLocationChanged(location)

                }else{
                    textViewEnlem.text = "Konum alınamadı"
                    textViewBoylam.text = "Konum alınamadı"
                }
            }

        }

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {

        if (requestCode == 100){
            controlPermission = ContextCompat.checkSelfPermission( this@MainActivity, android.Manifest.permission.ACCESS_FINE_LOCATION)
            if(grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                val location = locationManager.getLastKnownLocation(locationProvider)
                if(location != null){

                    onLocationChanged(location)

                }else{
                    textViewEnlem.text = "Konum alınamadı"
                    textViewBoylam.text = "Konum alınamadı"
                }
                Toast.makeText(applicationContext, "İzin onaylandı ve aktif edildi", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(applicationContext, "İzin onaylanmadı", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onLocationChanged(location: Location) {
        val latitude = location?.latitude
        val longitude = location?.longitude

        textViewEnlem.text = latitude.toString()
        textViewBoylam.text = longitude.toString()
    }

}