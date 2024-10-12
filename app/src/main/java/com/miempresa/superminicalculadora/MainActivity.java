package com.miempresa.superminicalculadora;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText nmr1, nmr2;
    private TextView txtResultado;
    private Button btnSumar, btnRestar, btnMultiplicar, btnDividir, btnBorrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializamos las vistas
        nmr1 = findViewById(R.id.nmr1);
        nmr2 = findViewById(R.id.nmr2);
        txtResultado = findViewById(R.id.txtResultado);
        btnSumar = findViewById(R.id.btnSumar);
        btnRestar = findViewById(R.id.btnRestar);
        btnMultiplicar = findViewById(R.id.btnMultiplicar);
        btnDividir = findViewById(R.id.btnDividir);
        btnBorrar = findViewById(R.id.btnBorrar);

        // Configuramos los eventos lambda para los botones
        btnSumar.setOnClickListener(v -> realizarOperacion("+"));
        btnRestar.setOnClickListener(v -> realizarOperacion("-"));
        btnMultiplicar.setOnClickListener(v -> realizarOperacion("*"));
        btnDividir.setOnClickListener(v -> realizarOperacion("/"));

        btnBorrar.setOnClickListener(v -> {
            nmr1.setText("");
            nmr2.setText("");
            txtResultado.setText("");
        });

    }
    private void realizarOperacion(String operacion) {
        String numero1str = nmr1.getText().toString();
        String numero2str = nmr2.getText().toString();

        if (numero1str.isEmpty() || numero2str.isEmpty()) {
            txtResultado.setText("Introduzca un número entero");
            return;
        }

        if(!numero1str.isEmpty()&!numero2str.isEmpty()){
            int numero1 = Integer.parseInt(numero1str);
            int numero2 = Integer.parseInt(numero2str);
            double resultado = 0;

            switch (operacion) {
                case "+":
                    resultado = numero1 + numero2;
                    break;
                case "-":
                    resultado = numero1 - numero2;
                    break;
                case "*":
                    resultado = numero1 * numero2;
                    break;
                case "/":
                    if (numero2 != 0) {
                        resultado = numero1 / numero2;
                    } else {
                        txtResultado.setText("Error: División por 0");
                        return;
                    }
                    break;
            }

            txtResultado.setText(String.valueOf(resultado));
        } else {
            txtResultado.setText("Por favor, ingrese ambos números");
        }
    }
}