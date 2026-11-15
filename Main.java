package RentaESFOT;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Vehiculos> registro = new ArrayList<>();
        HashSet<String> placas = new HashSet<>();

        while (true) {
            System.out.println("\n--- MENU RENTAESFOT ---");
            System.out.println("1. Registrar auto");
            System.out.println("2. Registrar camioneta");
            System.out.println("3. Mostrar vehiculos");
            System.out.println("4. Cotizar alquiler");
            System.out.println("5. Mostrar estadisticas");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opcion: ");
            int opcion = Integer.parseInt(sc.nextLine());

            if (opcion == 1) {
                System.out.print("Placa: ");
                String placa = sc.nextLine().toUpperCase();
                if (placas.contains(placa)) {
                    System.out.println("La placa " + placa + " ya esta registrada.");
                    continue;
                }
                System.out.print("Marca: ");
                String marca = sc.nextLine();
                System.out.print("Modelo: ");
                String modelo = sc.nextLine();
                System.out.print("Tarifa base: ");
                double tarifa = Double.parseDouble(sc.nextLine());
                if (tarifa < 0) {
                    System.out.println("La tarifa no puede ser negativa.");
                    continue;
                }
                System.out.print("Numero de puertas: ");
                int puertas = Integer.parseInt(sc.nextLine());

                System.out.print("Tiene aire acondicionado? (S/N): ");
                String aire = sc.nextLine();
                boolean tieneAireAcondicionado;
                if (aire.equalsIgnoreCase("S")) {
                    tieneAireAcondicionado = true;
                } else {
                    tieneAireAcondicionado = false;
                }

                if (placas.add(placa)) {
                    registro.add(new Auto(placa, marca, modelo, tarifa, puertas, tieneAireAcondicionado));
                    System.out.println("Auto registrado exitosamente.");
                } else {
                    System.out.println("La placa " + placa + " ya esta registrada.");
                }

            } else if (opcion == 2) {
                System.out.print("Placa: ");
                String placa = sc.nextLine().toUpperCase();
                if (placas.contains(placa)) {
                    System.out.println("La placa " + placa + " ya esta registrada.");
                    continue;
                }
                System.out.print("Marca: ");
                String marca = sc.nextLine();
                System.out.print("Modelo: ");
                String modelo = sc.nextLine();
                System.out.print("Tarifa base: ");
                double tarifa = Double.parseDouble(sc.nextLine());
                if (tarifa < 0) {
                    System.out.println("La tarifa no puede ser negativa.");
                    continue;
                }
                System.out.print("Capacidad de carga (t): ");
                double carga = Double.parseDouble(sc.nextLine());
                if (carga < 0) {
                    System.out.println("La capacidad de carga no puede ser negativa.");
                    continue;
                }

                if (placas.add(placa)) {
                    registro.add(new Camioneta(placa, marca, modelo, tarifa, carga));
                    System.out.println("Camioneta registrada exitosamente.");
                } else {
                    System.out.println("La placa " + placa + " ya esta registrada.");
                }

            } else if (opcion == 3) {
                if (registro.isEmpty()) {
                    System.out.println("No hay vehiculos registrados.");
                } else {
                    for (Vehiculos v : registro) {
                        System.out.println(v);
                    }
                }

            } else if (opcion == 4) {
                if (registro.isEmpty()) {
                    System.out.println("No hay vehiculos registrados.");
                    continue;
                }
                System.out.print("Placa: ");
                String placa = sc.nextLine().toUpperCase();

                Vehiculos encontrado = null;
                for (Vehiculos v : registro) {
                    if (v.getPlaca().equals(placa)) {
                        encontrado = v;
                    }
                }
                if (encontrado == null) {
                    System.out.println("La placa " + placa + " no existe.");
                    continue;
                }

                System.out.print("Dias: ");
                int dias = Integer.parseInt(sc.nextLine());
                if (dias <= 0) {
                    System.out.println("Los dias deben ser mayores que 0.");
                    continue;
                }

                System.out.print("Aplicar descuento? (S/N): ");
                String respuesta = sc.nextLine();
                if (respuesta.equalsIgnoreCase("S")) {
                    System.out.print("Porcentaje de descuento: ");
                    double descuento = Double.parseDouble(sc.nextLine());
                    if (descuento < 0 || descuento > 50) {
                        System.out.println("El descuento debe estar entre 0 y 50 %.");
                        continue;
                    }
                    System.out.printf("Total a pagar: $%.2f%n", encontrado.calcularAlquiler(dias, descuento));
                } else {
                    System.out.printf("Total a pagar: $%.2f%n", encontrado.calcularAlquiler(dias));
                }

            } else if (opcion == 5) {
                if (registro.isEmpty()) {
                    System.out.println("No hay vehiculos registrados.");
                    continue;
                }

                Vehiculos mayor = registro.get(0);
                double suma = 0;
                for (Vehiculos v : registro) {
                    suma += v.calcularTarifaDiaria();
                    if (v.calcularTarifaDiaria() > mayor.calcularTarifaDiaria()) {
                        mayor = v;
                    }
                }
                System.out.printf("Vehiculo con mayor tarifa diaria: %s %s ($%.2f)%n",
                        mayor.getMarca(), mayor.getModelo(), mayor.calcularTarifaDiaria());
                System.out.printf("Promedio de tarifas diarias: $%.2f%n", suma / registro.size());

            } else if (opcion == 6) {
                System.out.println("Hasta luego.");
                break;

            } else {
                System.out.println("Opcion no valida.");
            }
        }
    }
}