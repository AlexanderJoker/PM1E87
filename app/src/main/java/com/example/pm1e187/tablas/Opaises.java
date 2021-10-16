package com.example.pm1e187.tablas;

public class Opaises {
    private int idp;
    private String nombrep;
    private int codigop;
    public Opaises(int idp,String nombrep,int codigop){
        this.idp=idp;
        this.nombrep=nombrep;
        this.codigop=codigop;
    }
    public Opaises(){}

    public int getIdp() {
        return idp;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    public String getNombrep() {
        return nombrep;
    }

    public void setNombrep(String nombrep) {
        this.nombrep = nombrep;
    }

    public int getCodigop() {
        return codigop;
    }

    public void setCodigop(int codigop) {
        this.codigop = codigop;
    }
}
