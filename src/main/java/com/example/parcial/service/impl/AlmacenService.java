package com.example.parcial.service.impl;

import com.example.parcial.dto.ProductoResponseDTO;
import com.example.parcial.entity.impl.ProductoEntityImpl;
import com.example.parcial.repository.impl.AlmacenRepositoryImpl;
import com.example.parcial.service.interfaces.IAlmacenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlmacenService implements IAlmacenService {
    @Autowired
    private AlmacenRepositoryImpl almacenRepository;

    @Override
    public List<ProductoResponseDTO> getProductosByIdAlmacen(Long id) {
        return almacenRepository.getProductosByIdAlmacen(id);
    }

    @Override
    public String addProductoToAlmacen(Long id, ProductoEntityImpl producto, Integer cantidad) {
        return almacenRepository.addProductoToAlmacen(id, producto, cantidad);
    }
}
