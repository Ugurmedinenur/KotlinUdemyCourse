package com.example.game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.activity_result.*
import java.util.*
import kotlin.concurrent.schedule
import kotlin.math.floor

class GameActivity : AppCompatActivity() {

    // positions
    private var playerX = 0.0f;
    private var playerY = 0.0f;

    private var yellowCircleX = 0.0f;
    private var yellowCircleY = 0.0f;

    private var redTriangleX = 0.0f;
    private var redTriangleY = 0.0f;

    private var blackSquareX = 0.0f;
    private var blackSquareY = 0.0f;

    //measures
    private var screenWidth  = 0
    private var screenHeight = 0
    private var playerWidth  = 0
    private var playerHeight  = 0

    //controls
    private var control = false
    private var startControl = false

    private val timer = Timer()

    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        imageViewBlackSquare.x = -1000.0f
        imageViewBlackSquare.y = -1000.0f
        imageViewRedTriangle.x = -800.0f
        imageViewRedTriangle.y = -800.0f
        imageViewYellowCircle.x = -800.0f
        imageViewYellowCircle.y = -800.0f

        cl.setOnTouchListener(object : View.OnTouchListener{

            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                if(startControl){
                    if(event?.action == MotionEvent.ACTION_DOWN){
                        control = true
                        Log.e("Motion Event","ACTION DOWN")
                    }
                    if(event?.action == MotionEvent.ACTION_UP){
                        control = false
                        Log.e("Motion Event","ACTION UP")
                    }
                }else{
                    startControl = true
                    textViewGameStart.visibility = View.INVISIBLE
                    playerX = imageViewPlayer.x
                    playerY = imageViewPlayer.y

                    playerWidth = imageViewPlayer.width
                    playerHeight = imageViewPlayer.height
                    screenWidth = cl.width
                    screenHeight = cl.height
                    timer.schedule(0,20){
                        Handler(Looper.getMainLooper()).post {

                            motionOfPlayer()
                            motionOfObjects()
                            collisionControl()
                        }
                    }
                }
                return true

            }

        })

    }

    fun motionOfPlayer(){

        val playerSpeed = screenHeight/60.0f

        if(control){

            playerY -= playerSpeed

        }else{
            playerY += playerSpeed
        }

        if(playerY <= 0.0f){
            playerY = 0.0f
        }
        if(playerY >= screenHeight - playerHeight){
            playerY = (screenHeight - playerHeight).toFloat()
        }

        imageViewPlayer.y = playerY
    }

    fun motionOfObjects(){

        blackSquareX -= screenWidth/44.0f
        yellowCircleX -= screenWidth/54.0f
        redTriangleX -= screenWidth/36.0f

        if(blackSquareX < 0.0f){
            blackSquareX = screenWidth + 20.0f
            blackSquareY = floor(Math.random()*(screenHeight - 10)).toFloat()
        }
        imageViewBlackSquare.x = blackSquareX
        imageViewBlackSquare.y = blackSquareY

        if(yellowCircleX< 0.0f){
            yellowCircleX = screenWidth + 20.0f
            yellowCircleY = floor(Math.random()*(screenHeight - 10)).toFloat()
        }
        imageViewYellowCircle.x = yellowCircleX
        imageViewYellowCircle.y = yellowCircleY

        if(redTriangleX< 0.0f){
            redTriangleX = screenWidth + 20.0f
            redTriangleY = floor(Math.random()*(screenHeight - 10)).toFloat()
        }
        imageViewRedTriangle.x = redTriangleX
        imageViewRedTriangle.y = redTriangleY
    }

    fun collisionControl(){
        val yellowCircleCenterX = yellowCircleX + imageViewYellowCircle.width/2.0f
        val yellowCircleCenterY = yellowCircleY + imageViewYellowCircle.height/2.0f

        if(0.0f <= yellowCircleCenterX && yellowCircleCenterX <= playerWidth
            && playerY <= yellowCircleCenterY && yellowCircleCenterY <= playerY + playerHeight){

            score += 20
            yellowCircleX = -10.0f

        }
        val redTriangleCenterX = redTriangleX + imageViewRedTriangle.width/2.0f
        val redTriangleCenterY = redTriangleY + imageViewRedTriangle.height/2.0f

        if(0.0f <= redTriangleCenterX && redTriangleCenterX <= playerWidth
            && playerY <= redTriangleCenterY && redTriangleCenterY <= playerY + playerHeight){

            score += 20
            redTriangleX = -10.0f

        }

        val blackSquareCenterX = blackSquareX + imageViewBlackSquare.width/2.0f
        val blackSquareCenterY = blackSquareY + imageViewBlackSquare.height/2.0f

        if(0.0f <= blackSquareCenterX && blackSquareCenterX <= playerWidth
            && playerY <= blackSquareCenterY && blackSquareCenterY <= playerY + playerHeight){

            blackSquareX = -10.0f
            timer.cancel()

            val intent = Intent(this@GameActivity, ResultActivity :: class.java)
            intent.putExtra("score",score)
            startActivity(intent)
            finish()


        }
        textViewScore.text = score.toString()
    }
}