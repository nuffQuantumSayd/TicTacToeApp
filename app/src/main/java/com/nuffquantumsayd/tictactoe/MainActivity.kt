package com.nuffquantumsayd.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //identify other buttons to set with
        //top row
        val topLeftButton = findViewById<Button>(R.id.top_left)
        val topMiddleButton = findViewById<Button>(R.id.top_middle)
        val topRightButton = findViewById<Button>(R.id.top_right)
        //middle row
        val middleLeftButton = findViewById<Button>(R.id.middle_left)
        val middleMiddleButton = findViewById<Button>(R.id.the_middle)
        val middleRightButton = findViewById<Button>(R.id.middle_right)
        //bottom row
        val bottomLeftButton = findViewById<Button>(R.id.bottom_left)
        val bottomMiddleButton = findViewById<Button>(R.id.bottom_middle)
        val bottomRightButton = findViewById<Button>(R.id.bottom_right)

        //put buttons into arraylist of buttons
        val gameBoardButtons = listOf<Button>(topLeftButton, topMiddleButton, topRightButton,
                                                middleLeftButton, middleMiddleButton, middleRightButton,
                                               bottomLeftButton, bottomMiddleButton, bottomRightButton)


        //Identify new game button and set a listener for it
        val newGameButton = findViewById<Button>(R.id.new_game)
        newGameButton.setOnClickListener{
            newGamePressed()
        }

    }
    private fun newGamePressed(){
        val toastText = "new game was pressed"
        Toast.makeText(this,toastText, Toast.LENGTH_SHORT).show()
    }

}
