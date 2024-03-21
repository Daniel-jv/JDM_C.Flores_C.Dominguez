package jdmmark_c.flores_c.dominguez;

//Trabajo de Carlos Flores y Carlos Dominguez

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import static jdmmark_c.flores_c.dominguez.Auto.Compra;
import static jdmmark_c.flores_c.dominguez.Auto.Venta;
import static jdmmark_c.flores_c.dominguez.Especificaciones.addall;
import static jdmmark_c.flores_c.dominguez.Especificaciones.listaautos;

public class JDMMARK_CFlores_CDominguez {

    static Random rand = new Random();
    static Scanner leer = new Scanner(System.in);
    static ArrayList <String> car = new ArrayList();
    static ArrayList <String> colores = new ArrayList();
    static ArrayList <String> condiciones = new ArrayList();
    static ArrayList <String> motores = new ArrayList();
    static ArrayList <String> turbos = new ArrayList();
    static int cash = 100000;
    
    
    public static void main(String[] args) {
        addall(car,colores,motores,turbos);
        boolean var = true;
        Auto almacen [] = new Auto [50];
        for (int i = 0; i < 50; i++) {
            espacio(almacen,i);
        }
        almacen = spawn_Autos(almacen);
        Auto garage [] = new Auto [5];//el limite del almacen son 5 autos
        garage = spawn_Garage(garage);
        int seleccion = 0;
        Auto autoprinc = garage[seleccion];
        seleccion = 0;
        System.out.println("Binevenido/a JDM Market");
        System.out.println("Somos una distribuidora de autos Japoneses y a su misma vez los compramos");
        System.out.println("Tambien nos encargamos de modificarlos si es que usted lo desea.");
        System.out.println("\nQue desea el dia de hoy?");
        do{
            System.out.println("Que desea hacer?");
            System.out.println("1) Comprar un vehiculo");
            System.out.println("2) Vender su vehiculo");
            System.out.println("3) Vehiculos en el garage");//se le brinda informacion de los vehiculos en su garage
            System.out.println("4) Carreras nocturnas");
            System.out.println("5) Seleccionar auto");
            System.out.println("6) Mejorar auto");
            System.out.println("7) Trabajar ;(");//se quedo sin fondos, hay que recuperarlos
            System.out.println("8) Salir");
            System.out.println("Dinero: "+cash+"$");
            System.out.println("Auto principal: "+ autoprinc.getcars()+" "+autoprinc.getPaint());
            System.out.print("Ingrese una opcion: ");
            int op = leer.nextInt();
            System.out.println("\n");
            switch(op){
                
                case 1:{
                    System.out.println("---Comprar un vehiculo");
                    int check = 0;
                    for (int i = 0; i < 5; i++) {
                        if(!garage[i].getcars().isBlank()){
                            check++;
                        }
                    }
                    Compra(almacen,garage,cash);
                    int length = 0;
                    for (int i = 0; i < 5; i++) {
                        if(!garage[i].getcars().isBlank()){
                            length++;
                        }
                    }
                    if(check +1 == length){
                        cash = cash - garage[check].getPrecio();
                    }
                    break;
                }//fin case1
                
                case 2:{
                    System.out.println("---Vender un vehiculo");
                    int check = 0;
                    for (int i = 0; i < 5; i++) {
                        if(!garage[i].getcars().isBlank()){
                            check++;
                        }
                    }
                    Venta(garage);
                    int length = 0;
                    for (int i = 0; i < 5; i++) {
                        if(!garage[i].getcars().isBlank()){
                            length++;
                        }
                    }
                    if(check -1 == length){
                        cash = cash + 100000;
                    }
                    break;
                }//fin case2
                
                case 3:{
                    System.out.println("---Vehiculos en el garage");
                    listaautos(garage);
                    break;
                }//fin case3
                
                case 4:{
                    System.out.println("---Carreras nocturnas");
                    correr(autoprinc,almacen);
                    break;
                }//fin case4
                
                case 5:{
                    System.out.println("---Seleccionar auto");
                    int plaza = 0;
                    while(plaza < 1 || plaza > 5){
                        System.out.print("Ingrese la plaza en el garage del auto que quiere usar: ");
                        plaza = leer.nextInt();
                    }
                    plaza = plaza-1;
                    if(garage[plaza] == garage[seleccion]){
                        System.out.println("Ya estas usando ese auto...");
                    }else if(garage[plaza].getcars().isBlank()){
                        System.out.println("No tienes tantos autos...");
                    }else{
                        autoprinc = garage[plaza];
                        seleccion = plaza;
                    }
                    break;
                }//fin case 5
                
                case 6:{
                    System.out.println("---Mejorar auto");
                    System.out.println("El auto que mejoraras sera el principal, quieres seguir?[S/N]");
                    char resp = leer.next().charAt(0);
                    if(resp == 'n' || resp == 'N'){
                        System.out.println("Okay, cuando quieras...");
                    }else{
                        System.out.println("Bienvenido/a de vuelta a JDM Market\nQue podemos hacer hoy por ti?");
                        autoprinc = mejorar(autoprinc);
                    }
                    break;
                }//fin case 6
                
                case 7:{
                    System.out.println("---Trabajar...");
                    System.out.println("Condeguiste un empleo temporal para ganar fondos...");
                    int ganancia = 1;
                    while(ganancia % 1000 != 0){
                        ganancia = rand.nextInt(15000-1000+1)+1000;
                    }
                    cash += ganancia;
                    System.out.println("Has ganado "+ganancia+"$ trabajando...");
                    System.out.println("Recuerda, esta no es la mejor forma de ganar dinero...");
                    break;
                }//fin case 7
                
                case 8:{
                    System.out.println("Ha salido del programa...");
                    var = false;
                    break;
                }//fin case 8
                
                default:{
                    System.out.println("opcion no valida");
                    break;
                }//fin default
                
            }//fin switch
            System.out.println("\n");
            almacen = spawn_Autos(almacen);
        }while (var);//fin so while
        
    }//fin main
    
    public static Auto mejorar(Auto auto){
        char resp = 's';
        while(resp == 'S' || resp == 's'){
            System.out.println("1) Mejorar motor");
            System.out.println("2) Mejorar turbo");
            System.out.println("3) Reconfigurar computadora");
            int op = 0;
            while(op < 1 || op > 3){
                System.out.print("Ingrese una opcion: ");
                op = leer.nextInt();
            }
            switch (op) {
                case 1:{
                    System.out.println("Motor 3.8\nPrecio: 150000$");
                    if(cash < 150000){
                        System.out.println("No tienes suficiente dinero");
                    }else if(cash > 150000 && !auto.getMotor().contains("3.8")){
                        System.out.println("Compraste un mejor motor");
                        cash = cash-150000;
                        auto.setMotor("3.8");
                        int nprice = auto.getPrecio() + 150000;
                        auto.setPrecio(nprice);
                        int nhp = auto.getHP() + 136;
                        auto.setHP(nhp);
                        double nCaC = auto.getCaC() - 0.9;
                        auto.setCaC(nCaC);
                        int nVmax = auto.getVmax()+ 50;
                        auto.setVmax(nVmax);
                    }else if(auto.getMotor().contains("3.8")){
                        System.out.println("Ya tienes un 3.8");
                    }
                    break;
                }
                case 2:{
                    System.out.println("Twin Turbo\nPrecio: 22000$");
                    if(cash < 22000){
                        System.out.println("No tienes suficiente dinero");
                    }else if(cash > 22000 && !auto.getTurbo().contains("Twin")){
                        System.out.println("Compraste un turbo");
                        cash = cash-22000;
                        auto.setTurbo("Twin Turbo");
                        int nprice = auto.getPrecio() + 22000;
                        auto.setPrecio(nprice);
                        int nhp = auto.getHP() + 65;
                        auto.setHP(nhp);
                        double nCaC = auto.getCaC() - 1.9;
                        auto.setCaC(nCaC);
                        int nVmax = auto.getVmax() + 60;
                        auto.setVmax(nVmax);
                    }else if(auto.getTurbo().contains("Twin")){
                        System.out.println("Ya tienes un twin turbo");
                    }
                    break;
                }
                case 3:{
                    System.out.println("Ecu Reconfigurada\nPrecio: 52000$");
                    if(cash < 52000){
                        System.out.println("No tienes suficiente dinero");
                    }else if(cash > 52000 && !auto.getECU().contains("Reconfigurada")){
                        System.out.println("La computadora ha sido reconfigurada");
                        cash = cash-52000;
                        auto.setECU("Reconfigurada");
                        int nprice = auto.getPrecio() + 52000;
                        auto.setPrecio(nprice);
                        int nhp = auto.getHP() + 235;
                        auto.setHP(nhp);
                        double nCaC = auto.getCaC() - 1.6;
                        auto.setCaC(nCaC);
                        int nVmax = auto.getVmax()+ 54;
                        auto.setVmax(nVmax);
                    }else if(auto.getECU().contains("Reconfigurada")){
                        System.out.println("La computadora ya esta reconfigurada");
                    }
                    break;
                }
                default:{
                    System.out.println("Opcion no valida");
                }
            }
            System.out.println("Hay algo mas que quieras modificar?[S/N]");
            resp = leer.next().charAt(0);
            if(cash < 0){
                cash = 0;
            }
        }
        return auto;
    }//fin mejorar
    
    public static Auto [] spawn_Garage(Auto garage []){
        for (int i = 0; i < 5; i++) {
            if(i > 0){
                Auto nuevoAuto = new Auto("",0,0,0.0,0,"","","","",0);
                garage[i] = nuevoAuto;
            }else{
                int Peso = rand.nextInt(2000-1000+1)+1000;
                Auto nuevoAuto = new Auto("HONDA CIVIC TYPE R",127000,453,7.4,197,"ROJO","1.8","Turbo simple","Original",Peso);
                garage[i] = nuevoAuto;
            }
        }
        return garage;
    }//fin Garage
    
    public static Auto [] espacio(Auto autos [], int i){
        Auto añadir = new Auto("",0,0,0.0,0,"","","","",0);
        autos[i] = añadir;
        return autos;
    }//fin espacio
    
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
    }//fin spawn_Autos
    
    public static void Autos(Auto [] autos){
        System.out.println();
        for (int i = 0; i < autos.length; i++) {
            if(!autos[i].getcars().equals("")){
                System.out.println(i+1+ ")" + autos[i]);
            }
        }
    }//fin Autos
    
    public static void correr(Auto auto, Auto almacen []){
        System.out.println("Okay, veo que quieres ganar un dinerito extra...\nSi ganas te llevas 50000 $, pero si pierdes pagas 50000$\nPREPARATE");
        System.out.println("Tu rival:");
        int x = rand.nextInt(50);
        Auto rival = almacen[x];
        System.out.println("Auto: "+rival.getcars());
        System.out.println("Motor: "+rival.getMotor());
        System.out.println("Velocidad maxima: "+rival.getVmax());
        System.out.println("HP: "+rival.getHP());
        System.out.print("\nSolo te podemos decir eso, que dices puedes ganar?[S/N]: ");
        char resp = leer.next().charAt(0);
        if(resp == 's' || resp == 'S'){
            System.out.println("Bien, te deseo suerte...");
            int player1 = auto.getVmax() / 10;
            int player2 = rival.getVmax() / 10;
            int vel1 = auto.getVmax() / 20;
            int vel2 = rival.getVmax() / 20;
            while(player1 < 100 && player2 < 100){
                if(player1>10){
                    System.out.print("\nPlayer 1:"+player1+"%"+"   -");
                    if(player1>20){
                        System.out.print("-");
                        if(player1>40){
                            System.out.print("-");
                            if(player1>60){
                                System.out.print("-");
                                if(player1>80){
                                    System.out.print("-");
                                    if(player1>100){
                                        System.out.print("-");
                                    }
                                }
                            }
                        }
                    }
                }
                if(player2>10){
                    System.out.print("\nPlayer 2:"+player2+"%"+"   -");
                    if(player2>20){
                        System.out.print("-");
                        if(player2>40){
                            System.out.print("-");
                            if(player2>60){
                                System.out.print("-");
                                if(player2>80){
                                    System.out.print("-");
                                    if(player2>100){
                                        System.out.print("-");
                                    }
                                }
                            }
                        }
                    }
                }
                player1 += vel1;
                player2 += vel2;
                System.out.println("\nIngresa 1 para continuar");//visualizacion de carrera
                if(player1-player2 > 15 && !rival.getTurbo().contains("simple")){
                    player2 = player2 + 20;
                }else if(player2-player1 > 15 && !auto.getTurbo().contains("simple")){
                    player1 = player1 + 20;
                }
                int v  = leer.nextInt();
            }
            if(player1 > player2){
                System.out.println("\nFelicidades, GANASTE!!!\nDeberia de volver a correr mas veces");
                cash = cash + 50000;
            }else if(player2 > player1){
                System.out.println("\nMe lo esperaba...\nDeberias de mejorar tu auto...");
                cash = cash - 50000;
            }else if(player1 == player2){
                System.out.println("WOOOW, un empate!!!\nNo ganas ni pierdes dinero");
            }
        }else{
            System.out.println("En ese caso no se para que viniste.....");
        }
    }
    
}//fin class JDMMARK_CFlores_CDominguez
