package com.example.electiva1ejercicio3;

import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class DetailsActivity extends AppCompatActivity {

    TextView TextDepa, TextMuni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextDepa = (TextView) findViewById(R.id.txtDepa);
        TextMuni = (TextView) findViewById(R.id.txtMuni);

        Intent intentNew = getIntent();

        if (intentNew != null){
        String Municipio = intentNew.getStringExtra("Municipio");
        int IdDepartamentoActual = intentNew.getIntExtra("IdDepartamento",0);

        String[] Listdepartamentos = getResources().getStringArray(R.array.departamentos);

        TextDepa.setText("Departamento: "+Listdepartamentos[IdDepartamentoActual].toString());
            TextMuni.setText("Municipio: "+Municipio);
        }else
        {
            Toast.makeText(this, "Intente con un nuevo departamento", Toast.LENGTH_SHORT).show();

        }
    }
}
