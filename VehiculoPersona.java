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
public abstract class VehiculoPersona extends Vehiculo{
    
    //constructor
    public VehiculoPersona(String matricula, int plazas){
        super(matricula, plazas);
    }
        
    //metodo abstracto que se redefinirá más adelante
    @Override
    public abstract double precioTotal();
    
    //método toString que devuelve la información de vehículo y vehiculo de personas
    @Override
    public String toString(){
        String info = super.toString();
        info += "\n\tServicio: Transporte de personas";
        return info;    
    }
}
