 

package com.example.electiva1ejercicio3;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void Redireccion(View view)
    {
        Intent intent = new Intent(this, DepartamentActivity.class);
        startActivity(intent);
    }
}
