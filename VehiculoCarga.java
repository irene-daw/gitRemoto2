/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1ut05;

/**
 * Esta clase hereda de Vehículo
 * @author irene
 */
public abstract class VehiculoCarga extends Vehiculo{
    
    //atributos
    private double pma; //en toneladas
    
    //constructor
    public VehiculoCarga(String matricula, int plazas, double pma){
        super(matricula,plazas); 
        this.pma = pma;
    }
    
    //getter y setter
    public double getPma() {
        return pma;
    }

    public void setPma(double pma) {
        this.pma = pma;
    }
    
    //metodo abstracto que se redefinirá más adelante
    @Override
    public abstract double precioTotal();
    
    //método toString que devuelve la información de vehícul y vehiculo de carga
    @Override
    public String toString(){
        String info = super.toString();
        info += "\n\tServicio: Transporte de carga\n\tPeso máximo autorizado: " + this.pma + " toneladas";
        return info;    
    }
}
