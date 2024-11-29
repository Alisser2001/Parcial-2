CREATE TABLE "productos"(
                            "id" bigserial NOT NULL,
                            "nombre" VARCHAR(255) NOT NULL,
                            "descripcion" VARCHAR(255) NOT NULL,
                            "precio" FLOAT(53) NOT NULL,
                            "id_categoria" BIGINT NOT NULL,
                            "fecha_creacion" DATE NOT NULL,
                            "fecha_actualizacion" DATE NOT NULL
);
ALTER TABLE
    "productos" ADD PRIMARY KEY("id");
CREATE TABLE "almacen"(
                          "id" bigserial NOT NULL,
                          "nombre" VARCHAR(255) NOT NULL,
                          "direccion" VARCHAR(255) NOT NULL,
                          "telefono" VARCHAR(255) NOT NULL,
                          "fecha_creacion" DATE NOT NULL,
                          "fecha_actualizacion" DATE NOT NULL,
                          "capacidad_maxima" BIGINT NOT NULL
);
ALTER TABLE
    "almacen" ADD PRIMARY KEY("id");
CREATE TABLE "productos_almacen"(
                                    "id" bigserial NOT NULL,
                                    "id_producto" BIGINT NOT NULL,
                                    "id_almacen" BIGINT NOT NULL,
                                    "cantidad" BIGINT NOT NULL
);
ALTER TABLE
    "productos_almacen" ADD PRIMARY KEY("id");
CREATE TABLE "categoria"(
                            "id" bigserial NOT NULL,
                            "nombre" VARCHAR(255) NOT NULL,
                            "descripcion" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "categoria" ADD PRIMARY KEY("id");
ALTER TABLE
    "productos_almacen" ADD CONSTRAINT "productos_almacen_id_almacen_foreign" FOREIGN KEY("id_almacen") REFERENCES "almacen"("id");
ALTER TABLE
    "productos" ADD CONSTRAINT "productos_id_categoria_foreign" FOREIGN KEY("id_categoria") REFERENCES "categoria"("id");
ALTER TABLE
    "productos_almacen" ADD CONSTRAINT "productos_almacen_id_producto_foreign" FOREIGN KEY("id_producto") REFERENCES "productos"("id");



INSERT INTO "categoria" ("nombre", "descripcion")
VALUES
    ('Electrónica', 'Productos electrónicos como computadoras, teléfonos, etc.'),
    ('Ropa', 'Ropa y accesorios de moda'),
    ('Alimentos', 'Comida y bebidas'),
    ('Muebles', 'Muebles para el hogar y oficina'),
    ('Juguetes', 'Juguetes y juegos para niños');

INSERT INTO "almacen" ("nombre", "direccion", "telefono", "fecha_creacion", "fecha_actualizacion", "capacidad_maxima")
VALUES
    ('Almacén Central', 'Calle Ficticia 123, Ciudad ABC', '123-456-7890', CURRENT_DATE, CURRENT_DATE, 5000),
    ('Almacén Norte', 'Avenida Ejemplo 456, Ciudad XYZ', '987-654-3210', CURRENT_DATE, CURRENT_DATE, 3000),
    ('Almacén Sur', 'Calle Real 789, Ciudad LMN', '555-666-7777', CURRENT_DATE, CURRENT_DATE, 4000),
    ('Almacén Oeste', 'Calle Secundaria 101, Ciudad PQR', '111-222-3333', CURRENT_DATE, CURRENT_DATE, 3500);

INSERT INTO "productos" ("nombre", "descripcion", "precio", "id_categoria", "fecha_creacion", "fecha_actualizacion")
VALUES
    ('Laptop', 'Laptop de 15 pulgadas con 8GB de RAM', 799.99, 1, CURRENT_DATE, CURRENT_DATE),
    ('Camiseta', 'Camiseta de algodón para hombre', 19.99, 2, CURRENT_DATE, CURRENT_DATE),
    ('Cereal', 'Cereal de maíz en caja', 2.99, 3, CURRENT_DATE, CURRENT_DATE),
    ('Sillón', 'Sillón de 3 puestos de tela', 299.99, 4, CURRENT_DATE, CURRENT_DATE),
    ('Muñeca', 'Muñeca de peluche para niñas', 12.99, 5, CURRENT_DATE, CURRENT_DATE);

INSERT INTO "productos_almacen" ("id_producto", "id_almacen", "cantidad")
VALUES
    (1, 1, 100),  -- Laptop en Almacén Central
    (2, 2, 200),  -- Camiseta en Almacén Norte
    (3, 3, 300),  -- Cereal en Almacén Sur
    (4, 4, 50),   -- Sillón en Almacén Oeste
    (5, 1, 150);  -- Muñeca en Almacén Central