package com.example.pm1e187;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pm1e187.Configuraciones.SQLiteConexion;
import com.example.pm1e187.Configuraciones.TContactos;
import com.example.pm1e187.Configuraciones.TPaises;

public class ingresapais extends AppCompatActivity {
    SQLiteConexion conexion;
    EditText nombrepais,codigopais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresapais);
        Button insertarpais=(Button) findViewById(R.id.btningresopais);
        insertarpais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombrepais=(EditText) findViewById(R.id.txtnombrepa);
                codigopais=(EditText) findViewById((R.id.txtcodipa));

                if(!nombrepais.getText().toString().isEmpty() && !codigopais.getText().toString().isEmpty())
                {
                    Agregarpais();
                }
                else{
                    Mensaje();
                }
            }
        });


    }
    public void Mensaje(){
        mensajero mensaje=new mensajero();
        mensaje.show(getSupportFragmentManager(),"Mensaje");
    }
    public void Agregarpais(){
        conexion=new SQLiteConexion(this, TPaises.NameDatabase, null, 1);
        SQLiteDatabase db=conexion.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(TPaises.nombrep, nombrepais.getText().toString());
        valores.put(TPaises.codigop, codigopais.getText().toString());

        Long resultado = db.insert(TPaises.tablaPaises,TPaises.idp, valores);
        Toast.makeText(getApplicationContext(),"Registro Ingresado : Codigo : " + resultado.toString(),Toast.LENGTH_LONG).show();

        db.close();
        limpiar();
    }
    void limpiar()
    {
        nombrepais.setText("");
        codigopais.setText("");
    }
}