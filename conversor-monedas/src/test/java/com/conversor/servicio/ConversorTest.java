package com.conversor.servicio;

import com.conversor.api.ClienteTasas;
import com.conversor.modelo.RespuestaTasaCambio;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConversorTest {
    @Test
    void convertirUsdAArs_devuelveValorCorrecto() {
        // Arrange (preparar datos)
        FakeApiClient fAC = new FakeApiClient();

        Conversor conversor = new Conversor(fAC);

        // Act (ejecutar)
        double resultado = conversor.convertir(2, "USD", "ARS");

        // Assert (verificar)
        assertEquals(200.0, resultado);
    }

    @Test
    void convertir_monedaInexistente_lanzaExcepcion() {
        // Arrange
        FakeApiClient fAC = new FakeApiClient();

        Conversor conversor = new Conversor(fAC);

        // Act + Assert
        assertThrows(ConversionException.class, () -> {
            conversor.convertir(1, "USD", "XXX");
        });
    }

    @Test
    void convertir_cuandoApiFalla_lanzaConversionException() {
        // Arrange
        FakeApiClientError fAC = new FakeApiClientError();
        Conversor conversor = new Conversor(fAC);

        // Act + Assert
        assertThrows(ConversionException.class, () -> {
            conversor.convertir(1, "USD", "ARS");
        });
    }

}

class FakeApiClient implements ClienteTasas {
    public RespuestaTasaCambio obtenerTasas(String codigoBase) {
        Map<String, Double> tasas = new HashMap<>();
        tasas.put("ARS", 100.0);
        return new RespuestaTasaCambio(tasas);
    }
}

class FakeApiClientError implements ClienteTasas {
    public RespuestaTasaCambio obtenerTasas(String codigoBase) {
        throw new RuntimeException("Error de red");
    }
}
