package jdmmark_c.flores_c.dominguez;

import java.util.Scanner;
import java.util.Random;
import static jdmmark_c.flores_c.dominguez.JDMMARK_CFlores_CDominguez.Autos;



public class Auto {
    
    static Scanner leer = new Scanner(System.in);
    static Random rand = new Random();//sera utilizado para seleccionar las partes de autos cuando veamos arraylists
    
    public String cars;
    public int Precio;//costo tanto de venta como compra
    public int HP;//Horsepower
    public double CaC;//de cero a cien
    public int Vmax;//velocidad maxima
    public String Paint;
    public String Motor;
    public String Turbo;
    public String ECU;
    public int Peso;

    public Auto(String cars, int Precio, int HP, double CaC, int Vmax, String Paint, String Motor, String Turbo, String ECU, int Peso) {
        this.cars = cars;
        this.Precio = Precio;
        this.HP = HP;
        this.CaC = CaC;
        this.Vmax = Vmax;
        this.Paint = Paint;
        this.Motor = Motor;
        this.Turbo = Turbo;
        this.ECU = ECU;
        this.Peso = Peso;
    }

    @Override
    public String toString() {
        return "Auto: " + cars + "\nPrecio: " + Precio + " $\nHP: " + HP + "\nCero a Cien: " + CaC + " segundos\nVelocidad maxima: " + Vmax + " km/h\nColor: " + Paint + "\nMotor: " + Motor + "\nTurbo: " + Turbo + "\nECU: " + ECU + "\nPeso: " + Peso + "kg";
    }
    

    public static Auto []  Compra(Auto almacen [], Auto garage [], int cash){
        int car = 0;
        boolean buy = true;
        while(car < 1 || car > 50){
            System.out.print("Bien!!!\nIngrese una plaza para revisar en el almacen[1-50]:");
            car = leer.nextInt()-1;
        }
        System.out.print(almacen[car].getcars()+"\n"+almacen[car].getPrecio()+"\nNo te podemos dar mas informacion, deseas comprarlo?[S/N]: ");
        char resp = leer.next().charAt(0);
        if(cash < almacen[car].getPrecio()){
            System.out.println("No tienes suficiente dinero");
            buy = false;
        }
        if(resp == 'n' ||resp == 'N'){
            System.out.println("Esta bien, pero tu te lo pierdes...");
        }else if((resp == 's' ||resp == 'S') && buy == true){
            System.out.println("Trato hecho");
            Auto añadir = almacen[car];
            for (int i = 0; i < garage.length; i++) {
                if(garage[i].getcars().equals("")){
                    garage[i] = añadir;
                    break;
                }
            }
            Auto quitar = new Auto("",0,0,0.0,0,"","","","",0);
            almacen[car] = quitar;
        }
        return garage;
    }
    
    public static Auto [] Venta(Auto garage []){
        if(garage[1].getcars().isBlank()){
            System.out.println("No puedes vender tu primer auto");
        }else{
            System.out.println("ATENCION!!!\nLos autos usados se venden por 100000$...");
            System.out.println("OK\nQue tienes para ofrecer?");
            System.out.print("Ingrese un auto de su garage para vender:");
            int pos = leer.nextInt();
            if(garage[pos].getcars().isBlank()){
                int x = pos - 1;
                System.out.println("Disculpa pero solo tienes "+x+" en tu garage");
            }else{
                pos = pos -1;
                if(pos == 0){
                    System.out.println("No puedes vender tu primer auto");
                }else{
                    Auto quitar = new Auto("",0,0,0.0,0,"","","","",0);
                    garage[pos] = quitar;
                    System.out.println("Despidete de el....");
                }
            }
        }
        return garage;
    }
    
    public String getcars() {
        return cars;
    }

    public void setcars(String cars) {
        this.cars = cars;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public double getCaC() {
        return CaC;
    }

    public void setCaC(double CaC) {
        this.CaC = CaC;
    }

    public int getVmax() {
        return Vmax;
    }

    public void setVmax(int Vmax) {
        this.Vmax = Vmax;
    }

    public String getPaint() {
        return Paint;
    }

    public void setColor(String Color) {
        this.Paint = Color;
    }

    public String getMotor() {
        return Motor;
    }

    public void setMotor(String Motor) {
        this.Motor = Motor;
    }

    public String getTurbo() {
        return Turbo;
    }

    public void setTurbo(String Turbo) {
        this.Turbo = Turbo;
    }

    public String getECU() {
        return ECU;
    }

    public void setECU(String ECU) {
        this.ECU = ECU;
    }

    public int getPeso() {
        return Peso;
    }

    public void setPeso(int Peso) {
        this.Peso = Peso;
    }
            
    
}
