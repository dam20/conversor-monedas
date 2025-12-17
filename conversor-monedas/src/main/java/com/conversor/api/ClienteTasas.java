package com.conversor.api;

import com.conversor.modelo.RespuestaTasaCambio;

public interface ClienteTasas {
    RespuestaTasaCambio obtenerTasas(String codigoBase);
}
