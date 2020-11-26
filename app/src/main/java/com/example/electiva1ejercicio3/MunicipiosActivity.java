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

        // Obtenemos parametros recibidos de la vista anterior
        Intent intentNew = getIntent();

        // Obtenemos paramtros ID departamento y nombre de departamento
        String Departamento = intentNew.getStringExtra("Departamento");
        IdDepartamentoActual = intentNew.getIntExtra("IdDepartamento",0);

        //Validamos que el nombre del departamento no venga null
        if ( Departamento != null)
        {
            ArrayAdapter<String> Departamentos;

            //Buscamos de forma dinamica el Id del departamento en el XML Resources
            int search =  getResources().getIdentifier(Departamento , "array",
                    getPackageName());
            // Obtenemos el array del XML de los municipios
            ListMunicipios = getResources().getStringArray(search);
            //Creamos un nuevo adaptar y le inyectamos el array obtenidos del XML
            ArrayAdapter<String> lista;
            lista = new ArrayAdapter<String>(this,R.layout.activity_municipios,R.id.TXTMuni,ListMunicipios);
            setListAdapter(lista);
        }else
            {
                //Si viene vacio el nombre del departamento entonces redirigimos una vista atras
                Toast.makeText(this, "Hubo un error seleccione uno nuevo", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, DepartamentActivity.class);
                startActivity(intent);
            }
    }

    // Cuando el usuario seleccione un municipio entonces redirigimos a el Activity Detalles y enviamos las 2 opciones
    // Seleccionadas por el usuario
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
