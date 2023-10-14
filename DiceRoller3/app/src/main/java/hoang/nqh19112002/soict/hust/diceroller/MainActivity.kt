package hoang.nqh19112002.soict.hust.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButtonMA: Button = findViewById(R.id.button_AM)
        rollButtonMA.setOnClickListener {
            rollDiceMA()
//            val textViewMA: TextView = findViewById(R.id.textViewMA)
//            textViewMA.text = "4"

            val toastMA = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_LONG)
            toastMA.show()
        }

    }
    private fun rollDiceMA()
    {
        val diceMA = DiceMA(6)
        val cubeRoll1 = diceMA.rollMA()
        val cubeRoll2 = diceMA.rollMA()
//        val textViewMA: TextView = findViewById(R.id.textViewMA)
//        textViewMA.text = cubeRoll.toString()
        val diceImage: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView2)

        when(cubeRoll1){
            1-> diceImage.setImageResource(R.drawable.dice1)
            2-> diceImage.setImageResource(R.drawable.dice2)
            3-> diceImage.setImageResource(R.drawable.dice3)
            4-> diceImage.setImageResource(R.drawable.dice4)
            5-> diceImage.setImageResource(R.drawable.dice5)
            5-> diceImage.setImageResource(R.drawable.dice6)
        }

        when(cubeRoll2){
            1-> diceImage2.setImageResource(R.drawable.dice1)
            2-> diceImage2.setImageResource(R.drawable.dice2)
            3-> diceImage2.setImageResource(R.drawable.dice3)
            4-> diceImage2.setImageResource(R.drawable.dice4)
            5-> diceImage2.setImageResource(R.drawable.dice5)
            5-> diceImage2.setImageResource(R.drawable.dice6)
        }

    }
    class DiceMA (val numSideMA: Int)
    {
        fun rollMA(): Int
        {
            return (1..numSideMA).random()
        }
    }
}

