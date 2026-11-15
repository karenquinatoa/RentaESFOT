package RentaESFOT;

public class Auto extends  Vehiculos{
    private int numeroPuertas;
    private boolean aireAcondicionado;

    public Auto(String placa, String marca, String modelo, double tarifa_Base, int numeroPuertas, boolean aireAcondicionado) {
        super(placa, marca, modelo, tarifa_Base);
        this.numeroPuertas = numeroPuertas;
        this.aireAcondicionado = aireAcondicionado;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public boolean isAireAcondicionado() {
        return aireAcondicionado;
    }

    @Override
    public double calcularTarifaDiaria() {
        double tarifa = super.calcularTarifaDiaria();
        if (aireAcondicionado){
            tarifa += 10;

        }
            return tarifa;
    }

    @Override
    public String toString() {
        return String.format("[Auto] %s, %d puertas, %s, Tarifa diaria: $%.2f",
                super.toString(), numeroPuertas,
                aireAcondicionado ? "con A/C" : "sin A/C", calcularTarifaDiaria());
    }
}
