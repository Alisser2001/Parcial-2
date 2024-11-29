package com.example.parcial.service.interfaces;

import com.example.parcial.dto.ProductoResponseDTO;
import com.example.parcial.entity.impl.ProductoEntityImpl;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IAlmacenService {
    List<ProductoResponseDTO> getProductosByIdAlmacen(Long id);
    String addProductoToAlmacen(Long id, ProductoEntityImpl producto, Integer cantidad);
}
