package com.example.timedatepicker

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    //Edit text e tıkladığımızda bazen klavye açılıyor bunu engelemek için design kısmında edit textlerin altına  "android:focusableInTouchMode="false"" yazmalıyız

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText_saat.setOnClickListener {

            val calender = Calendar.getInstance()

            val saat = calender.get(Calendar.HOUR_OF_DAY)
            val dakika = calender.get(Calendar.MINUTE)

            val timePicker = TimePickerDialog(this@MainActivity, TimePickerDialog.OnTimeSetListener { timePicker, s, dk ->

                editText_saat.setText("$s : $dk")

            }, saat, dakika, true)

            timePicker.setTitle("Saat Seçiniz.")
            timePicker.setButton(DialogInterface.BUTTON_POSITIVE, "AYARLA", timePicker)
            timePicker.setButton(DialogInterface.BUTTON_NEGATIVE,"İPTAL", timePicker)

            timePicker.show()

        }

        editText_tarih.setOnClickListener {

            val calender = Calendar.getInstance()

            val year = calender.get(Calendar.YEAR)
            val month = calender.get(Calendar.MONTH)
            val day = calender.get(Calendar.DAY_OF_MONTH)

            val datePicker = DatePickerDialog(this@MainActivity, DatePickerDialog.OnDateSetListener { datePicker, y, m, d ->

                editText_tarih.setText("$d/${m+1}/$y")

            },year, month, day)

            datePicker.setTitle("Tarih Seçiniz.")
            datePicker.setButton(DialogInterface.BUTTON_POSITIVE, "AYARLA",datePicker)
            datePicker.setButton(DialogInterface.BUTTON_NEGATIVE,"İPTAL", datePicker)

            datePicker.show()

        }
    }
}