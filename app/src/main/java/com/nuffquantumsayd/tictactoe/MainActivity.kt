package com.nuffquantumsayd.tictactoe

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playersTurn = PlayersTurn(playerX = true, playerO = false)
        var buttonCounter = ButtonCounter(0)

        //Get list of all buttons
        val gameBoardButtons = getListOfButtons()
        //identify text box
        val textView = findViewById<TextView>(R.id.textView)

        //Game buttons functionality
        ButtonGamePlay(gameBoardButtons, playersTurn, textView, buttonCounter)

        //Identify new game button and set a listener for it
        val newGameButton = findViewById<Button>(R.id.new_game)
        newGameButton.setOnClickListener{
            newGamePressed(textView, gameBoardButtons, playersTurn, buttonCounter)
        }

        //Game logic for win
    }

    private fun ButtonGamePlay(
        gameBoardButtons: List<Button>,
        playersTurn: PlayersTurn,
        textView: TextView,
        buttonCount: ButtonCounter
    ) {

        //Index reference
        //  0   1   2
        //  3   4   5
        //  6   7   8


        // O    X   O
        // O        X
        // X    O   X



        for (i in 0..<gameBoardButtons.size) {
            gameBoardButtons[i].setOnClickListener {
                //First checks which player then increments the button count by one, disables the button, adds the button totem of the player
                if (playersTurn.playerX){
                    gameBoardButtons[i].isEnabled = false
                    gameBoardButtons[i].text = "X"
                    buttonCount.buttonCount++
                }
                else {
                    gameBoardButtons[i].isEnabled = false
                    gameBoardButtons[i].text = "O"
                    buttonCount.buttonCount++
                }
                //If the player is X, proceed to check winning combinations
                if (playersTurn.playerX) {
                    //all possible X combinations
                    if (winningGameBoardCombonation(gameBoardButtons, "X")){
                        textView.text = getString(R.string.player_x_wins)
                        //disable all the buttons
                        for (i in 0..<gameBoardButtons.size){
                            gameBoardButtons[i].isEnabled = false
                        }
                        buttonCount.buttonCount = 0

                    }

                    //If no winning combinations check if the game could be a tie
                    else if (buttonCount.buttonCount > 8) {
                        if (playersTurn.playerX) {
                            gameBoardButtons[i].text = "X"
                        } else {
                            gameBoardButtons[i].text = "O"
                        }
                        textView.text = getString(R.string.tie_player_x_and_player_o_win)
                        buttonCount.buttonCount = 0
                    }
                    //If neither a tie or winning combination is true it is the next players turn
                    else{
                        playersTurn.playerX = false
                        playersTurn.playerO = true
                        textView.text = getString(R.string.player_o_turn)
                    }

                //player O
                //If the player is O, proceed to check winning combinations
                } else {
                    //all possible O combinations
                    if (winningGameBoardCombonation(gameBoardButtons, "O")){
                        textView.text = getString(R.string.player_o_wins)
                        //disable all the buttons
                        for (i in 0..< gameBoardButtons.size){
                            gameBoardButtons[i].isEnabled = false
                        }
                        buttonCount.buttonCount = 0
                    }
                    //If no winning combinations check if the game could be a tie
                    else if (buttonCount.buttonCount > 8){
                        if (playersTurn.playerX) {
                            gameBoardButtons[i].text = "X"
                        } else {
                            gameBoardButtons[i].text = "O"
                        }
                        textView.text = getString(R.string.tie_player_x_and_player_o_win)
                        buttonCount.buttonCount = 0
                    }
                    //If neither a tie or winning combination is true it is the next players turn
                    else {
                        playersTurn.playerO = false
                        playersTurn.playerX = true
                        textView.text = getString(R.string.player_x_turn)
                    }

                }
            }
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
    private fun newGamePressed(textView: TextView, list: List<Button>, playersTurn: PlayersTurn, buttonCount: ButtonCounter){
        playersTurn.playerX = true
        playersTurn.playerO = false
        buttonCount.buttonCount = 0
        textView.text = getString(R.string.player_x_turn)
        for (i in 0..< list.size){
            list[i].isEnabled = true
            list[i].text = ""
        }
    }

    /*
    this function takes a list of buttons and a token, returns true is a winning combination is met. false otherwise
     */
    private fun winningGameBoardCombonation(gameBoardButtons: List<Button>, token: String): Boolean {
        if (gameBoardButtons[0].text.equals(token) && gameBoardButtons[1].text.equals(token) && gameBoardButtons[2].text.equals(token)
            || gameBoardButtons[3].text.equals(token) && gameBoardButtons[4].text.equals(token) && gameBoardButtons[5].text.equals(token)
            || gameBoardButtons[6].text.equals(token) && gameBoardButtons[7].text.equals(token) && gameBoardButtons[8].text.equals(token)
            || gameBoardButtons[0].text.equals(token) && gameBoardButtons[3].text.equals(token) && gameBoardButtons[6].text.equals(token)
            || gameBoardButtons[1].text.equals(token) && gameBoardButtons[4].text.equals(token) && gameBoardButtons[7].text.equals(token)
            || gameBoardButtons[2].text.equals(token) && gameBoardButtons[5].text.equals(token) && gameBoardButtons[8].text.equals(token)
            || gameBoardButtons[0].text.equals(token) && gameBoardButtons[4].text.equals(token) && gameBoardButtons[8].text.equals(token)
            || gameBoardButtons[6].text.equals(token) && gameBoardButtons[4].text.equals(token) && gameBoardButtons[2].text.equals(token)){
            return true
        }
        return false
    }

}
