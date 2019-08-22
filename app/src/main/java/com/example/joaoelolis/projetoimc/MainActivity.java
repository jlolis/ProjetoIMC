package com.example.joaoelolis.projetoimc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    private EditText editTextPeso;
    private EditText editTextAltura;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPeso = findViewById(R.id.editTextPeso);
        editTextAltura = findViewById(R.id.editTextAltura);
        textView = findViewById(R.id.textView);

        textView.setText("");

    }

    public void calculoImc (View v){

        String peso = editTextPeso.getText().toString().replace(",", ".");
        String altura = editTextAltura.getText().toString().replace(",", ".");

        Double numPeso = Double.parseDouble(peso);
        Double numAltura = Double.parseDouble(altura);

        Double altura2 = numAltura * 2;
        Double IMC = numPeso / altura2;

        DecimalFormat df = new DecimalFormat("#.##");
        String resultFormatter = df.format(IMC);

        resultFormatter = resultFormatter.replace(".",",");

        if (IMC >18.5 && IMC <= 24.9){

            textView.setText(resultFormatter + " - Saudavel ");
        }
        else if (IMC >24.9 && IMC <= 30){

            textView.setText(resultFormatter + " - Acima do peso ");
        }
        else if (IMC > 30){

            textView.setText(resultFormatter + " - Obeso ");
        }
        else{
            textView.setText(resultFormatter + " - Abaixo do peso ");
        }
    }
}
