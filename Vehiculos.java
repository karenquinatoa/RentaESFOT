package RentaESFOT;

public class Vehiculos {
    private String placa;
    private String marca;
    private String modelo;
    private double tarifa_Base;

    public Vehiculos(String placa, String marca, String modelo, double tarifa_Base) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.tarifa_Base = tarifa_Base;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double calcularTarifaDiaria(){
        return tarifa_Base;
    }

    public double calcularAlquiler(int dias){
        return calcularTarifaDiaria() * dias;
    }

    public double calcularAlquiler(int dias, double porcentajeDescuento){
        return  calcularAlquiler(dias) - (calcularAlquiler(dias) * porcentajeDescuento / 100);
    }

    @Override
    public String toString() {
        return placa + " " + marca + " " + modelo;
    }
}
