package com.example.tugascopy;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnMasuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       btnMasuk = findViewById(R.id.btnMasuk);


       btnMasuk.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent Masuk = new Intent(MainActivity.this, kalkulatol.class);
               startActivity(Masuk);
           }

       });
    }
}