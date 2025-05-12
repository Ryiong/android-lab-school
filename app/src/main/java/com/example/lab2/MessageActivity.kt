package com.example.lab2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MessageActivity : AppCompatActivity() {
    private lateinit var phoneField: EditText
    private lateinit var messageField: EditText
    private lateinit var sendBtn: Button
    private lateinit var backBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_message)

        phoneField = findViewById(R.id.phoneField)
        messageField = findViewById(R.id.messageField)
        sendBtn = findViewById(R.id.sendBtn)
        backBtn = findViewById(R.id.backBtn)

        sendBtn.setOnClickListener {
            send()
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

    private fun send() {
        val number = phoneField.text.toString()
        val message = messageField.text.toString()
        if (number.isNotBlank() && message.isNotBlank()) {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("smsto:$number")
            intent.putExtra("sms_body", message)
            startActivity(intent)
        }
    }
}