package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

/**
 * This activity allows the user to roll a dice and view the result on the screen
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() } // Defines what the button does

        rollDice() // Do a roll when the app starts
    }

    /**
     * Roll the dice and update the screen with the result
     */
    private fun rollDice() {
        // Create a new dice with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Determine witch drawable resource ID to be used based on the dice roll
        val diceImage: ImageView = findViewById(R.id.imageView)
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update de image with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}