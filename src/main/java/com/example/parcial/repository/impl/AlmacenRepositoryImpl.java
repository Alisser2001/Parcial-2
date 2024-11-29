package com.example.parcial.repository.impl;

import com.example.parcial.dto.ProductoResponseDTO;
import com.example.parcial.entity.impl.ProductoEntityImpl;
import com.example.parcial.repository.interfaces.IAlmacenRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public class AlmacenRepositoryImpl implements IAlmacenRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public List<ProductoResponseDTO> getProductosByIdAlmacen(Long idAlmacen) {
        List<Object[]> results = entityManager.createNativeQuery(
                        "SELECT p.id, p.nombre, p.descripcion, p.precio, pa.cantidad " +
                                "FROM productos p " +
                                "JOIN productos_almacen pa ON p.id = pa.id_producto " +
                                "WHERE pa.id_almacen = ?")
                .setParameter(1, idAlmacen)
                .getResultList();

        return results.stream()
                .map(row -> new ProductoResponseDTO(
                        ((Number) row[0]).longValue(),   // idProducto
                        (String) row[1],                // nombre
                        (String) row[2],                // descripcion
                        ((Number) row[3]).doubleValue(),// precio
                        ((Number) row[4]).longValue()   // cantidad
                ))
                .toList();
    }

    @Transactional
    @Override
    public String addProductoToAlmacen(Long id, ProductoEntityImpl producto, Integer cantidad) {
        try {
            int idProducto = entityManager.createNativeQuery(
                            "INSERT INTO productos (nombre, descripcion, precio, id_categoria) " +
                                    "VALUES (?, ?, ?, ?) RETURNING id")
                    .setParameter(1, producto.getNombre())
                    .setParameter(2, producto.getDescripcion())
                    .setParameter(3, producto.getPrecio())
                    .setParameter(4, producto.getIdCategoria())
                    .executeUpdate();

            entityManager.createNativeQuery(
                            "INSERT INTO productos_almacen (id_almacen, id_producto, cantidad) " +
                                    "VALUES (?, ?, ?)")
                    .setParameter(1, id)
                    .setParameter(2, idProducto)
                    .setParameter(3, cantidad)
                    .executeUpdate();

            return "Producto añadido al almacén exitosamente.";
        } catch (Exception e) {
            return "Error al añadir el producto al almacén: " + e.getMessage();
        }
    }
}
