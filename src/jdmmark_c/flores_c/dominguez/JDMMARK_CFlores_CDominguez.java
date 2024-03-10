package jdmmark_c.flores_c.dominguez;

//Trabajo de Carlos Flores y Carlos Dominguez

import java.util.Scanner;
import java.util.Random;
import static jdmmark_c.flores_c.dominguez.Auto.Compra;
import static jdmmark_c.flores_c.dominguez.Auto.Venta;

public class JDMMARK_CFlores_CDominguez {

    static Random rand = new Random();
    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        boolean var = true;
        int cash = 100000;
        Auto almacen [] = new Auto [50];//el limite del almacen son 50 autos
        
        Auto garage [] = new Auto [5];//el limite del almacen son 5 autos
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
        for (int i = 0; i < 10; i++) {
            if(almacen[49].getModelo().isBlank()){
                int start = i;
                for (int j = 0; i < 49; i++) {
                    int x = rand.nextInt(5);
                    if(x == 0){
                        String Marca = "Honda";
                        String Modelo = "Civic";
                        int Precio = rand.nextInt(1000000-100000+1)+100000;
                        int HP = rand.nextInt(500-100+1)+100;
                        int CaC = rand.nextInt(10-4+1)+4;
                        int Vmax = rand.nextInt(200-150+1)+150;;
                        String Paint = "Rojo";
                        String Estado = "Usado";
                        String Motor = "2jz";
                        String Turbo = "No";
                        String ECU = "Sin modificar";
                        String Peso = rand.nextInt(2000-1000+1)+1000;
                    }else if(x == 1){
                        String Marca = "Honda";
                        String Modelo = "Civic";
                        int Precio = rand.nextInt(1000000-100000+1)+100000;
                        int HP = rand.nextInt(500-100+1)+100;
                        int CaC = rand.nextInt(10-4+1)+4;
                        int Vmax = rand.nextInt(200-150+1)+150;;
                        String Paint = "Rojo";
                        String Estado = "Usado";
                        String Motor = "2jz";
                        String Turbo = "No";
                        String ECU = "Sin modificar";
                        String Peso = rand.nextInt(2000-1000+1)+1000;
                    }else if(x == 2){
                        String Marca = "Honda";
                        String Modelo = "Civic";
                        int Precio = rand.nextInt(1000000-100000+1)+100000;
                        int HP = rand.nextInt(500-100+1)+100;
                        int CaC = rand.nextInt(10-4+1)+4;
                        int Vmax = rand.nextInt(200-150+1)+150;;
                        String Paint = "Rojo";
                        String Estado = "Usado";
                        String Motor = "2jz";
                        String Turbo = "No";
                        String ECU = "Sin modificar";
                        String Peso = rand.nextInt(2000-1000+1)+1000;
                    }else if(x == 3){
                        String Marca = "Honda";
                        String Modelo = "Civic";
                        int Precio = rand.nextInt(1000000-100000+1)+100000;
                        int HP = rand.nextInt(500-100+1)+100;
                        int CaC = rand.nextInt(10-4+1)+4;
                        int Vmax = rand.nextInt(200-150+1)+150;;
                        String Paint = "Rojo";
                        String Estado = "Usado";
                        String Motor = "2jz";
                        String Turbo = "No";
                        String ECU = "Sin modificar";
                        String Peso = rand.nextInt(2000-1000+1)+1000;
                    }else if(x == 4){
                        String Marca = "Honda";
                        String Modelo = "Civic";
                        int Precio = rand.nextInt(1000000-100000+1)+100000;
                        int HP = rand.nextInt(500-100+1)+100;
                        int CaC = rand.nextInt(10-4+1)+4;
                        int Vmax = rand.nextInt(200-150+1)+150;;
                        String Paint = "Rojo";
                        String Estado = "Usado";
                        String Motor = "2jz";
                        String Turbo = "No";
                        String ECU = "Sin modificar";
                        int Peso = rand.nextInt(2000-1000+1)+1000;
                    }
                    Auto nuevoAuto = new Auto(Marca,Modelo,Precio,HP,CaC,Vmax,col,Estado,Motor,Turbo,ECU,Peso);
                    almacen[i] = nuevoAuto;
                }
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
