/*
datos de la base de datos

INSERT INTO usuarios (nombre, cargo, departamento) VALUES
('Ana Torres', 'Tecnico', 'Soporte'),
('Luis Martínez', 'Administrador', 'Sistemas'),
('María López', 'Analista', 'Desarrollo'),
('Carlos Pérez', 'Director', 'IT'),
('Sofía Gómez', 'Becario', 'Soporte');

INSERT INTO software (nombre, version, licencia, fecha_expiracion) VALUES
('Windows 10 Pro', '21H2', 'OEM', '2028-12-31'),
('Office 365', '2024', 'Suscripcion', '2025-05-10'),
('Antivirus Pro', '5.2', 'Anual', '2026-01-01'),
('Photoshop', '2023', 'Suscripcion', '2025-11-15'),
('Visual Studio Code', '1.90', 'Libre', NULL);

INSERT INTO equipos (tipo, marca, modelo, numero_serie, estado, ubicacion, id_software) VALUES
('Portatil', 'Dell', 'Latitude 5420', 'SN1001', 'disponible', 'Oficina1', 1),
('Sobremesa', 'HP', 'EliteDesk 800', 'SN1002', 'asignado', 'Oficina2', 2),
('Portatil', 'Lenovo', 'ThinkPad T14', 'SN1003', 'mantenimiento', 'Taller', 3),
('Servidor', 'Dell', 'PowerEdge R740', 'SN1004', 'operativo', 'CPD', 5),
('Tablet', 'Samsung', 'Galaxy Tab S7', 'SN1005', 'disponible', 'Almacen', 4);

INSERT INTO asignaciones (id_equipo, id_usuario, fecha_asignacion) VALUES
(2, 1, '2024-05-01'),
(1, 2, '2024-05-03'),
(3, 3, '2024-05-05'),
(5, 4, '2024-05-07'),
(4, 2, '2024-05-10');

INSERT INTO mantenimiento (id_equipo, tipo, fecha, descripcion) VALUES
(3, 'Correctivo', '2024-05-02', 'Reemplazo de disco duro'),
(1, 'Preventivo', '2024-05-04', 'Limpieza interna y revisión'),
(2, 'Correctivo', '2024-05-06', 'Fallo en la fuente de alimentación'),
(5, 'Preventivo', '2024-05-08', 'Actualización de firmware'),
(4, 'Correctivo', '2024-05-09', 'Sustitución de ventiladores');
*/