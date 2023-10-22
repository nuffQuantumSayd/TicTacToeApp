package com.nuffquantumsayd.tictactoe

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Get list of all buttons
        val gameBoardButtons = getListOfButtons()


        //identify text box
        val textView = findViewById<TextView>(R.id.textView)

        //Identify new game button and set a listener for it
        val newGameButton = findViewById<Button>(R.id.new_game)
        newGameButton.setOnClickListener{
            newGamePressed(textView, gameBoardButtons)
        }

    }

    /*
    this function gets all buttons buttons from the game board, adds them to a list,
    then returns the list
     */
    private fun getListOfButtons(): List<Button> {
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
        val gameBoardButtons = listOf<Button>(
            topLeftButton, topMiddleButton, topRightButton,
            middleLeftButton, middleMiddleButton, middleRightButton,
            bottomLeftButton, bottomMiddleButton, bottomRightButton
        )
        return gameBoardButtons
    }

    /*
    this function resets the game board buttons and starts a new game with Player X as the first
    player
     */
    private fun newGamePressed(textView: TextView, list: List<Button>){
        textView.text = "Player X turn"
        for (i in 0..< list.size){
            list[i].text = ""
        }
    }

}
