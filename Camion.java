/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1ut05;

/**
 * Esta clase hereda de VehiculoCarga
 * @author irene
 */
public class Camion extends VehiculoCarga{
    
    //atributos heredados

    //constante
    private final static int PLUS = 40; //por ser camión
    private final static int CANTIDAD_EXTRA = 20; //por ser de carga
    
    //constructor
    public Camion(String matricula, int plazas, double pma) { 
        super(matricula, plazas, pma); 
    }
     
    //método que devuelve el precio de alquiler de un camión, se obtiene el 
    //precio base de un vehículo y se le suma la cantidad extra (por ser un
    //vehiculo que transporta carga) por el peso máximo autorizado Y, además se le
    //suma un plus (por ser un camión) independientemente de la carga y los días
    //de alquiler.
    @Override
    public double precioTotal(){
        double precioTotal = super.getPRECIO_BASE();
        precioTotal += (Camion.CANTIDAD_EXTRA*super.getPma()) + Camion.PLUS;
        return precioTotal;
    }
    
    //método toString que devuelve la información de vehículo, vehiculo de carga
    //y las características propias de un camión
    @Override
    public String toString(){
        String info = super.toString();
        info += "\n\tTipo: Camión\n\tPrecio alquiler: " + this.precioTotal() + " euros\n";
        return info;    
    }

}
