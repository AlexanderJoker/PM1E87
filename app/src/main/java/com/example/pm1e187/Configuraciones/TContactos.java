package com.example.pm1e187.Configuraciones;

public class TContactos {
    public static final String NameDatabase = "contactos.db";
    /*Tablas de Base de Datos*/
    public static final String tablaContactos = "contactos";

    /*Campos de la tabla personas*/
    public static final String id="id";
    public static final String nombres="nombres";
    public static final String pais="pais";
    public static final String telefono="telefono";
    public static final String nota="nota";

    /* Transacciones DDL tabla personas*/
    public static final String CreateTableContactos = "CREATE TABLE contactos (id INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "pais TEXT, nombres TEXT, telefono INTEGER , nota TEXT)";

    public static final String DROPTABLEContactos ="DROP TABLE IF EXISTS contactos";

}