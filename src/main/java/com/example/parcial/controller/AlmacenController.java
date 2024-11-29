package com.example.parcial.controller;

import com.example.parcial.dto.ProductoResponseDTO;
import com.example.parcial.entity.impl.ProductoEntityImpl;
import com.example.parcial.service.impl.AlmacenService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api/almacen")
public class AlmacenController {
    @Autowired
    private AlmacenService almacenService;

    @GetMapping("/{id}")
    public List<ProductoResponseDTO> getProductosByIdAlmacen(@PathVariable("id") Long id) {
        List<ProductoResponseDTO> productos = almacenService.getProductosByIdAlmacen(id);
        return productos;
    }

    @PostMapping("/{id}")
    public String addProductoToAlmacen(@PathVariable("id") Long id, @RequestBody ProductoEntityImpl producto, Integer cantidad) {
        String response  = almacenService.addProductoToAlmacen(id, producto, cantidad);
        return response;
    }
}
