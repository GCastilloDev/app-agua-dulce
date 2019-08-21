package com.examples.aguadulce.informacion_catastral;

public class InformacionCatastral {

    private String nombre;
    private String cuenta;
    private String domicilio;

    public InformacionCatastral(){}

    public InformacionCatastral(String nombre, String cuenta, String domicilio) {
        this.nombre = nombre;
        this.cuenta = cuenta;
        this.domicilio = domicilio;
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
}
