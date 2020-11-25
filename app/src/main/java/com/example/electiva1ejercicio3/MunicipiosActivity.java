package com.example.electiva1ejercicio3;

import android.app.ListActivity;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


public class MunicipiosActivity extends ListActivity {

    String[] ListMunicipios;
    int IdDepartamentoActual = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_municipios);
        Intent intentNew = getIntent();

        String Departamento = intentNew.getStringExtra("Departamento");
        IdDepartamentoActual = intentNew.getIntExtra("IdDepartamento",0);

        if ( Departamento != null)
        {
            ArrayAdapter<String> Departamentos;

            int search =  getResources().getIdentifier(Departamento , "array",
                    getPackageName());

            Toast.makeText(this, String.valueOf(search), Toast.LENGTH_SHORT).show();

            ListMunicipios = getResources().getStringArray(search);

            ArrayAdapter<String> lista;
            lista = new ArrayAdapter<String>(this,R.layout.activity_municipios,R.id.TXTMuni,ListMunicipios);
            setListAdapter(lista);
        }else
            {
                Toast.makeText(this, "Hubo un error seleccione uno nuevo", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, DepartamentActivity.class);
                startActivity(intent);
            }
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String Seleccion = ListMunicipios[position].toString();

        if (Seleccion != "")
        {
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra("Municipio", Seleccion);
            intent.putExtra("IdDepartamento", IdDepartamentoActual);
            startActivity(intent);
        }
    }
}
