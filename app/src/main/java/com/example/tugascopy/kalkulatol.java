package com.example.tugascopy;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class kalkulatol extends AppCompatActivity {
    private EditText operand1EditText, operand2EditText;
    private Spinner operatorSpinner;
    private Button calculateButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulatol);

        operand1EditText = findViewById(R.id.operand1EditText);
        operand2EditText = findViewById(R.id.operand2EditText);
        operatorSpinner = findViewById(R.id.operatorSpinner);
        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);


        String[] operatorsArray = getResources().getStringArray(R.array.operators_array);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, operatorsArray);


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        operatorSpinner.setAdapter(adapter);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateResult();
            }
        });
    }

    private void calculateResult() {

        String input1 = operand1EditText.getText().toString();
        String input2 = operand2EditText.getText().toString();


        String selectedOperator = operatorSpinner.getSelectedItem().toString();


        if (input1.isEmpty() || input2.isEmpty()) {
            Toast.makeText(this, "Input tidak boleh kosong", Toast.LENGTH_SHORT).show();
            return;
        }


        double number1 = Double.parseDouble(input1);
        double number2 = Double.parseDouble(input2);


        double result = 0;

        switch (selectedOperator) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":

                if (number2 != 0) {
                    result = number1 / number2;
                } else {
                    Toast.makeText(this, "Pembagi tidak boleh nol", Toast.LENGTH_SHORT).show();
                    return;
                }
                break;
        }


        resultTextView.setText("Hasil: " + result);
    }
}
