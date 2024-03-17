package jdmmark_c.flores_c.dominguez;

//Trabajo de Carlos Flores y Carlos Dominguez

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import static jdmmark_c.flores_c.dominguez.Auto.Compra;
import static jdmmark_c.flores_c.dominguez.Auto.Venta;
import static jdmmark_c.flores_c.dominguez.Especificaciones.addall;

public class JDMMARK_CFlores_CDominguez {

    static Random rand = new Random();
    static Scanner leer = new Scanner(System.in);
    static ArrayList <String> car = new ArrayList();
    static ArrayList <String> colores = new ArrayList();
    static ArrayList <String> condiciones = new ArrayList();
    static ArrayList <String> motores = new ArrayList();
    static ArrayList <String> turbos = new ArrayList();
    
    
    public static void main(String[] args) {
        addall(car,colores,motores,turbos);
        boolean var = true;
        int cash = 100000;
        Auto almacen [] = new Auto [50];//el limite del almacen son 50 autos
        for (int i = 0; i < 50; i++) {
            almacen = spawn_Autos(almacen);
        }
        Auto garage [] = new Auto [5];//el limite del almacen son 5 autos
        int x = rand.nextInt(5);
        String cars = car.get(0);
        int Precio = 150000;
        int HP = 205;
        int CaC = 7;
        int Vmax = 156;
        String Paint = "Rojo";
        String Motor = "V-tec";
        String Turbo = "No";
        String ECU = "Sin modificar";
        int Peso = 1500;               
        Auto nuevoAuto = new Auto(cars,Precio,HP,CaC,Vmax,Paint,Motor,Turbo,ECU,Peso);
        almacen[0] = nuevoAuto;
        System.out.println("Binevenido/a JDM Market");
        System.out.println("Somos una distribuidora de autos Japoneses y a su misma vez los compramos");
        System.out.println("Tambien nos encargamos de modificarlos si es que usted lo desea.");
        System.out.println("\nQue desea el dia de hoy?");
        do{
            System.out.println("Que desea hacer?");
            System.out.println("1) Comprar un vehiculo");
            System.out.println("2) Vender su vehiculo");
            System.out.println("3) Cambiar su vehiculo");//puede que consiga intercambiar su auto
            System.out.println("3) Informacion de algun vehiculo");//se le brinda informacion de un auto de JDM Market
            System.out.println("4) Informacion de su vehiculo");//podra ver los datos de su auto
            System.out.println("5) Probar un vehiculo");//pudra provar autos de JDM Market
            System.out.println("6) Probar su vehiculo");//podra correr con un auto de su propiedad y ganar otro auto
            
            int op = leer.nextInt();
            switch(op){
                
                case 1:{
                    Compra(almacen);
                    break;
                }//fin case1
                
                case 2:{
                    Venta(garage);
                    break;
                }//fin case2
                
                case 3:{
                    
                    break;
                }//fin case3
                
                case 4:{
                    
                    break;
                }//fin case4
                
                case 5:{
                    
                    break;
                }//fin case5
                
                default:{
                    System.out.println("opcion no valida");
                    break;
                }//fin default
                
            }//fin switch
            
        }while (var);//fin so while
        
    }//fin main
    
    public static Auto [] spawn_Autos(Auto almacen []){
        for (int i = 0; i < 50; i++) {
            if(almacen[i].getcars().isBlank()){
                String carro = car.get(rand.nextInt(4));
                String Paint = colores.get(rand.nextInt(6));
                String Motor = motores.get(rand.nextInt(4));
                String Turbo = turbos.get(rand.nextInt(2));
                int x = rand.nextInt(2);
                String ECU = "";
                if(x == 1){
                    ECU = "Original";
                }else if (x == 0) {
                    ECU = "Reconfigurada";
                }
                int HP = 0;
                double CaC = 10;
                int Vmax = 0;
                int Peso = rand.nextInt(2000-1000+1)+1000;
                int Precio = 0;
                if(carro.contains("NISSAN")){
                    Precio += 120000;
                    HP += 276;
                    CaC = CaC - 1.3;
                    Vmax += 155;
                }else if(carro.contains("MAZDA") || carro.contains("MITSUBISHI")){
                    Precio += 90000;
                    HP += 266;
                    CaC = CaC - 1.1;
                    Vmax += 142;
                }else{
                    Precio += 70000;
                    HP += 236;
                    CaC = CaC - 0.7;
                    Vmax += 153;
                }
                if(Motor.contains("3")){
                    Precio += 150000;
                    HP += 136;
                    CaC = CaC - 0.9;
                    Vmax += 50;
                }else if (Motor.contains("2")) {
                    Precio += 100000;
                    HP += 118;
                    CaC = CaC - 0.7;
                    Vmax += 39;
                }else{
                    Precio += 50000;
                    HP += 93;
                    CaC = CaC - 0.5;
                    Vmax += 25;
                }
                if(ECU.contains("Original")){
                    HP += 100;
                    CaC = CaC - 0.4;
                    Vmax += 0;
                }else if (x == 0) {
                    Precio += 52000;
                    HP += 235;
                    CaC = CaC - 1.6;
                    Vmax += 54;
                }
                if(turbos.contains("Twin")){
                    HP += 65;
                    Precio += 22000;
                    CaC = CaC - 1.9;
                    Vmax += 60;
                }else if (turbos.contains("geometria")) {
                    HP += 49;
                    Precio += 15000;
                    CaC = CaC - 1.6;
                    Vmax += 43;
                }else{
                    HP += 24;
                    Precio += 7000;
                    CaC = CaC - 1.0;
                    Vmax += 19;
                }
                Auto nuevoAuto = new Auto(carro,Precio,HP,CaC,Vmax,Paint,Motor,Turbo,ECU,Peso);
                almacen[i] = nuevoAuto;
            }
        }
        return almacen;
    }
    
    public static void Autos(Auto [] autos){
        System.out.println();
        for (int i = 0; i < autos.length; i++) {
            System.out.println(i+1+ ")" + autos[i]);
        }
    }//fin Autos
    
}//fin class JDMMARK_CFlores_CDominguez
