package com.example.ejercicionumerom08;

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

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

       Random random = new Random();

        int numero = random.nextInt(5);

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);
        TextView textView = findViewById(R.id.textView);

        // Configurar el evento del botón
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Obtener el texto desde el EditText
                String textoIngresado = editText.getText().toString();

                if (Integer.parseInt(textoIngresado) == numero){
                    Toast.makeText(getApplicationContext(), "MAQUINA!!", Toast.LENGTH_SHORT).show();
                    textView.setText("Has acertado, es el numero " + String.valueOf(numero) +  "!!");
                }
                else if (Integer.parseInt(textoIngresado) > numero) {
                    textView.setText(textView.getText().toString() + "\n" + textoIngresado + " es mas grande que el numero secreto");
                }else {
                    textView.setText(textView.getText().toString() + "\n" + textoIngresado + " es mas pequeño que el numero secreto");
                }
            }
        });
    }
}