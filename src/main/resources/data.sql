-- Categorías
INSERT INTO CATEGORIAPRODUCTO (nombre_categoria) VALUES ('Papelería');
INSERT INTO CATEGORIAPRODUCTO (nombre_categoria) VALUES ('Tecnología');
INSERT INTO CATEGORIAPRODUCTO (nombre_categoria) VALUES ('Arte');

-- Empleados
INSERT INTO EMPLEADO (nombre, turno) VALUES ('Juan Pérez', 'Mañana');
INSERT INTO EMPLEADO (nombre, turno) VALUES ('Ana Gómez', 'Tarde');

-- Proveedores
INSERT INTO PROVEEDOR (nombre, telefono, email) VALUES ('Distribuidora Central', '555-1234', 'contacto@central.com');
INSERT INTO PROVEEDOR (nombre, telefono, email) VALUES ('Papeles del Norte', '555-5678', 'ventas@norte.com');

-- Productos (ahora incluye nombre_proveedor)
INSERT INTO PRODUCTO (nombre, precio_compra, precio_venta, stock, nombre_proveedor, id_categoria) VALUES ('Cuaderno', 10.00, 15.00, 100, 'Distribuidora Central', 1);
INSERT INTO PRODUCTO (nombre, precio_compra, precio_venta, stock, nombre_proveedor, id_categoria) VALUES ('Lápiz', 2.00, 5.00, 200, 'Papeles del Norte', 1);
INSERT INTO PRODUCTO (nombre, precio_compra, precio_venta, stock, nombre_proveedor, id_categoria) VALUES ('USB 16GB', 50.00, 80.00, 50, 'Distribuidora Central', 2);

-- Ventas
INSERT INTO VENTA (fecha, id_empleado, total) VALUES (CURRENT_TIMESTAMP, 1, 30.00);
INSERT INTO VENTA (fecha, id_empleado, total) VALUES (CURRENT_TIMESTAMP, 2, 10.00);

-- Detalle de ventas
INSERT INTO DETALLEVENTA (id_venta, id_producto, cantidad, subtotal) VALUES (1, 1, 2, 30.00);
INSERT INTO DETALLEVENTA (id_venta, id_producto, cantidad, subtotal) VALUES (2, 2, 2, 10.00);