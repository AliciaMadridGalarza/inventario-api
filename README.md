# 🖥️ Sistema de Gestión de Inventario Informático

API REST desarrollada con **Spring Boot** para gestionar el inventario de hardware y software de una organización. Permite registrar equipos, asignarlos a empleados, hacer seguimiento de mantenimientos y gestionar licencias de software.

> Proyecto de 1º DAW — proyecto trainee

---

## 🛠️ Tecnologías

| Tecnología | Versión | Para qué se usa |
|---|---|---|
| Java | 21 (LTS) | Lenguaje principal |
| Spring Boot | 3.x | Framework para la API REST |
| Maven | 3.x | Gestión de dependencias |
| MySQL | 8.x | Base de datos |
| Postman | - | Pruebas de endpoints |

---

## ✅ Requisitos previos

Antes de ejecutar el proyecto necesitas tener instalado:

- [JDK 21](https://adoptium.net) — Java Development Kit
- [IntelliJ IDEA Community](https://www.jetbrains.com/idea/download/)
- [MySQL 8](https://dev.mysql.com/downloads/installer/) + MySQL Workbench
- [Git](https://git-scm.com)
- [Postman](https://www.postman.com/downloads/)

---

## 📁 Estructura del proyecto

```
src/main/java/com/inventario/
├── InventarioApiApplication.java     
├── controller/
│   ├── EquipoController.java
│   ├── UsuarioController.java
│   ├── AsignacionController.java
│   ├── MantenimientoController.java
│   └── SoftwareController.java
├── service/
│   ├── EquipoService.java
│   ├── UsuarioService.java
│   ├── AsignacionService.java
│   ├── MantenimientoService.java
│   └── SoftwareService.java
├── repository/
│   ├── EquipoRepository.java
│   ├── UsuarioRepository.java
│   ├── AsignacionRepository.java
│   ├── MantenimientoRepository.java
│   └── SoftwareRepository.java
├── model/
│   ├── Equipo.java
│   ├── Usuario.java
│   ├── Asignacion.java
│   ├── Mantenimiento.java
│   └── Software.java
└── exception/
    └── ResourceNotFoundException.java

---

## 👩‍💻 Autora

**Alicia** — 1º DAW  
Proyecto final del módulo trainee
