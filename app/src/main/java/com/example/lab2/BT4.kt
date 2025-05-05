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

class BT4 : AppCompatActivity() {
    private lateinit var editDay: EditText
    private lateinit var editMonth: EditText
    private lateinit var editYear: EditText
    private lateinit var btnConvert: Button
    private lateinit var btnClear: Button
    private lateinit var textResult: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bt4)
        editDay = findViewById(R.id.editDay)
        editMonth = findViewById(R.id.editMonth)
        editYear = findViewById(R.id.editYear)
        btnConvert = findViewById(R.id.btnConvert)
        btnClear = findViewById(R.id.btnClear)
        textResult = findViewById(R.id.textResult)

        btnConvert.setOnClickListener {
            convertDate()
        }

        btnClear.setOnClickListener {
            clearInput()
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    public fun convertDate() {
        val dayStr = editDay.text.toString().trim()
        val monthStr = editMonth.text.toString().trim()
        val yearStr = editYear.text.toString().trim()

        if (dayStr.isEmpty() || monthStr.isEmpty() || yearStr.isEmpty()) {
            Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show()
            return
        }

        val day = dayStr.toIntOrNull()
        val month = monthStr.toIntOrNull()
        val year = yearStr.toIntOrNull()

        if (day == null || day < 1 || day > 31) {
            Toast.makeText(this, "Invalid day", Toast.LENGTH_SHORT).show()
            return
        }

        if (month == null || month < 1 || month > 12) {
            Toast.makeText(this, "Invalid month", Toast.LENGTH_SHORT).show()
            return
        }

        if (year == null || year < 1) {
            Toast.makeText(this, "Invalid year", Toast.LENGTH_SHORT).show()
            return
        }

        val can = when (year % 10) {
            0 -> "Canh"
            1 -> "Tân"
            2 -> "Nhâm"
            3 -> "Quý"
            4 -> "Giáp"
            5 -> "Ất"
            6 -> "Bính"
            7 -> "Đinh"
            8 -> "Mậu"
            9 -> "Kỷ"
            else -> ""
        }

        val chi = when (year % 12) {
            0 -> "Thân"
            1 -> "Dậu"
            2 -> "Tuất"
            3 -> "Hợi"
            4 -> "Tý"
            5 -> "Sửu"
            6 -> "Dần"
            7 -> "Mão"
            8 -> "Thìn"
            9 -> "Tỵ"
            10 -> "Ngọ"
            11 -> "Mùi"
            else -> ""
        }

        textResult.text = "Lunar Date: $day/$month/$can $chi"
    }

    public fun clearInput() {
        editDay.text.clear()
        editMonth.text.clear()
        editYear.text.clear()
        textResult.text = ""
    }
}