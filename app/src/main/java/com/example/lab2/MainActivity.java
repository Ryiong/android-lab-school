package com.example.lab2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;

import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button btnGoToBT = findViewById(R.id.button);
        Button btnGoToBT2 = findViewById(R.id.button2);
        Button btnGoToBT3 = findViewById(R.id.button3);
        Button btnGoToBT4 = findViewById(R.id.button4);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnGoToBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtils.switchActivity(MainActivity.this, BT1.class);
            }
        });

        btnGoToBT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtils.switchActivity(MainActivity.this, BT2.class);
            }
        });

        btnGoToBT3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtils.switchActivity(MainActivity.this, BT3.class);
            }
        });

        btnGoToBT4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtils.switchActivity(MainActivity.this, BT4.class);
            }
        });
    }

}