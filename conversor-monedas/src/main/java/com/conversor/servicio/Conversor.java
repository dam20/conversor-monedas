package com.conversor.servicio;
import com.conversor.api.ClienteTasas;
import com.conversor.modelo.RespuestaTasaCambio;

public class Conversor {
    private ClienteTasas apiClient;

    public Conversor(ClienteTasas apiClient) {
        this.apiClient = apiClient;
    }

  

    public double convertir( double monto, String monedaOrigen, String monedaDestino) {        
        try{
            RespuestaTasaCambio respuesta = apiClient.obtenerTasas(monedaOrigen);
            Double tasaCambio = respuesta.getTasasConversion().get(monedaDestino);
            if (tasaCambio == null) {
                throw new ConversionException("Moneda destino no encontrada: " + monedaDestino);
            }
            return monto * tasaCambio;

        }catch (ConversionException e) {
            throw e;
       }catch(Exception e){
            throw new ConversionException("Error al obtener tasas de cambio", e);
        }
    }
}
