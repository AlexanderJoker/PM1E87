package com.example.pm1e187.Configuraciones;

public class TPaises {
    public static final String NameDatabase = "paises.db";
    /*Tablas de Base de Datos*/
    public static final String tablaPaises = "paises";

    /*Campos de la tabla personas*/
    public static final String idp="idp";
    public static final String nombrep="nombrep";
    public static final String codigop="codigop";

    /* Transacciones DDL tabla personas*/
    public static final String CreateTablePaises = "CREATE TABLE paises (idp INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "nombrep TEXT, codigop INTEGER)";

    public static final String DROPTABLEPaises ="DROP TABLE IF EXISTS paises";

}
