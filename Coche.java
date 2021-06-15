/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1ut05;

/**
 * Esta clase hereda de VehiculoPersona
 * @author irene
 */
public class Coche extends VehiculoPersona{
    
    //atributos heredados

    //constante
    private final static double CANTIDAD_EXTRA = 1.5; //por ser un tipo de vehiculo de personas
    
    //constructor
    public Coche(String matricula, int plazas) { 
        super(matricula, plazas); 
    }
    
    //método que devuelve el precio de alquiler de un coche, se obtiene el 
    //precio base de un vehículo y se le suma la cantidad extra (por ser un
    //vehiculo que transporta personas) por cada plaza y día.
    @Override
    public double precioTotal(){
        double precioTotal = super.getPRECIO_BASE();
        precioTotal += (Coche.CANTIDAD_EXTRA*super.getPlazas()*super.getDias());
        return precioTotal;
    }
    
    //método toString que devuelve la información de vehículo, vehiculo de personas
    //y las características propias de un coche
    @Override
    public String toString(){
        String info = super.toString();
        info += "\n\tTipo: Coche\n\tPrecio alquiler: " + this.precioTotal() + " euros\n";
        return info;    
    }
    
    /*public static void main(String[] args) {
        Coche c1 = new Coche("gpl2345",3);
        System.out.println(c1.getDias());
        System.out.println(c1.getPlazas());
        System.out.println(c1.getMatricula());
        
        c1.setDias(4);
        System.out.println(c1.getDias());
        
        System.out.println(c1.precioTotal());
        
        System.out.println(c1.toString());
          
    }*/
    
    
}
