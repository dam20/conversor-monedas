package com.conversor.modelo;

import java.util.Map;

public class RespuestaTasaCambio {
    private String result;
    private String base_code;
    private Map<String, Double> conversion_rates;

    public RespuestaTasaCambio(Map<String, Double> conversion_rates) {
    this.conversion_rates = conversion_rates;
    }

    public String getResultado() {
        return result;
    }

    public String getCodigoBase() {
        return base_code;
    }

    public Map<String, Double> getTasasConversion() {
        return conversion_rates;
    }
}
