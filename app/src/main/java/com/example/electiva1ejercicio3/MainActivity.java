 

package com.example.electiva1ejercicio3;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    EditText txtUsername, txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Hacemos referencias a los edittext del layout
        txtUsername = (EditText) findViewById(R.id.txtusername);
        txtPassword = (EditText) findViewById(R.id.txtpassword);
    }

    // Metodo encargado de redireccionar a ActivityDepartamentos
    public void Redireccion(View view)
    {
        String Username =txtUsername.getText().toString();
        String Password =txtPassword.getText().toString();

        if (ValidatePassword(Username,Password))
        {
            Intent intent = new Intent(this, DepartamentActivity.class);
            startActivity(intent);
        }
    }

    //Metodo encargado de validar usuario y contraseña con los datos del XML
    public boolean ValidatePassword(String Username,String Password)
    {
        boolean Result = false;

        if (!isNullOrBlank(Username) && !isNullOrBlank(Password))
        {
            if (RecorrerData(Username,Password))
            {
                Result = true;

            }else
                {
                    Toast.makeText(this, "Usuario o contraseña son incorrectas", Toast.LENGTH_LONG).show();
                }
        }else
        {
            Toast.makeText(this, "Usuario o contraseña estan vacios", Toast.LENGTH_LONG).show();
        }
        return  Result;
    }

    //Este metodo recorrer los usuarios en el XML
    public boolean RecorrerData(String Username,String Password) {
        Boolean Resultado = false;
        String[] ListaUsuarios,ListaPassword;
        ListaUsuarios = getResources().getStringArray(R.array.usuarios);
        ListaPassword = getResources().getStringArray(R.array.claves);

        for(int i = 0; i <= ListaUsuarios.length - 1; i = i + 1)
        {
            if (ListaUsuarios[i].toString().equals(Username)){
                if (ListaPassword[i].toString().equals(Password))
                {
                    Resultado= true;
                    break;
                }
            }
        }

        return Resultado;
    }

    public static boolean isNullOrBlank(String param) {
        return param == null || param.trim().length() == 0;
    }

    public void Exit(View view)
    {
        System.exit(0);
    }
}
