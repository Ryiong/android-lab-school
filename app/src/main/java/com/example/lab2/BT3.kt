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
import java.util.Calendar

class BT3 : AppCompatActivity() {
    private lateinit var editName: EditText
    private lateinit var editYearofBirth: EditText
    private lateinit var editHeight: EditText
    private lateinit var editWeight: EditText
    private lateinit var btnCalculate: Button
    private lateinit var btnClear: Button
    private lateinit var textResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bt3)

        editName = findViewById(R.id.editName)
        editYearofBirth = findViewById(R.id.editYearofBirth)
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
        val heightStr = editHeight.text.toString().trim()
        val weightStr = editWeight.text.toString().trim()
        val yearOfBirth = editYearofBirth.text.toString().trim()
        if (name.isEmpty() || yearOfBirth.isEmpty() || heightStr.isEmpty() || weightStr.isEmpty()) {
            Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show()
            return
        }
        val height = heightStr.toDoubleOrNull()
        val weight = weightStr.toDoubleOrNull()
        if (height == null || height == 0.0 || weight == null) {
            Toast.makeText(this, "Invalid height or weight", Toast.LENGTH_SHORT).show()
            return
        }
        val currentYear: Int = Calendar.getInstance().get(Calendar.YEAR)
        val age: Int = currentYear - yearOfBirth.toInt()
        val bmi = weight / ((height / 100) * (height / 100))

        val bmiStatus = if (bmi < 18.5) {
            "Gầy"
        } else if (bmi < 25) {
            "Bình thường"
        } else if (bmi < 30) {
            "Thừa cân"
        } else if (bmi < 35) {
            "Béo phì độ I"
        } else if (bmi < 40) {
            "Béo phì độ II"
        } else {
            "Béo phì độ III"
        }

        val result = """
            Tên: $name
            Tuổi: $age
            BMI: ${String.format("%.2f", bmi)}
            Phân loại: $bmiStatus
            """.trimIndent()

        textResult.setText(result);
    }
    private fun clearInputs() {
        editName.text.clear()
        editYearofBirth.text.clear()
        editHeight.text.clear()
        editWeight.text.clear()
        textResult.text = ""
    }
}