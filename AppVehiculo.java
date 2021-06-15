/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1ut05;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author irene
 */
public class AppVehiculo {
    
    //atributos
    //lista que contendrá vehículos
    ArrayList <Vehiculo> listaVehiculos;
    
    //constructor
    public AppVehiculo(){
        this.listaVehiculos = new ArrayList<>();
    }
    
    //GETTER Y SETTER
    //no he añadido GET para listaVehiculo ya que hay un método que devolverá
    //la información de los vehículos, y tampoco un SET porque hay otro método 
    //que introduce vehículos
    
    //MÉTODOS
    //este método pide al usuario que introduzca los datos de un vehículo para
    //añadirlos a la lista
    public void addVehiculo(){
        
        //atributos
        int tipo; //de vehículo que va a añadir
        
        //objeto scanner
        Scanner entrada = new Scanner(System.in);
        
        //bucle do-while que muestra un menú de vehiculos disponibles y el 
        //usuario tiene que elegir, el número escogido le llevará a un determinado
        //case de un switch
        do{
            System.out.println("Vehiculos disponibles: ");
            System.out.println("   1. Vehiculos de personas.");  
            System.out.println("   2. Vehiculos de carga.");
            System.out.println("   3. Atrás.");        
            System.out.println("¿Qué tipo de vehículo quiere añadir?");
            tipo = entrada.nextInt();

            switch(tipo){
                case 1: 
                    System.out.println("\n**** INSERTAR VEHÍCULO DE PERSONAS ****");
                    Vehiculo vp = createVehiculoPersona(); //crea un vehículo que transporta personas
                    this.listaVehiculos.add(vp); 
                    break;
                case 2: 
                    System.out.println("\n**** INSERTAR VEHÍCULO DE CARGA ****");
                    Vehiculo vc = createVehiculoCarga(); //crea un vehículo que transporta carga
                    this.listaVehiculos.add(vc); 
                    break;
                case 3:
                    System.out.println("Volver al menú."); 
                    break;
            }
        }while(tipo != 3);
    }
    
    //este métdo devolverá el precio de alquiler de un vehículo en concreto
    //introduciendo una matrícula y los días
    public double getPrecioAlquiler(String matricula, int dias){ 
        matricula = matricula.toUpperCase(); //transforma la matrícula en mayúsculas
        for(Vehiculo v: this.listaVehiculos){
            //este for se comprueba si la matrícula de un vehículo de la lista
            //coincide con la matrícula introducida por el ususario
            if(matricula.equals(v.getMatricula())){
                //si son iguales se introducirá los días al vehículo y devolverá
                //el precio de alquiler
                v.setDias(dias);
                return v.precioTotal(); 
            }else{
                //en el caso contrario dará error y devolverá 0
                System.out.println("ERROR!");
            }
        } 
        return 0;
    }
    
    //este métdo devolverá la información de una lista con los precios de 
    //alquiler de TODOS los vehiculos disponibles, se introduce los días
    public void getPrecioAlquiler(int dias){
        for(Vehiculo v: this.listaVehiculos){
            v.setDias(dias);
            System.out.println("\n    VEHÍCULO " + (this.listaVehiculos.indexOf(v) + 1) + ":");
            System.out.print(v.toString());
        }  
    }
    
    //método privado que utiliza el método público addVehiculo()
    //consiste en pedir al usuario que introduzca los datos de un vehículo
    //de personas y crear un objeto con esos datos, e introducirlos en el
    //ArrayList listaVehiculos
    private Vehiculo createVehiculoPersona(){
        
        //variables
        String matricula;
        int plazas;
        int tipoConcreto;
        
        //objeto scanner
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Escribe la matrícula: ");
        matricula = entrada.next();
        System.out.println("Escribe el número de plazas: ");
        plazas = entrada.nextInt();
        System.out.println("Concretamente: ");
        System.out.println("   1. Coche.");
        System.out.println("   2. Microbus.");
        System.out.println("¿Cuál prefiere?");
        tipoConcreto = entrada.nextInt();
        System.out.println();
        if(tipoConcreto == 1){
            return new Coche(matricula,plazas);
        }else if(tipoConcreto == 2){
            return new Microbus(matricula,plazas);
        }
        return null;
    }
    
    //método privado que utiliza el método público addVehiculo()
    //consiste en pedir al usuario que introduzca los datos de un vehículo
    //que transporta carga y crear un objeto con esos datos, e introducirlos en 
    //el ArrayList listaVehiculos
    private Vehiculo createVehiculoCarga(){
        
        //variables
        String matricula;
        int plazas;
        double peso;
        int tipoConcreto;
        
        //objeto scanner
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Escribe la matrícula: ");
        matricula = entrada.next();
        System.out.println("Escribe el número de plazas: ");
        plazas = entrada.nextInt();
        System.out.println("Escribe el Peso Máximo Autorizado en toneladas: ");
        peso = entrada.nextDouble();
        System.out.println("Concretamente: ");
        System.out.println("   1. Furgoneta.");
        System.out.println("   2. Camión.");
        System.out.println("¿Cuál prefiere?");
        tipoConcreto = entrada.nextInt();
        System.out.println();
        if(tipoConcreto == 1){
            return new Furgoneta(matricula,plazas,peso);
        }else if(tipoConcreto == 2){
            return new Camion(matricula,plazas,peso);
        }
        return null;
    }
    
    //método main
    public static void main(String[] args) {
        
        //variables
        String matricula;
        int dias;
        int opcion; //menu
        
        //objeto escaner
        Scanner entrada = new Scanner(System.in);
        //objeto aplicación
        AppVehiculo app = new AppVehiculo();
        
        do{
            System.out.println("\n========== MENÚ ==========");
            System.out.println("1. Añadir vehículos.");
            System.out.println("2. Obtener precio de alquiler de un vehículo.");
            System.out.println("3. Obtener una lista de precios de alquiler de todos los vehículos.");
            System.out.println("4. Salir.");
            
            System.out.println("Introduce opción: ");
            opcion = entrada.nextInt();
            
            switch(opcion){
                case 1: 
                    System.out.println("\n**** AÑADIR VEHÍCULO: ****");
                    app.addVehiculo(); 
                    break; //añadir vehículos
                case 2: 
                    System.out.println("\n**** OBTENER PRECIO DE ALQUILER: ****");
                    System.out.println("Introduce la matrícula: ");
                    matricula = entrada.next();
                    System.out.println("Introduce los días: ");
                    dias = entrada.nextInt();
                    app.getPrecioAlquiler(matricula, dias); 
                    break;
                case 3: 
                    System.out.println("\n**** OBTENER LISTA DE PRECIOS DE ALQUILER: ****");
                    System.out.println("Introduce los días: ");
                    dias = entrada.nextInt();
                    app.getPrecioAlquiler(dias); 
                    break;
                case 4:
                    System.out.println("Salir del programa.");
            }
  
        }while(opcion != 4);

    }
    
}
