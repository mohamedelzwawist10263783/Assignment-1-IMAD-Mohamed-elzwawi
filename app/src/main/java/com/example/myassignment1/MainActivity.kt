package com.example.myassignment1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val famousPeople = mapOf(
        "Nelson Mandela" to 95,
        "William Shakespeare" to 52,
        "Albert Einstein" to 76,
        "Leonardo da Vinci" to 67,
        "Mahatma Gandhi" to 78,
        "Martin Luther King Jr." to 39,
        "Mother Teresa" to 87,
        "Isaac Newton" to 84,
        "Winston Churchill" to 90,
        "Queen Elizabeth II" to 95,
        "Vincent van Gogh" to 37,
        "Anne Frank" to 15,
        "Alexander Graham Bell" to 75,
        "Marie Curie" to 66,
        "Pablo Picasso" to 91,
        "Walt Disney" to 65,
        "Neil Armstrong" to 82,
        "Amelia Earhart" to 39,
        "Charlie Chaplin" to 88,
        "Helen Keller" to 87
        // Add more famous people and their ages here
    )

    private lateinit var ageInput: EditText
    private lateinit var submitButton: Button
    private lateinit var clearButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ageInput = findViewById(R.id.age_input)
        submitButton = findViewById(R.id.submit_button)
        clearButton = findViewById(R.id.clear_button)
        resultTextView = findViewById(R.id.result_text_view)

        submitButton.setOnClickListener { matchAge() }
        clearButton.setOnClickListener { resetApp() }
    }

    private fun matchAge() {
        val ageText = ageInput.text.toString()
        if (ageText.isEmpty()) {
            resultTextView.text = "Please enter your age."
            return
        }

        val age = ageText.toIntOrNull()
        if (age == null || age !in 20..100) {
            resultTextView.text = "Please enter a valid age between 20 and 100."
            return
        }

        val matchedPerson = famousPeople.entries.find { it.value == age }?.key
        if (matchedPerson != null) {
            resultTextView.text = "You share the age with $matchedPerson."
        } else {
            resultTextView.text = "No famous person found with the age $age."
        }
    }

    private fun resetApp() {
        ageInput.text.clear()
        resultTextView.text = ""
    }
}
