package com.example.pm1e187;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pm1e187.Configuraciones.SQLiteConexion;
import com.example.pm1e187.Configuraciones.TContactos;
import com.example.pm1e187.Configuraciones.TPaises;
import com.example.pm1e187.tablas.Opaises;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
SQLiteConexion conexion;
    Spinner combopaises;
    EditText nombre,nota,telefono;
String palabra;
    ArrayList<String> listapaises;
    ArrayList<Opaises>lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        combopaises=(Spinner) findViewById(R.id.combopa);
        Button insertar=(Button) findViewById(R.id.btnagregar);
        Button mostrar=(Button) findViewById(R.id.btnactualizar);
        Button agregarpa=(Button) findViewById(R.id.btnpais);
        /*Evento de seleccion de un evento del combo*/
        combopaises.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                try {
              palabra=combopaises.getSelectedItem().toString();

                } catch (Exception ex)
                {
                    ex.toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        agregarpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pantalla=new Intent(getApplicationContext(),ingresapais.class);
                startActivity(pantalla);
            }
        });

        insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             nombre=(EditText) findViewById(R.id.txtnombre1);
             nota=(EditText) findViewById((R.id.txtnota1));
             telefono=(EditText) findViewById((R.id.txttelefono1));

                if(!nombre.getText().toString().isEmpty() && !nota.getText().toString().isEmpty() && !telefono.getText().toString().isEmpty()){
                     if(telefono.getText().length()<8)
                     {
                         Toast.makeText(getApplicationContext(),"El numero debe ser mayor a 8 digitos ",Toast.LENGTH_LONG).show();
                     }

                     else{
                         Agregarcontacto();
                     }
                }
                else{
Mensaje();
                }
            }
        });

        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pantalla=new Intent(getApplicationContext(),activitycontactossalvados.class);
                startActivity(pantalla);
            }
        });
    }
    public void Mensaje(){
mensajero mensaje=new mensajero();
mensaje.show(getSupportFragmentManager(),"Mensaje");
    }
    public void Agregarcontacto(){
conexion=new SQLiteConexion(this, TContactos.NameDatabase, null, 1);
        SQLiteDatabase db=conexion.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(TContactos.pais, palabra);
        valores.put(TContactos.nombres, nombre.getText().toString());
        valores.put(TContactos.telefono, telefono.getText().toString());
        valores.put(TContactos.nota, nota.getText().toString());

        Long resultado = db.insert(TContactos.tablaContactos,TContactos.id, valores);
        Toast.makeText(getApplicationContext(),"Registro Ingresado : Codigo : " + resultado.toString(),Toast.LENGTH_LONG).show();

        db.close();
    limpiar();
    }
    void limpiar(){
        nombre.setText("");
        telefono.setText("");
        nota.setText("");
    }
}
