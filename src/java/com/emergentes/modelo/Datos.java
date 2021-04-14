package com.emergentes.modelo;

public class Datos {
    private int id;
    private String nombre;
    private double peso;
    private double talla;
    private String vacunado;
    
    public Datos(){
        id = 0;
        nombre = "";
        peso = 0;
        talla = 0;
        vacunado = "";
    }
    public Datos(int id, String nombre, double peso, double talla, String vacunado){
        this.id = id;
        this.nombre = nombre;
        this.peso = peso;
        this.talla = talla;
        this.vacunado = vacunado;
    }

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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getTalla() {
        return talla;
    }

    public void setTalla(double talla) {
        this.talla = talla;
    }

    public String getVacunado() {
        return vacunado;
    }

    public void setVacunado(String vacunado) {
        this.vacunado = vacunado;
    }
    
    
}
