CREATE TABLE Proveedor (
    id_proveedor INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(20),
    email VARCHAR(100)
);

CREATE TABLE CategoriaProducto (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre_categoria VARCHAR(100) NOT NULL UNIQUE
);


CREATE TABLE Producto (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio_compra DECIMAL(10,2) NOT NULL,
    precio_venta DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL CHECK (stock >= 0), -- Supported in MySQL 8.0.16+
    nombre_proveedor VARCHAR(100) NOT NULL DEFAULT 'NA',
    id_categoria INT NOT NULL,
    FOREIGN KEY (id_categoria) REFERENCES CategoriaProducto(id_categoria)
);

CREATE TABLE Empleado (
    id_empleado INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    turno VARCHAR(50) NOT NULL
);

CREATE TABLE Venta (
    id_venta INT AUTO_INCREMENT PRIMARY KEY,
    fecha TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, -- TIMESTAMP in MySQL automatically updates on modification by default unless specified otherwise.
                                                      -- DATETIME can also be used if you don't want auto-update behavior.
    id_empleado INT NOT NULL,
    total DECIMAL(10,2) NOT NULL CHECK (total >= 0), -- Supported in MySQL 8.0.16+
    FOREIGN KEY (id_empleado) REFERENCES Empleado(id_empleado)
);

CREATE TABLE DetalleVenta (
    id_detalle INT AUTO_INCREMENT PRIMARY KEY,
    id_venta INT NOT NULL,
    id_producto INT NOT NULL,
    cantidad INT NOT NULL CHECK (cantidad > 0), -- Supported in MySQL 8.0.16+
    subtotal DECIMAL(10,2) NOT NULL CHECK (subtotal >= 0), -- Supported in MySQL 8.0.16+
    FOREIGN KEY (id_venta) REFERENCES Venta(id_venta) ON DELETE CASCADE,
    FOREIGN KEY (id_producto) REFERENCES Producto(id_producto)
);
