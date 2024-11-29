package com.example.parcial.entity.interfaces;

import java.math.BigInteger;
import java.util.Date;

public interface IAlmacenEntity {
    // Getters
    BigInteger getId();
    String getNombre();
    String getDireccion();
    String getTelefono();
    Date getFechaCreacion();
    Date getFechaActualizacion();
    BigInteger getCapacidadMaxima();

    // Setters
    void setId(BigInteger id);
    void setNombre(String nombre);
    void setDireccion(String direccion);
    void setTelefono(String telefono);
    void setFechaCreacion(Date fechaCreacion);
    void setFechaActualizacion(Date fechaActualizacion);
    void setCapacidadMaxima(BigInteger capacidadMaxima);
}
