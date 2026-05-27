/*
drop database inventario;

CREATE DATABASE inventario
CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE inventario_api;

CREATE TABLE usuarios (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  cargo ENUM('Tecnico', 'Administrador', 'Analista', 'Director', 'Becario') NOT NULL,
  departamento ENUM('Soporte', 'Sistemas', 'Desarrollo', 'IT') NOT NULL
);


CREATE TABLE software (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  version VARCHAR(30),
  licencia ENUM('OEM', 'Suscripcion', 'Anual', 'Libre') NOT NULL,
  fecha_expiracion DATE
);

CREATE TABLE equipos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  tipo ENUM('Portatil', 'Sobremesa', 'Servidor', 'Tablet') NOT NULL,
  marca ENUM('Dell', 'HP', 'Lenovo', 'Samsung') NOT NULL,
  modelo VARCHAR(100),
  numero_serie VARCHAR(100) UNIQUE,
  estado ENUM('disponible', 'asignado', 'mantenimiento', 'operativo') DEFAULT 'disponible',
  ubicacion ENUM('Oficina1', 'Oficina2', 'Taller', 'CPD', 'Almacen') NOT NULL,
  id_software INT,
  FOREIGN KEY (id_software) REFERENCES software(id)
);

CREATE TABLE asignaciones (
  id INT AUTO_INCREMENT PRIMARY KEY,
  id_equipo INT NOT NULL,
  id_usuario INT NOT NULL,
  fecha_asignacion DATE DEFAULT (CURRENT_DATE),
  FOREIGN KEY (id_equipo) REFERENCES equipos(id),
  FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);

CREATE TABLE mantenimiento (
  id INT AUTO_INCREMENT PRIMARY KEY,
  id_equipo INT NOT NULL,
  tipo ENUM('Correctivo', 'Preventivo') NOT NULL,
  fecha DATE,
  descripcion TEXT,
  FOREIGN KEY (id_equipo) REFERENCES equipos(id)
);
*/