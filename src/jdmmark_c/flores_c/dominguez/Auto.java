package jdmmark_c.flores_c.dominguez;

import java.util.Scanner;
import java.util.Random;
import static jdmmark_c.flores_c.dominguez.JDMMARK_CFlores_CDominguez.Autos;



public class Auto {
    
    static Scanner leer = new Scanner(System.in);
    static Random rand = new Random();//sera utilizado para seleccionar las partes de autos cuando veamos arraylists
    
    public String Marca;
    public String Modelo;
    public int Precio;//costo tanto de venta como compra
    public int HP;//Horsepower
    public double CaC;//de cero a cien
    public int Vmax;//velocidad maxima
    public String Paint;
    public String Estado;//Condiciones del auto
    public String Motor;
    public String Turbo;
    public String ECU;
    public int Peso;

    public Auto(String Marca, String Modelo, int Precio, int HP, double CaC, int Vmax, String Paint, String Estado, String Motor, String Turbo, String ECU, int Peso) {
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Precio = Precio;
        this.HP = HP;
        this.CaC = CaC;
        this.Vmax = Vmax;
        this.Paint = Paint;
        this.Estado = Estado;
        this.Motor = Motor;
        this.Turbo = Turbo;
        this.ECU = ECU;
        this.Peso = Peso;
    }

    public static void Compra(Auto almacen []){
        System.out.println("Bien!!!\nEn ese caso en que estas interesado/a??");
        System.out.println("1)Honda\n2)Nissan\n3)Acura\n4)Mitsubishi\n5)Toyota");
        int marc = leer.nextInt();
        Autos(almacen);
    }
    
    public static void Venta(Auto garage []){
        System.out.println("OK\nQue tienes para ofrecer?");
        System.out.print("Ingrese un auto de su garage para vender:");
        int pos = leer.nextInt();
        if(garage[pos].getModelo().isBlank()){
            int x = pos - 1;
            System.out.println("Disculpa pero solo tienes "+x+" en tu garage");
        }
    }
    
    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
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

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
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
