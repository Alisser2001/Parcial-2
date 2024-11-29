package com.example.parcial.repository.interfaces;

import com.example.parcial.dto.ProductoResponseDTO;
import com.example.parcial.entity.impl.ProductoEntityImpl;

import java.util.List;

public interface IAlmacenRepository {
    List<ProductoResponseDTO> getProductosByIdAlmacen(Long id);
    String addProductoToAlmacen(Long id, ProductoEntityImpl producto, Integer cantidad);
}
