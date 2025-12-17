package com.conversor.app;

import java.util.Scanner;

import com.conversor.api.ApiClient;
import com.conversor.servicio.ConversionException;
import com.conversor.servicio.Conversor;

public class AplicacionConsola {

    public static void main(String[] args) {
        ApiClient apiClient = new ApiClient();
        Conversor conversor = new Conversor(apiClient);

        System.out.println("""
                *************************************************
                Sea bienvenido al Conversor de Monedas

                1) Dolar =>>> Peso Argentino
                2) Peso Argentino =>>> Dolar
                3) Dolar =>>> Real Brasileño
                4) Real Brasileño =>>> Dolar
                5)Dolar =>>> Peso Colombiano
                6) Peso Colombiano =>>> Dolar
                7) Salir
                Elija una opcion valida:
                *************************************************
                """);
        try (Scanner scanner = new Scanner(System.in)) {

            int opcion = scanner.nextInt();
            String[] monedas = obtenerMonedas(opcion);

            if (monedas == null) {
                System.out.println("Opción inválida");
                return;
            }

            System.out.print("Ingrese el monto a convertir: ");
            double monto = scanner.nextDouble();

            try {
                double resultado = conversor.convertir(monto, monedas[0], monedas[1]);
                System.out.println("Resultado: " + resultado);
            } catch (ConversionException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static String[] obtenerMonedas(int opcion) {
        return switch (opcion) {
            case 1 -> new String[] { "USD", "ARS" };
            case 2 -> new String[] { "ARS", "USD" };
            case 3 -> new String[] { "USD", "BRL" };
            case 4 -> new String[] { "BRL", "USD" };
            case 5 -> new String[] { "USD", "COP" };
            case 6 -> new String[] { "COP", "USD" };
            default -> null;
        };
    }

}
