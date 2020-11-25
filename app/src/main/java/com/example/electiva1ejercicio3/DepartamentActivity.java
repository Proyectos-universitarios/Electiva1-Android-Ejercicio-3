package com.example.electiva1ejercicio3;

import android.app.ListActivity;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class DepartamentActivity extends ListActivity {

    String[] Listdepartamentos;
   // TextView ListaVista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_departament);
        ArrayAdapter<String> Departamentos;
        //ListaVista = (TextView) findViewById(R.id.ListViewDepa);
        Listdepartamentos = getResources().getStringArray(R.array.departamentos);

        ArrayAdapter<String> lista;
        lista = new ArrayAdapter<String>(this,R.layout.activity_departament,R.id.TXTList,Listdepartamentos);
        setListAdapter(lista);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        //super.onListItemClick(l, v, position, id);

        String Seleccion =eliminarAcentos(Listdepartamentos[position].toString().toLowerCase().trim().replace(" ","")) ;

        Toast.makeText(this, Seleccion, Toast.LENGTH_LONG).show();

        if (Seleccion != "")
        {
            Intent intent = new Intent(this, MunicipiosActivity.class);
            intent.putExtra("Departamento", Seleccion);
            intent.putExtra("IdDepartamento", position);
            startActivity(intent);
        }
    }

    public static String eliminarAcentos(String str) {

        final String ORIGINAL = "ÁáÉéÍíÓóÚúÑñÜü";
        final String REEMPLAZO = "AaEeIiOoUuNnUu";

        if (str == null) {
            return null;
        }
        char[] array = str.toCharArray();
        for (int indice = 0; indice < array.length; indice++) {
            int pos = ORIGINAL.indexOf(array[indice]);
            if (pos > -1) {
                array[indice] = REEMPLAZO.charAt(pos);
            }
        }
        return new String(array);
    }

}
