package com.example.numberguessssinggame

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var randomNumber = Random.nextInt(1, 101)
    private var attempts = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etGuess = findViewById<EditText>(R.id.et_guess)
        val btnGuess = findViewById<Button>(R.id.btn_guess)
        val tvStatus = findViewById<TextView>(R.id.tv_status)
        val tvAttempts = findViewById<TextView>(R.id.tv_attempts)

        btnGuess.setOnClickListener {

            val guessText = etGuess.text.toString()

            if (guessText.isNotEmpty()) {

                val userGuess = guessText.toInt()

                attempts++
                tvAttempts.text = "Attempts: $attempts"

                when {
                    userGuess < randomNumber ->
                        tvStatus.text = "Too low! Try again."

                    userGuess > randomNumber ->
                        tvStatus.text = "Too high! Try again."

                    else -> {
                        tvStatus.text =
                            "Congratulations! It was $randomNumber"

                        btnGuess.isEnabled = false
                    }
                }

                etGuess.text.clear()

            } else {
                tvStatus.text = "Enter a number!"
            }
        }
    }
}