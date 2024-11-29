package com.example.parcial.entity.impl;

import com.example.parcial.entity.interfaces.IProductoEntity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "productos")
public class ProductoEntityImpl implements IProductoEntity, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private BigInteger id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "precio", nullable = false)
    private Double precio;

    @Column(name = "id_categoria", nullable = false)
    private BigInteger idCategoria;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false, insertable = false, updatable = false)
    private CategoriaEntityImpl categoria;

    public ProductoEntityImpl() {
    }

    public ProductoEntityImpl(String nombre, String descripcion, Double precio, BigInteger idCategoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.idCategoria = idCategoria;
    }

    @Override
    public BigInteger getId() {
        return id;
    }

    @Override
    public void setId(BigInteger id) {
        this.id = id;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public Double getPrecio() {
        return precio;
    }

    @Override
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public BigInteger getIdCategoria() {
        return idCategoria;
    }

    @Override
    public void setIdCategoria(BigInteger idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public CategoriaEntityImpl getCategoria() {
        return categoria;
    }

    @Override
    public void setCategoria(CategoriaEntityImpl categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoEntityImpl that = (ProductoEntityImpl) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "ProductoEntityImpl{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", idCategoria=" + idCategoria +
                '}';
    }
}

