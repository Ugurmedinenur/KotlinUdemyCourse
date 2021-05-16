package com.example.bayrakquisuygulamas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {

    private lateinit var questions: ArrayList<Bayraklar>
    private lateinit var falseOptions: ArrayList<Bayraklar>
    private lateinit var trueQuestion: Bayraklar
    private lateinit var allOptions: HashSet<Bayraklar>
    private lateinit var vt: DatabaseHelper

    private var qCounter = 0
    private var tCounter = 0
    private var fCounter = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        vt = DatabaseHelper(this)

        questions = BayraklarDao().randomFlags(vt)

        loadQuestion()

        buttonA.setOnClickListener {

            controlCounter()
            controlAnswer(buttonA)

        }
        buttonB.setOnClickListener {
            controlCounter()
            controlAnswer(buttonB)
        }
        buttonC.setOnClickListener {
            controlCounter()
            controlAnswer(buttonC)
        }
        buttonD.setOnClickListener {
            controlCounter()
            controlAnswer(buttonD)
        }
    }

    fun loadQuestion(){
        textViewQCount.text = "${qCounter+1}. SORU"

        trueQuestion = questions.get(qCounter)

        imageViewBayrak.setImageResource(resources.getIdentifier(trueQuestion.bayrak_resim, "drawable", packageName))

        falseOptions = BayraklarDao().falseOptions(vt, trueQuestion.bayrak_id)

        allOptions = HashSet()
        allOptions.add(trueQuestion)

        for(i in falseOptions){
            allOptions.add(i)
        }

        buttonA.text = allOptions.elementAt(0).bayrak_ad
        buttonB.text = allOptions.elementAt(1).bayrak_ad
        buttonC.text = allOptions.elementAt(2).bayrak_ad
        buttonD.text = allOptions.elementAt(3).bayrak_ad

    }

    fun controlCounter(){
        qCounter++

        if(qCounter != 5){
            loadQuestion()
        }
        else{
            val intent = Intent(this@QuizActivity, ResultActivity :: class.java)
            intent.putExtra("tCounter",tCounter)
            startActivity(intent)
            finish()
        }
    }

    fun controlAnswer(button:Button){

        if(button.text.toString() == trueQuestion.bayrak_ad){
            tCounter++
        }
        else{
            fCounter++
        }

        textViewTrue.text = "Doğru : $tCounter"
        textViewFalse.text = "Yanlış : $fCounter"


    }
}