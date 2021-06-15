/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1ut05;

/**
 * Clase Vehículo que define lo qué es y cómo calcular el precio total (método abstracto)
 * @author irene
 * @version 1.0
 */
public abstract class Vehiculo {
    
    /**
     * Atributo que contiene la matrícula de un vehículo.
     */
    private final String matricula;
    /**
     * Atributo que contiene el número de plazas de un vehículo.
     */
    private int plazas;
    /**
     * Atributo que contiene los días de alquiler el vehículo.
     */
    private int dias;
    /**
     * Atributo constante que define el precio base de todos los vehículos.
     */
    private final static int PRECIO_BASE = 50; //50 euros/dia
    
    /**
     * Constructor de vehículo que recibe los siguientes parámetros. No se incluye
     * el atributo días ya que el usuario lo introducirá por teclado.
     * @param matricula
     * @param plazas 
     */
    public Vehiculo(String matricula, int plazas) { 
        this.matricula = matricula.toUpperCase();
        this.plazas = plazas;
    }
    
    //getter y setter
    public String getMatricula() {
        return this.matricula;
    }
    
    public int getPlazas() {
        return this.plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    public int getDias() {
        return this.dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }
    
    public int getPRECIO_BASE() {    
        return Vehiculo.PRECIO_BASE;
    }
    
    //método abstracto
    public abstract double precioTotal();
    
    //to string
    @Override
    public String toString(){
        String info = "\tMatrícula: " + this.matricula + "\n\tPlazas: " + this.plazas
                + "\n\tDías de alquiler: " + this.dias;
        return info;    
    }
}
