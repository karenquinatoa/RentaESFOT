package RentaESFOT;

public class Camioneta extends Vehiculos{
    private double toneladas;

    public Camioneta(String placa, String marca, String modelo, double tarifa_Base, double toneladas) {
        super(placa, marca, modelo, tarifa_Base);
        this.toneladas = toneladas;
    }

    public double getToneladas() {
        return toneladas;
    }

    @Override
    public double calcularTarifaDiaria() {

        if (toneladas > 1.5){
            return super.calcularTarifaDiaria() * 1.15;
        }
        return super.calcularTarifaDiaria();
    }

    @Override
    public String toString() {
        return String.format("[Camioneta] %s, carga %.1f t, Tarifa diaria: $%.2f",
                super.toString(), toneladas, calcularTarifaDiaria());
    }
}
