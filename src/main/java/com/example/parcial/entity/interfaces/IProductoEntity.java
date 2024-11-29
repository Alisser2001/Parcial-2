package com.example.parcial.entity.interfaces;

import com.example.parcial.entity.impl.CategoriaEntityImpl;

import java.math.BigInteger;
import java.util.Date;

public interface IProductoEntity {
    // Getters
    BigInteger getId();
    String getNombre();
    String getDescripcion();
    Double getPrecio();
    BigInteger getIdCategoria();
    CategoriaEntityImpl getCategoria();

    // Setters
    void setId(BigInteger id);
    void setNombre(String nombre);
    void setDescripcion(String descripcion);
    void setPrecio(Double precio);
    void setIdCategoria(BigInteger idCategoria);
    void setCategoria(CategoriaEntityImpl categoria);
}
