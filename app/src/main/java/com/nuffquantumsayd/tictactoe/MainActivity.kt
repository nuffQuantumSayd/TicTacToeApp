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

        //Identify new game button and set a listener for it
        val newGameButton = findViewById<Button>(R.id.new_game)
        newGameButton.setOnClickListener{
            newGamePressed()
        }

    }
    private fun newGamePressed(){
        Toast.makeText(this,"new game button was pressed!!", Toast.LENGTH_SHORT).show()
    }

}
