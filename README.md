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
| Hibernate / JPA | 6.x | ORM (mapeo objeto-relacional) |
| Lombok | 1.18.x | Reducir código repetitivo |
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

## 🚀 Instalación y configuración

### 1. Clonar el repositorio

```bash
git clone https://github.com/TU_USUARIO/inventario-api.git
cd inventario-api
```

### 2. Crear la base de datos en MySQL

Abre MySQL Workbench y ejecuta:

```sql
CREATE DATABASE inventario_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE inventario_db;
```

Luego ejecuta el script completo que encontrarás en `src/main/resources/schema.sql`.

### 3. Configurar la conexión

Edita el archivo `src/main/resources/application.properties` con tus datos de MySQL:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/inventario_db
spring.datasource.username=root
spring.datasource.password=TU_CONTRASEÑA
```

### 4. Ejecutar el proyecto

Desde IntelliJ: botón ▶ Run, o desde terminal:

```bash
./mvnw spring-boot:run
```

El servidor arranca en `http://localhost:8080`

---

## 📁 Estructura del proyecto

```
src/main/java/com/inventario/
├── InventarioApiApplication.java      ← Punto de entrada
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
    ├── ResourceNotFoundException.java
    └── GlobalExceptionHandler.java
```

---

## 🗄️ Base de datos

El proyecto usa 5 tablas relacionadas entre sí:

```
usuarios          equipos
─────────         ────────────────
id (PK)           id (PK)
nombre            tipo
cargo             marca
departamento      modelo
                  numero_serie
                  estado
                  ubicacion
      │                 │
      └────┬────────────┘
           ▼
      asignaciones
      ─────────────
      id (PK)
      id_equipo (FK)
      id_usuario (FK)
      fecha_asignacion

mantenimiento          software
──────────────         ────────────────
id (PK)                id (PK)
id_equipo (FK)         nombre
tipo                   version
fecha                  licencia
descripcion            fecha_expiracion
```

---

## 🌐 Endpoints de la API

### Equipos — `/api/equipos`

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/equipos` | Lista todos los equipos |
| GET | `/api/equipos/{id}` | Obtiene un equipo por ID |
| GET | `/api/equipos/disponibles` | Lista equipos disponibles |
| POST | `/api/equipos` | Registra un nuevo equipo |
| PUT | `/api/equipos/{id}` | Actualiza un equipo |
| DELETE | `/api/equipos/{id}` | Elimina un equipo |

### Usuarios — `/api/usuarios`

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/usuarios` | Lista todos los usuarios |
| GET | `/api/usuarios/{id}` | Obtiene un usuario por ID |
| POST | `/api/usuarios` | Crea un nuevo usuario |
| PUT | `/api/usuarios/{id}` | Actualiza un usuario |
| DELETE | `/api/usuarios/{id}` | Elimina un usuario |

### Asignaciones — `/api/asignaciones`

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/asignaciones` | Lista todas las asignaciones |
| POST | `/api/asignaciones` | Asigna un equipo a un usuario |
| DELETE | `/api/asignaciones/{id}` | Elimina una asignación |

### Mantenimiento — `/api/mantenimiento`

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/mantenimiento` | Lista todos los registros |
| GET | `/api/mantenimiento/equipo/{id}` | Mantenimientos de un equipo |
| POST | `/api/mantenimiento` | Registra un mantenimiento |
| PUT | `/api/mantenimiento/{id}` | Actualiza un registro |

### Software — `/api/software`

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/software` | Lista todo el software |
| GET | `/api/software/expirados` | Licencias expiradas |
| POST | `/api/software` | Añade una licencia |
| PUT | `/api/software/{id}` | Actualiza una licencia |
| DELETE | `/api/software/{id}` | Elimina una licencia |

---

## 🧪 Cómo probar con Postman

Ejemplo de body para **crear un equipo** (`POST /api/equipos`):

```json
{
  "tipo": "Portátil",
  "marca": "Dell",
  "modelo": "Latitude 5420",
  "numeroSerie": "SN-001",
  "estado": "disponible",
  "ubicacion": "Almacén"
}
```

Ejemplo de body para **crear una asignación** (`POST /api/asignaciones`):

```json
{
  "idEquipo": 1,
  "idUsuario": 2,
  "fechaAsignacion": "2024-05-26"
}
```

Las respuestas usan códigos HTTP estándar:

- `200 OK` — consulta o actualización correcta
- `201 Created` — recurso creado correctamente
- `204 No Content` — eliminación correcta
- `404 Not Found` — recurso no encontrado

---

## 👩‍💻 Autora

**Alicia** — 1º DAW  
Proyecto final de módulo
