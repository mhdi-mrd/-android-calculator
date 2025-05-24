package com.example.myapplication; 

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText number1, number2;
    Button btnAdd, btnSubtract, btnMultiply, btnDivide;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        txtResult = findViewById(R.id.txtResult);

        btnAdd.setOnClickListener(v -> calculate("+"));
        btnSubtract.setOnClickListener(v -> calculate("-"));
        btnMultiply.setOnClickListener(v -> calculate("*"));
        btnDivide.setOnClickListener(v -> calculate("/"));
    }

    private void calculate(String operator) {
        String n1 = number1.getText().toString();
        String n2 = number2.getText().toString();

        if (n1.isEmpty() || n2.isEmpty()) {
            txtResult.setText("لطفاً دو عدد وارد کن.");
            return;
        }

        double a = Double.parseDouble(n1);
        double b = Double.parseDouble(n2);
        double result = 0;

        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if (b == 0) {
                    txtResult.setText("تقسیم بر صفر مجاز نیست!");
                    return;
                }
                result = a / b;
                break;
        }
        txtResult.setText("نتیجه: " + result);
    }
}
