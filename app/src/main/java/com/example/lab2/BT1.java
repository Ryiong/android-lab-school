package com.example.lab2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BT1 extends AppCompatActivity {

    Button btnCalculateBMI;
    EditText etHoTen, etChieuCao, etCanNang, etBMI, etChuanDoan;
    TextView tvLoiKhuyen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bt1);

        btnCalculateBMI = findViewById(R.id.btnCalculateBMI);
        etHoTen = findViewById(R.id.etHoTen);
        etChieuCao = findViewById(R.id.etChieuCao);
        etCanNang = findViewById(R.id.etCanNang);
        etBMI = findViewById(R.id.etBMI);
        etChuanDoan = findViewById(R.id.etChuanDoan);
        tvLoiKhuyen = findViewById(R.id.tvLoiKhuyen);
    }
    public void clearAllInputs(View view) {
        etHoTen.setText("");
        etChieuCao.setText("");
        etCanNang.setText("");
        etBMI.setText("");
        etChuanDoan.setText("");
        tvLoiKhuyen.setText("");
    }
    public void calculateBMI(View view) {
        if (etHoTen.getText().toString().isEmpty() ||
                etChieuCao.getText().toString().isEmpty()
                || etCanNang.getText().toString().isEmpty()) {
            Toast.makeText(this, "Xin mời nhập đủ thông tin!",
                    Toast.LENGTH_SHORT).show();
        } else {
            String hoTen = etHoTen.getText().toString().trim();
            float chieuCao =
                    Float.parseFloat(etChieuCao.getText().toString().trim());
            float canNang =
                    Float.parseFloat(etCanNang.getText().toString().trim());
            float bmi = canNang / (chieuCao * chieuCao);
            etBMI.setText(String.valueOf(bmi));
            String chuanDoan = "";
            String loiKhuyen = "Xin chào " + hoTen;
            if (bmi < 18){
                chuanDoan = "Người gầy.";
                loiKhuyen += "\n Bạn nên ăn nhiều thêm!";
            }
            else if (bmi < 24.9) {
                chuanDoan = "Người bình thường.";
                loiKhuyen += "\n Chỉ số BMI tốt, cố gắng duy trì!";
            }
            else if (bmi < 29.9) {
                chuanDoan = "Người béo phì độ 1.";
                loiKhuyen += "\n Bạn nên ăn giảm đi!";
            }
            else if (bmi < 34.9) {
                chuanDoan = "Người béo phì độ 2.";
                loiKhuyen += "\n Bạn nên ăn ít, tập thể dục nhiều!";
            }
            else {
                chuanDoan = "Người béo phì độ 3.";
                loiKhuyen += "\n Bạn nên nhịn ăn, chỉ tập thể dục thoi!";
            }
            chuanDoan = chuanDoan;
            etChuanDoan.setText(chuanDoan);
            tvLoiKhuyen.setText(loiKhuyen);
        }}
}