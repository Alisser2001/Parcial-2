package com.example.parcial.entity.interfaces;

import java.math.BigInteger;

public interface ICategoriaEntity {
    // Getters
    BigInteger getId();
    String getNombre();
    String getDescripcion();

    // Setters
    void setId(BigInteger id);
    void setNombre(String nombre);
    void setDescripcion(String descripcion);
}
