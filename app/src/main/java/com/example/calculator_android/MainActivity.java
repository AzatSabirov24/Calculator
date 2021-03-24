package com.example.calculator_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

   private CalculatorLogic calculator = new CalculatorLogic();
   private TextView text;
   private final String textKey = "textKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        text = findViewById(R.id.text);
        calculator = new CalculatorLogic();

        View.OnClickListener numberButtonClickListener = view -> {
            calculator.onNumPressed(view.getId());
            text.setText(calculator.getText());
        };

        View.OnClickListener actionButtonOnClickListener = view -> {
            calculator.onActionPressed(view.getId());
            text.setText(calculator.getText());
        };

        for (int i = 0; i < calculator.numbers.length; i++) {
            findViewById(calculator.numbers[i]).setOnClickListener(numberButtonClickListener);
        }

        for (int i = 0; i < calculator.numbers_action.length; i++) {
            findViewById(calculator.numbers_action[i]).setOnClickListener(actionButtonOnClickListener);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putSerializable(textKey, calculator);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        calculator = (CalculatorLogic)savedInstanceState.getSerializable("textKey");
        text.setText(calculator.getText());
    }
}