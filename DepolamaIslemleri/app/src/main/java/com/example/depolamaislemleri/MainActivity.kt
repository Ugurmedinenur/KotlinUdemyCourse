package com.example.depolamaislemleri

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*
import java.lang.StringBuilder
import kotlin.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonYaz.setOnClickListener {
            dahiliYaz()
            //hariciYaz()
        }

        buttonRead.setOnClickListener {
            dahiliOku()
            //hariciOku()
        }

        buttonDelete.setOnClickListener {
            dahiliSil()
            //hariciSil()
        }

    }

    fun hariciYaz(){
        //java io işlemleri hata olma ihtimali yüksektir. Bu yüzden try catch kullanılır
        try {
            val yol = applicationContext.getExternalFilesDir(null)?.absolutePath
            val file = File(yol, "dosya.txt")

            if(!file.exists()){ // bu dosya yoksa oluştur.
                file.createNewFile()
            }

            val fw = FileWriter(file)
            val writer = BufferedWriter(fw)

            writer.write(editTextInput.text.toString())

            writer.flush()//veri kaybını engellemek için kullanılır.
            writer.close()
            fw.close()

            editTextInput.setText("")

        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    fun hariciOku(){
        try {
            val yol = applicationContext.getExternalFilesDir(null)?.absolutePath
            val file = File(yol, "dosya.txt")

            val fr = FileReader(file)
            val reader = BufferedReader(fr)

            val sb = StringBuilder()

            var satir:String? = null //bu değişken null olabilir demek için yanına ? işareti konur

            while ({satir = reader.readLine();satir}() != null){
                sb.append(satir+"\n")
            }

            reader.close()
            editTextInput.setText(sb.toString())

        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    fun hariciSil(){
        try {
            val yol = applicationContext.getExternalFilesDir(null)?.absolutePath
            val file = File(yol, "dosya.txt")

            file.delete()
            editTextInput.setText("")


        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    fun dahiliYaz(){
        try {

            val fo = openFileOutput("dosyam.txt", Context.MODE_PRIVATE)
            val writer = OutputStreamWriter(fo)

            writer.write(editTextInput.text.toString())
            writer.close()

            editTextInput.setText("")

        }catch (e:Exception){
            e.printStackTrace()
        }
    }
    fun dahiliOku(){
        try {
            val fi = openFileInput("dosyam.txt")
            val isr = InputStreamReader(fi)

            val reader = BufferedReader(isr)

            val sb = StringBuilder()

            var satir:String? = null //bu değişken null olabilir demek için yanına ? işareti konur

            while ({satir = reader.readLine();satir}() != null){
                sb.append(satir+"\n")
            }

            reader.close()
            editTextInput.setText(sb.toString())

        }catch (e:Exception){
            e.printStackTrace()
        }
    }
    fun dahiliSil(){
        try {

            val dir = filesDir
            val dosya = File(dir, "dosyam.txt")
            dosya.delete()
            editTextInput.setText("")

        }catch (e:Exception){
            e.printStackTrace()
        }

    }
}