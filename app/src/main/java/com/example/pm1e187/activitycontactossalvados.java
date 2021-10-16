package com.example.pm1e187;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pm1e187.Configuraciones.SQLiteConexion;
import com.example.pm1e187.Configuraciones.TContactos;
import com.example.pm1e187.tablas.Ocontactos;

import java.util.ArrayList;

public class activitycontactossalvados extends AppCompatActivity {
    SQLiteConexion conexion;
    ListView listapersonas;
    ArrayList<Ocontactos> lista;
    ArrayList<String> ArregloContactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactossalvados);

        Button eliminar=(Button) findViewById(R.id.btnborrar);
        Button llamar=(Button) findViewById(R.id.btnllamada);
        Button modificacion=(Button) findViewById(R.id.btnmodificar);

        //Llenar lista
        conexion=new SQLiteConexion(this, TContactos.NameDatabase, null, 1);
        listapersonas=(ListView) findViewById(R.id.listacontactos);

        ObtenerListaContactos();

        ArrayAdapter adp = new ArrayAdapter( this, android.R.layout.simple_list_item_1, ArregloContactos);
        listapersonas.setAdapter(adp);


        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        llamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
Intent callintent=new Intent(Intent.ACTION_CALL);
callintent.setData(Uri.parse("tel"+95117652));
startActivity(callintent);
            }
        });
        modificacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), actualizar.class);
                startActivity(intent);
            }
        });
    }
    private void ObtenerListaContactos()
    {
        SQLiteDatabase db= conexion.getReadableDatabase();
        Ocontactos list_contactos = null;
        lista = new ArrayList<Ocontactos>();

        //cursor de base de dats : nos apoya a recorrer la informacion de la tabla a la cual consultamos//

        Cursor cursor = db.rawQuery("SELECT * FROM " + TContactos.tablaContactos, null);

        //Recorremos la informacion del cursor

        while(cursor.moveToNext())
        {
            list_contactos=new Ocontactos();
            list_contactos.setId(cursor.getInt(0));
            list_contactos.setNombre(cursor.getString(1));
            list_contactos.setPais(cursor.getString(2));
            list_contactos.setTelefono(cursor.getInt(3));
            list_contactos.setNota(cursor.getString(4));

            lista.add(list_contactos);
        }

        cursor.close();

        filllist();

    }

    private void filllist()
    {
        ArregloContactos=new ArrayList<String>();
        ArregloContactos.add("Nombre" + " | "
                +"Telefono" +" | "+ "Pais" +" | "+"Nota");

        for (int i=0; i< lista.size(); i++)
        {
            ArregloContactos.add(lista.get(i).getNombre() + " | "
                    +lista.get(i).getTelefono()+" | " +lista.get(i).getPais()+" | "
                    +lista.get(i).getNota());
        }
    }
}