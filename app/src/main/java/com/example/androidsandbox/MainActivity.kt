package com.example.androidsandbox

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var result = 0

        val inputField = findViewById<EditText>(R.id.input)
        val resultField = findViewById<TextView>(R.id.result)
        val button0 = findViewById<Button>(R.id.button0)
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val button5 = findViewById<Button>(R.id.button5)
        val button6 = findViewById<Button>(R.id.button6)
        val button7 = findViewById<Button>(R.id.button7)
        val button8 = findViewById<Button>(R.id.button8)
        val button9 = findViewById<Button>(R.id.button9)
        // Set click listeners for the buttons
        button0.setOnClickListener { inputField.append("0") }
        button1.setOnClickListener { inputField.append("1") }
        button2.setOnClickListener { inputField.append("2") }
        button3.setOnClickListener { inputField.append("3") }
        button4.setOnClickListener { inputField.append("4") }
        button5.setOnClickListener { inputField.append("5") }
        button6.setOnClickListener { inputField.append("6") }
        button7.setOnClickListener { inputField.append("7") }
        button8.setOnClickListener { inputField.append("8") }
        button9.setOnClickListener { inputField.append("9") }



        val buttonAdd = findViewById<Button>(R.id.buttonAdd)
        val buttonSubtract = findViewById<Button>(R.id.buttonSubtract)
        val buttonMultiply = findViewById<Button>(R.id.buttonMultiply)
        val buttonDivide = findViewById<Button>(R.id.buttonDivide)
        val buttonEquals = findViewById<Button>(R.id.buttonEquals)

        buttonAdd.setOnClickListener {
            val input_txt = inputField.text.toString()
            result += input_txt.toInt()
            resultField.append("+ $input_txt\n")
            inputField.text.clear()
            resultField.append(result.toString() + "\n")
        }

        buttonSubtract.setOnClickListener {
            val input_txt = inputField.text.toString()
            result -= input_txt.toInt()
            resultField.append("- $input_txt\n")
            inputField.text.clear()
            resultField.append(result.toString() + "\n")
        }

        buttonMultiply.setOnClickListener {
            val input_txt = inputField.text.toString()
            result *= input_txt.toInt()
            resultField.append("* $input_txt\n")
            inputField.text.clear()
            resultField.append(result.toString() + "\n")
        }

        buttonDivide.setOnClickListener {
            val input_txt = inputField.text.toString()
            if (input_txt.toInt() == 0) {
                resultField.append("Cannot divide by zero\n")
                return@setOnClickListener
            }
            result /= input_txt.toInt()
            resultField.append("/ $input_txt\n")
            inputField.text.clear()
            resultField.append(result.toString() + "\n")
        }

        buttonEquals.setOnClickListener {
            resultField.append(result.toString() + "\n")
        }
        resultField.append(result.toString() + "\n")
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}