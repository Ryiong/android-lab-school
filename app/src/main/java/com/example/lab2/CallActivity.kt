package com.example.lab2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CallActivity : AppCompatActivity() {
    private lateinit var phoneField: EditText
    private lateinit var callBtn: Button
    private lateinit var backBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_call)

        phoneField = findViewById(R.id.phoneField)
        callBtn = findViewById(R.id.callBtn)
        backBtn = findViewById(R.id.backBtn)

        callBtn.setOnClickListener {
            call()
        }

        backBtn.setOnClickListener {
            finish()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun call() {
        val number = phoneField.text.toString()
        if (number.isNotBlank()) {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$number")
            startActivity(intent)
        } else {
            Toast.makeText(this, "Invalid number", Toast.LENGTH_SHORT).show()
        }
    }
}