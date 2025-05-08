package com.example.lab2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BT2 : AppCompatActivity() {
    private lateinit var editName: EditText
    private lateinit var editAge: EditText
    private lateinit var editHeight: EditText
    private lateinit var editWeight: EditText
    private lateinit var btnCalculate: Button
    private lateinit var btnClear: Button
    private lateinit var textResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bt2)

        editName = findViewById(R.id.editName)
        editAge = findViewById(R.id.editAge)
        editHeight = findViewById(R.id.editHeight)
        editWeight = findViewById(R.id.editWeight)
        btnCalculate = findViewById(R.id.btnCalculate)
        btnClear = findViewById(R.id.btnClear)
        textResult = findViewById(R.id.textResult)
        btnCalculate.setOnClickListener {
            calculateBMI()
        }
        btnClear.setOnClickListener {
            clearInputs()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun calculateBMI() {
        val name = editName.text.toString().trim()
        val age = editAge.text.toString().trim()
        val heightStr = editHeight.text.toString().trim()
        val weightStr = editWeight.text.toString().trim()
        if (name.isEmpty() || age.isEmpty() || heightStr.isEmpty() || weightStr.isEmpty()) {
            Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show()
            return
        }
        val height = heightStr.toDoubleOrNull()
        val weight = weightStr.toDoubleOrNull()
        if (height == null || height == 0.0 || weight == null) {
            Toast.makeText(this, "Invalid height or weight", Toast.LENGTH_SHORT).show()
            return
        }
        val bmi = weight / ((height / 100) * (height / 100))
        val category = when {
            bmi < 18.5 -> "You are underweight"
            bmi < 24.9 -> "You are normal weight"
            bmi < 29.9 -> "You are overweight"
            else -> "Warning! You are obesity!"
        }
        textResult.text = "Hello $name,\nYour BMI is %.2f (%s)".format(bmi, category)
    }
    private fun clearInputs() {
        editName.text.clear()
        editAge.text.clear()
        editHeight.text.clear()
        editWeight.text.clear()
        textResult.text = ""
    }
}