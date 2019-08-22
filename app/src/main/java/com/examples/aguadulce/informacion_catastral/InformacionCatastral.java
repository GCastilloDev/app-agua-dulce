package com.examples.aguadulce.informacion_catastral;

public class InformacionCatastral {

    private String nombre;
    private String cuenta;
    private String domicilio;
    private int id;

    public InformacionCatastral(){}

    public InformacionCatastral(String nombre, String cuenta, String domicilio, int id) {
        this.nombre = nombre;
        this.cuenta = cuenta;
        this.domicilio = domicilio;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
