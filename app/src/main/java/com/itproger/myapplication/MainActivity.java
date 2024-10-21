package com.itproger.myapplication;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText inpA;
    EditText inpB;
    EditText inpC;
    TextView txtRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        inpA = findViewById(R.id.inpA);
        inpB = findViewById(R.id.inpB);
        inpC = findViewById(R.id.inpC);
        txtRes = findViewById(R.id.txtRes);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void proverka(View v) {
        try {
            int a = Integer.parseInt(inpA.getText().toString());
            int b = Integer.parseInt(inpB.getText().toString());
            int c = Integer.parseInt(inpC.getText().toString());

            if (a <= 0 || b <= 0 || c <= 0 || a + b <= c || a + c <= b || b + c <= a) {
                txtRes.setText("Это не треугольник");
            } else if (a == b && b == c) {
                txtRes.setText("Треугольник: равносторонний");
            } else if (a == b || b == c || c == a) {
                txtRes.setText("Треугольник: равнобедренный");
            } else {
                txtRes.setText("Треугольник: разносторонний");
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Введите только числовые значения для сторон", Toast.LENGTH_SHORT).show();
        }
    }
}
