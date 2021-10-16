package com.example.pm1e187.tablas;

public class Ocontactos {
    private int id;
    private String nombre;
    private String pais;
    private int telefono;
    private String nota;
    public Ocontactos(int id, String nombre, String pais, int telefono,String nota)
    {
    this.id=id;
    this.nombre=nombre;
    this.pais=pais;
    this.telefono=telefono;
    this.nota=nota;
    }
    public Ocontactos(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
}
